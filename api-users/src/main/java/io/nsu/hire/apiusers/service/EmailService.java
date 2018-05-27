package io.nsu.hire.apiusers.service;

import io.nsu.hire.apiusers.model.ProcessEnum;

import java.util.List;

public interface EmailService {
	void sendEmail(Object data, String emailTemplate, ProcessEnum processEnum, List<String> direcciones, List<String> direccionesCC, List<String> direccionesCCO);
}
