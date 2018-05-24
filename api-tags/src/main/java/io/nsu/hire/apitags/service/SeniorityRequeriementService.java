package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.model.SeniorityRequeriment;

import java.util.List;

public interface SeniorityRequeriementService<T extends SeniorityRequeriment> {
	T prepareToUpdate(T skills, T persistedSkill);

	List<T> prepareToUpdate(List<T> skill, List<T> persistedRequeriment);
}
