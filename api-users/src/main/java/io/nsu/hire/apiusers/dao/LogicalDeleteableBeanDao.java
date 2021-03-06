package io.nsu.hire.apiusers.dao;


import io.nsu.hire.apiusers.model.LogicalDeleteableBean;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface LogicalDeleteableBeanDao<T extends LogicalDeleteableBean> extends BaseBeanDao<T> {
	List<T> findAllByActiveIsTrue();

	List<T> findAllByActiveIsFalse();

	Optional<T> findByIdAndActiveIsTrue(Long id);

	Optional<T> findByIdAndActiveIsFalse(Long id);
}
