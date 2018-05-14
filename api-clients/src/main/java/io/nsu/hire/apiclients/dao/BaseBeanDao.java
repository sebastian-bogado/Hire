package io.nsu.hire.apiclients.dao;

import com.nsu.duhire.webapi.client.model.BaseBean;
import io.nsu.hire.apiclients.model.BaseBean;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseBeanDao<T extends BaseBean> extends TimestampBeanDao<T>{

	Optional<T> findById(Long id);
	Optional<T> findByUuid(String id);
	void deleteByUuid(String uuid);

}
