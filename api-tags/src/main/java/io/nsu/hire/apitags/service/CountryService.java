package io.nsu.hire.apitags.service;

import io.nsu.hire.apitags.exception.CountryNotFoundException;
import io.nsu.hire.apitags.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
	List<Country> getCountries();
	Optional<Country> getCountryById(Long id) throws CountryNotFoundException;
	Optional<Country> getCountryByUuid(String uuid) throws CountryNotFoundException;
	Country createCountry(Country area);
	Country updateCountry(Country area);
	void deleteCountry(Long id);
	void deleteCountry(String uuid);
}
