package io.nsu.hire.apiemails.service;

import io.nsu.hire.apiemails.exception.EmailTemplateNotExist;
import io.nsu.hire.apiemails.model.Email;
import io.nsu.hire.apiemails.model.EmailTemplate;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
	Email sendEmail(Email email, Context ctx, String templateName) throws MessagingException, EmailTemplateNotExist, IOException;

	EmailTemplate findEmailTemplate(String nombre) throws EmailTemplateNotExist;

	Email saveEmail(Email email);

}
