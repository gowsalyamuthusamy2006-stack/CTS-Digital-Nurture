package com.example.springlearn.dao.impl;

import com.example.springlearn.dao.CountryDAO;
import com.example.springlearn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CountryDAOImpl implements CountryDAO {

    private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Country save(Country country) {
        logger.debug("Saving country: {}", country.getName());
        entityManager.persist(country);
        return country;
    }

    @Override
    public Optional<Country> findById(Long id) {
        logger.debug("Finding country by id: {}", id);
        Country country = entityManager.find(Country.class, id);
        return Optional.ofNullable(country);
    }

    @Override
    public List<Country> findAll() {
        logger.debug("Finding all countries");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> rootEntry = cq.from(Country.class);
        CriteriaQuery<Country> all = cq.select(rootEntry);
        TypedQuery<Country> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Country update(Country country) {
        logger.debug("Updating country: {}", country.getName());
        return entityManager.merge(country);
    }

    @Override
    public void deleteById(Long id) {
        logger.debug("Deleting country by id: {}", id);
        Country country = entityManager.find(Country.class, id);
        if (country != null) {
            entityManager.remove(country);
        }
    }

    @Override
    public boolean existsById(Long id) {
        logger.debug("Checking if country exists by id: {}", id);
        return entityManager.find(Country.class, id) != null;
    }

    @Override
    public boolean existsByName(String name) {
        logger.debug("Checking if country exists by name: {}", name);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(cb.count(root)).where(cb.equal(root.get("name"), name));
        Long count = entityManager.createQuery(cq).getSingleResult();
        return count > 0;
    }

    @Override
    public boolean existsByCode(String code) {
        logger.debug("Checking if country exists by code: {}", code);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(cb.count(root)).where(cb.equal(root.get("code"), code));
        Long count = entityManager.createQuery(cq).getSingleResult();
        return count > 0;
    }

    @Override
    public Optional<Country> findByName(String name) {
        logger.debug("Finding country by name: {}", name);
        TypedQuery<Country> query = entityManager.createQuery(
            "SELECT c FROM Country c WHERE c.name = :name", Country.class);
        query.setParameter("name", name);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<Country> findByCode(String code) {
        logger.debug("Finding country by code: {}", code);
        TypedQuery<Country> query = entityManager.createQuery(
            "SELECT c FROM Country c WHERE c.code = :code", Country.class);
        query.setParameter("code", code);
        return query.getResultList().stream().findFirst();
    }

    @Override
    public List<Country> findActiveCountries() {
        logger.debug("Finding all active countries");
        TypedQuery<Country> query = entityManager.createQuery(
            "SELECT c FROM Country c WHERE c.isActive = true", Country.class);
        return query.getResultList();
    }
}	