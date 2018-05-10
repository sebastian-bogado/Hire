package io.nsu.hire.apiusers.service.impl;

import io.nsu.hire.apiusers.model.BaseBean;

import java.util.UUID;

public abstract class BaseBeanService<T extends BaseBean> extends TimestampBeanService<T> {

	protected T prepareToCreate(T baseBean) {
		baseBean.setUuid(UUID.randomUUID().toString());
		return super.prepareToCreate(baseBean);
	}

}
