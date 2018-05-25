package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.model.CompanySizeEnum;

import java.util.List;

public interface CompanySizeService {
	List<CompanySizeEnum> readAllCompanySizes();
}
