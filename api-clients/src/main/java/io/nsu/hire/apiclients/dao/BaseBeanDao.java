package io.nsu.hire.apiclients.dao;

import io.nsu.hire.apiclients.model.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseBeanDao<T extends BaseBean> extends JpaRepository<T, Long >, TimestampBeanDao<T>{

	Optional<T> findById(Long id);
	Optional<T> findByUuid(String id);
	void deleteByUuid(String uuid);

}
