package io.nsu.hire.apiemails.service.impl;

import io.nsu.hire.apiemails.dao.EmailTemplateDao;
import io.nsu.hire.apiemails.model.EmailTemplate;
import io.nsu.hire.apiemails.service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by sbogado on 7/18/17.
 */
@Service
public class EmailTemplateServiceImplDB implements EmailTemplateService {

	@Autowired
	private EmailTemplateDao emailTemplateDao;

	@Override
	public EmailTemplate save(EmailTemplate emailTemplate) {
		return emailTemplateDao.save(emailTemplate);
	}

	@Override
	public Optional<EmailTemplate> findEmailTemplateByNombre(String nombre) {
		return emailTemplateDao.findEmailTemplateByName(nombre);
	}

}