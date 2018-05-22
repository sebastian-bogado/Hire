package io.nsu.hire.apitags.dao;

import io.nsu.hire.apitags.model.TimestampBean;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampDao<T extends TimestampBean> {
}
