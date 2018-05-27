package io.nsu.hire.apiemails.service.impl;

import io.nsu.hire.apiemails.dao.EmailDao;
import io.nsu.hire.apiemails.dao.EmailTemplateDao;
import io.nsu.hire.apiemails.exception.EmailTemplateNotExist;
import io.nsu.hire.apiemails.model.Email;
import io.nsu.hire.apiemails.model.EmailProperty;
import io.nsu.hire.apiemails.model.EmailTemplate;
import io.nsu.hire.apiemails.service.EmailService;
import io.nsu.hire.apiemails.service.KeyGeneratorService;
import io.nsu.hire.apiemails.util.UtilsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;

@Service
public class EmailServiceImplDB implements EmailService {

	private static final String NOMBRE_HOST = "nsuconsulting.com";

	@Autowired
	private EmailDao emailDao;
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private EmailTemplateDao emailTemplateDao;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private KeyGeneratorService keyGeneratorService;

	@Override
	@Async
	public Email sendEmail(Email email, Context ctx, String templateName) throws MessagingException, EmailTemplateNotExist, IOException {
		EmailTemplate emailTemplate = findEmailTemplate(templateName);
		MimeMultipart content = new MimeMultipart("related");
		Properties props = getPropertiesFromTemplate(emailTemplate);
		Session session = Session.getInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailTemplate.getEmailAccount().getEmailAddress(), emailTemplate.getEmailAccount().getPassword());
					}
				});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(emailTemplate.getEmailAccount().getEmailAddress()));
		setDestinatarios(message, email);
		message.setSubject(messageSource.getMessage(emailTemplate.getSubject(), null, Locale.getDefault()));
		message.setHeader("Content-Type", "text/html; charset=UTF-8");
		//TEXT PART
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setContent(templateEngine.process(emailTemplate.getPath(), ctx), "text/html; charset=utf-8");
		content.addBodyPart(textPart);
		//IMAGE PART
		emailTemplate.getImages().forEach((k, v) -> {
			try {
				content.addBodyPart(createBodyPart(k, v));
			} catch (MessagingException e) {
				//TODO map an excpetion
				e.printStackTrace();
			} catch (IOException e) {
				//TODO add another exception
				e.printStackTrace();
			}
		});
		message.setContent(content);
		Transport.send(message);

		email.setCuerpo(textPart.getContent().toString());
		email.setAsunto(emailTemplate.getSubject());
		email.setSendBy(emailTemplate.getEmailAccount().getEmailAddress());
		return email;
	}


	private BodyPart createBodyPart(final String clave, final String image) throws IOException, MessagingException {
		MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.attachFile(getFileFromResouce(image));
		imagePart.setContentID(clave);
		imagePart.setDisposition(MimeBodyPart.INLINE);
		return imagePart;
	}

	private File getFileFromResouce(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}


	/**
	 * Seteo los destinatarios
	 *
	 * @param message
	 * @param email
	 * @throws MessagingException
	 */
	private void setDestinatarios(Message message, Email email) throws MessagingException {
		message.setRecipients(Message.RecipientType.TO, UtilsMapper.stringToAddress(email.getDirecciones()));
		if (null != email.getDireccionesCC()) {
			message.setRecipients(Message.RecipientType.CC, UtilsMapper.stringToAddress(email.getDireccionesCC()));
		}
		if (null != email.getDireccionesCCO()) {
			message.setRecipients(Message.RecipientType.BCC, UtilsMapper.stringToAddress(email.getDireccionesCCO()));
		}
	}


	private String getContentId() {
		return keyGeneratorService.getId() + "@" + NOMBRE_HOST;
	}


	/**
	 * Seteo las propierdades que vienen desde el template
	 *
	 * @param emailTemplate
	 * @return
	 */
	private Properties getPropertiesFromTemplate(EmailTemplate emailTemplate) {
		Properties props = new Properties();
		for (EmailProperty emailProperties : emailTemplate.getEmailAccount().getProperties()) {
			props.put(emailProperties.getPropertyKey(), emailProperties.getValue());
		}
		return props;
	}

	@Override
	public EmailTemplate findEmailTemplate(String nombre) throws EmailTemplateNotExist {
		Optional<EmailTemplate> emailTemplate = emailTemplateDao.findEmailTemplateByName(nombre);
		if (!emailTemplate.isPresent()) {
			throw new EmailTemplateNotExist(new String[]{});
		}
		return emailTemplate.get();
	}

	@Override
	public Email saveEmail(Email email) {
		return emailDao.save(email);
	}

}
