package io.nsu.hire.apiclients.service.impl;

import io.nsu.hire.apiclients.model.BaseBean;

import java.util.UUID;

public abstract class BaseBeanService<T extends BaseBean> extends TimestampBeanService<T> {

	protected T prepareToCreate(T baseBean) {
		baseBean.setUuid(UUID.randomUUID().toString());
		return super.prepareToCreate(baseBean);
	}

}
