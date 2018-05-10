package io.nsu.hire.apiauthserver.rest.service.impl;

import io.nsu.hire.apiauthserver.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private RestTemplate restTemplate;


}