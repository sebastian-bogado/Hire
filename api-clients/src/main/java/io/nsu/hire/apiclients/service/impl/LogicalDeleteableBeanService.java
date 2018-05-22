package io.nsu.hire.apiclients.service.impl;

import io.nsu.hire.apiclients.model.LogicalDeleteableBean;
import lombok.Data;

@Data
public abstract class LogicalDeleteableBeanService<T extends LogicalDeleteableBean> extends BaseBeanService<T> {
	protected T prepareToCreate(T baseBean) {
		baseBean.setActive(true);
		return super.prepareToCreate(baseBean);
	}
}
