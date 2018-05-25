package io.nsu.hire.apitags.service.impl;

import io.nsu.hire.apitags.dao.CountryDao;
import io.nsu.hire.apitags.exception.BadFormatCountryException;
import io.nsu.hire.apitags.exception.CountryNotFoundException;
import io.nsu.hire.apitags.model.Country;
import io.nsu.hire.apitags.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl extends BaseBeanService<Country> implements CountryService {

	@Autowired
	private CountryDao countryDao;
	private static final Logger LOG = LoggerFactory.getLogger(CountryServiceImpl.class);

	@Override
	public List<Country> getCountries() {
		return countryDao.findAll();
	}

	@Override
	public Optional<Country> getCountryById(Long id) throws CountryNotFoundException {
		return countryDao.findById(id);
	}

	@Override
	public Optional<Country> getCountryByUuid(String uuid) throws CountryNotFoundException {
		return countryDao.findByUuid(uuid);
	}

	@Override
	public Country createCountry(Country country) {
		return countryDao.save(prepareToCreate(country));
	}

	@Override
	public Country updateCountry(Country country) {
			return countryDao.save(prepareToUpdate(country));
	}

	@Override
	public void deleteCountry(Long id) {
		countryDao.deleteById(id);
	}

	@Override
	public void deleteCountry(String uuid) {
		countryDao.deleteByUuid(uuid);
	}

	@Override
	public Country prepareToUpdate(Country country) {
		if(country.getId() == null) {
			LOG.error("Error al querer actualizar con un id en null");
			throw new BadFormatCountryException();
		}
		Country persistedCountry = this.getCountryById(country.getId()).orElseThrow(() -> new CountryNotFoundException(country.getId().toString()));
		persistedCountry.setCode(country.getCode());
		persistedCountry.setName(persistedCountry.getName());
		persistedCountry.setPhonePrefix(persistedCountry.getPhonePrefix());
		return super.prepareToUpdate(persistedCountry);
	}

}
