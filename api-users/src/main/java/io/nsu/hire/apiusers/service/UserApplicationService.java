package io.nsu.hire.apiusers.service;

import io.nsu.hire.apiusers.model.UserApplication;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserApplicationService {

	Page<UserApplication> readUserApplications(Integer size, Integer page);
	List<UserApplication> readUserApplications();
	Optional<UserApplication> readUserApplicationByUuid(String uuid);
	UserApplication createUserApplication(UserApplication userApplication);

}
