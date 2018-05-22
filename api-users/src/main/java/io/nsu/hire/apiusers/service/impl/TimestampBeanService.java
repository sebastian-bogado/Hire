package io.nsu.hire.apiusers.service.impl;

import io.nsu.hire.apiusers.model.TimestampBean;

import java.time.LocalDateTime;
import java.util.Date;

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
