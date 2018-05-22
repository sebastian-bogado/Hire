package io.nsu.hire.apiusers.dao;

import io.nsu.hire.apiusers.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampDao<T extends TimestampBean> {
}
