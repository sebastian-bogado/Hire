package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.model.TimestampBean;

import java.time.LocalDateTime;

public class TimestampBeanService<T extends TimestampBean> {
	protected T prepareToCreate(T baseBean) {
		baseBean.setCreationDate(LocalDateTime.now());
		baseBean.setLastUpdate(LocalDateTime.now());
		return baseBean;
	}

	protected T prepareToUpdate(T baseBean) {
		baseBean.setLastUpdate(LocalDateTime.now());
		return baseBean;
	}
}
