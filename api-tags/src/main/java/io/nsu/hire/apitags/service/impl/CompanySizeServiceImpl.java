package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.model.CompanySizeEnum;
import io.nsu.hire.apitags.service.CompanySizeService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CompanySizeServiceImpl implements CompanySizeService {
	@Override
	public List<CompanySizeEnum> readAllCompanySizes() {
		return Arrays.asList(CompanySizeEnum.values());
	}
}
