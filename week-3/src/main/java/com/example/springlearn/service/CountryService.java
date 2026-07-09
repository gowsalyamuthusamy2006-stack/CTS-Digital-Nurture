package com.example.springlearn.service;

import com.example.springlearn.model.Country;
import java.util.List;

public interface CountryService {

    Country createCountry(Country country);

    Country getCountryById(Long id);

    List<Country> getAllCountries();

    Country updateCountry(Long id, Country country);

    void deleteCountry(Long id);

    Country getCountryByName(String name);

    Country getCountryByCode(String code);

    List<Country> getActiveCountries();

    boolean countryExists(Long id);
}