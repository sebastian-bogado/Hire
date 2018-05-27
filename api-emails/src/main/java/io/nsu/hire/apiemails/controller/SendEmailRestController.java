package io.nsu.hire.apiemails.controller;

import io.nsu.hire.apiemails.controller.dto.EmailDTO;
import io.nsu.hire.apiemails.exception.EmailTemplateNotExist;
import io.nsu.hire.apiemails.model.Email;
import io.nsu.hire.apiemails.service.EmailService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/email")
public class SendEmailRestController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private MapperFacade orikaMapper;

	@PostMapping
	public void sendEmail(@Valid EmailDTO emailDTO) throws MessagingException, IOException, EmailTemplateNotExist {
		Context context = new Context();
		context.setVariable("data", emailDTO.getData());
		emailService.sendEmail(orikaMapper.map(emailDTO, Email.class), context, emailDTO.getEmailTemplate());
	}


}
