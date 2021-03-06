package io.nsu.hire.apiusers.dao;

import io.nsu.hire.apiusers.model.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseBeanDao<T extends BaseBean> extends JpaRepository<T, Long>, TimestampDao<T> {
	Optional<T> findById(Long id);

	Optional<T> findByUuid(String uuid);

	void deleteByUuid(String uuid);
}
