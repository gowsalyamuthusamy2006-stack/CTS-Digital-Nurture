package com.example.springlearn.dao;

import com.example.springlearn.model.Country;
import java.util.List;
import java.util.Optional;

public interface CountryDAO {

    Country save(Country country);

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country update(Country country);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);

    boolean existsByCode(String code);

    Optional<Country> findByName(String name);

    Optional<Country> findByCode(String code);

    List<Country> findActiveCountries();
}