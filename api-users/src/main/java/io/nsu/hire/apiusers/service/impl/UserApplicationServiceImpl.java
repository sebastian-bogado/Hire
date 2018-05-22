package io.nsu.hire.apiusers.service.impl;

import io.nsu.hire.apiusers.dao.UserApplicationDao;
import io.nsu.hire.apiusers.exception.UserApplicationExistException;
import io.nsu.hire.apiusers.model.UserApplication;
import io.nsu.hire.apiusers.service.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationServiceImpl extends BaseBeanService<UserApplication> implements UserApplicationService {
	@Autowired
	private UserApplicationDao userApplicationDao;
	@Value("${expiration.application.days:1}")
	private Long expirationDays;
	@Override
	public Page<UserApplication> readUserApplications(Integer size, Integer page) {
		return userApplicationDao.findAll(new QPageRequest(page, size));
	}

	@Override
	public List<UserApplication> readUserApplications() {
		return userApplicationDao.findAll();
	}

	@Override
	public Optional<UserApplication> readUserApplicationByUuid(String uuid) {
		LocalDateTime comparativeDate = LocalDateTime.now().minusDays(expirationDays);
		return userApplicationDao.findByUuidAndAndCreationDateAfter(uuid, comparativeDate);
	}

	@Override
	public UserApplication createUserApplication(UserApplication userApplication) {
		if(userApplicationDao.findByEmailAndCreationDateIsAfter(userApplication.getEmail(), LocalDateTime.now().minusDays(expirationDays)).isPresent()) {
			throw new UserApplicationExistException();
		}
		return userApplicationDao.save(prepareToCreate(userApplication));
	}
}
