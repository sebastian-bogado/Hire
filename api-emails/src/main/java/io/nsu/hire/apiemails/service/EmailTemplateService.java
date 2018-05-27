package io.nsu.hire.apiemails.service;

import io.nsu.hire.apiemails.model.EmailTemplate;

import java.util.Optional;

/**
 * Created by sbogado on 7/18/17.
 */
public interface EmailTemplateService {

	EmailTemplate save(EmailTemplate emailTemplate);

	Optional<EmailTemplate> findEmailTemplateByNombre(String nombre);
}

