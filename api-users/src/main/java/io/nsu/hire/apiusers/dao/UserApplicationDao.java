package io.nsu.hire.apiusers.dao;

import io.nsu.hire.apiusers.model.UserApplication;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserApplicationDao extends BaseBeanDao<UserApplication> {
	Optional<UserApplication> findByUuidAndAndCreationDateAfter(String uuid, LocalDateTime comparativeDate);
	Optional<UserApplication> findByEmailAndCreationDateIsAfter(String email, LocalDateTime comparativeDate);
}
