package io.nsu.hire.apiemails.dao;


import io.nsu.hire.apiemails.model.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by sbogado on 7/18/17.
 */
@Repository
public interface EmailTemplateDao extends JpaRepository<EmailTemplate, Long> {
	Optional<EmailTemplate> findEmailTemplateById(Long id);

	Optional<EmailTemplate> findEmailTemplateByName(String name);
}