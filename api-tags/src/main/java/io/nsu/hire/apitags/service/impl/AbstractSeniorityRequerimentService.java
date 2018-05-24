package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.exception.NotFoundException;
import io.nsu.hire.apitags.model.SeniorityRequeriment;
import io.nsu.hire.apitags.service.SeniorityRequeriementService;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractSeniorityRequerimentService<T extends SeniorityRequeriment> extends BaseBeanService<T> implements SeniorityRequeriementService<T> {

	@Override
	public List<T> prepareToUpdate(List<T> skill, List<T> persistedRequeriment) {
		return skill
				.stream()
				.map(element -> {
					try {
						return element.getId() != null ?
								prepareToUpdate(element, persistedRequeriment
										.stream()
										.filter(persistedSkill -> element.getId().equals(persistedSkill.getId()))
										.findFirst()
										.orElseThrow(() -> new RuntimeException("The flexible requirement is not available to update")))
								: prepareToCreate(element);
					} catch (NotFoundException e) {
						e.printStackTrace();
						return element;
					}
				})
				.collect(Collectors.toList());
	}


}
