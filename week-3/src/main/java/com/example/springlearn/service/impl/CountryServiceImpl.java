package com.example.springlearn.service.impl;

import com.example.springlearn.dao.CountryDAO;
import com.example.springlearn.exception.DuplicateResourceException;
import com.example.springlearn.exception.ResourceNotFoundException;
import com.example.springlearn.model.Country;
import com.example.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryDAO countryDAO;

    public Country createCountry(Country country) {
        logger.info("Creating country: {}", country.getName());
        if (countryDAO.existsByName(country.getName())) {
            throw new DuplicateResourceException("Country", "name", country.getName());
        }
        if (countryDAO.existsByCode(country.getCode())) {
            throw new DuplicateResourceException("Country", "code", country.getCode());
        }
        return countryDAO.save(country);
    }

    public Country getCountryById(Long id) {
        return countryDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
    }

    public List<Country> getAllCountries() {
        return countryDAO.findAll();
    }

    public Country updateCountry(Long id, Country country) {
        Country existing = getCountryById(id);
        if (!existing.getName().equals(country.getName()) && countryDAO.existsByName(country.getName())) {
            throw new DuplicateResourceException("Country", "name", country.getName());
        }
        if (!existing.getCode().equals(country.getCode()) && countryDAO.existsByCode(country.getCode())) {
            throw new DuplicateResourceException("Country", "code", country.getCode());
        }
        existing.setName(country.getName());
        existing.setCode(country.getCode());
        existing.setDescription(country.getDescription());
        existing.setPopulation(country.getPopulation());
        existing.setCapitalCity(country.getCapitalCity());
        return countryDAO.update(existing);
    }

    public void deleteCountry(Long id) {
        if (!countryDAO.existsById(id)) {
            throw new ResourceNotFoundException("Country", "id", id);
        }
        countryDAO.deleteById(id);
    }

    public Country getCountryByName(String name) {
        return countryDAO.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "name", name));
    }

    public Country getCountryByCode(String code) {
        return countryDAO.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Country", "code", code));
    }

    public List<Country> getActiveCountries() {
        return countryDAO.findActiveCountries();
    }

    public boolean countryExists(Long id) {
        return countryDAO.existsById(id);
    }
}