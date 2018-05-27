package io.nsu.hire.apiusers.service.impl;

import io.nsu.hire.apiusers.model.ProcessEnum;
import io.nsu.hire.apiusers.service.EmailService;
import io.nsu.hire.apiusers.vo.EmailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmailServiceImplRest implements EmailService {

	@Autowired
	@Qualifier("emailServiceRestTemplate")
	private RestTemplate restTemplate;

	@Value("${duhire.email.server}")
	private String url;

	@Async
	@Override
	public void sendEmail(Object data, String emailTemplate, ProcessEnum processEnum, List<String> direcciones, List<String> direccionesCC, List<String> direccionesCCO) {
		EmailVO emailVO = EmailVO.builder()
				.data(data)
				.emailTemplate(emailTemplate)
				.direcciones(direcciones)
				.direccionesCC(direccionesCC)
				.direccionesCCO(direccionesCCO)
				.processName(processEnum)
				.build();
		restTemplate.postForObject(url, emailVO, Void.class);
	}
}
