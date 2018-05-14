package io.nsu.hire.apiclients.dao;

import com.nsu.duhire.webapi.client.model.TimestampBean;

public interface TimestampBeanDao<T extends TimestampBean> extends JpaRepository<T, Long > {
}
