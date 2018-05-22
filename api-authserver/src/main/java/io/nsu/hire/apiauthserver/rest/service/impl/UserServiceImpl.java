package io.nsu.hire.apiauthserver.rest.service.impl;

import io.nsu.hire.apiauthserver.rest.dto.UserDTO;
import io.nsu.hire.apiauthserver.rest.dto.UserLoginRequest;
import io.nsu.hire.apiauthserver.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${user.server.uri:http://localhost:9000/users}")
	private String urlToUserServer;
	@Override
	public Optional<UserDTO> authenticateUser(String username, String password) {
		UserLoginRequest userLoginRequest = new UserLoginRequest(username,password);
		UserDTO response = restTemplate.postForObject(urlToUserServer+"/authentication", userLoginRequest, UserDTO.class);
		return Optional.ofNullable(response);
	}
}