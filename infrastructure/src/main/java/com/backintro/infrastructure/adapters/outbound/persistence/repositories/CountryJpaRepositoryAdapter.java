package com.backintro.infrastructure.adapters.outbound.persistence.repositories;

import com.backintro.application.ports.CountryRepositoryPort;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.adapters.outbound.persistence.entities.CountryJpaEntity;
import com.backintro.infrastructure.adapters.outbound.persistence.mappers.CountryPersistenceMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Adaptador de persistencia para el prototipo Java SE que implementa CountryRepository y CountryRepositoryPort.
 */
public class CountryJpaRepositoryAdapter implements CountryRepository, CountryRepositoryPort {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager externalEntityManager;
    private final CountryPersistenceMapper mapper;

    public CountryJpaRepositoryAdapter(EntityManagerFactory entityManagerFactory) {
        this(entityManagerFactory, new CountryPersistenceMapper());
    }

    public CountryJpaRepositoryAdapter(EntityManagerFactory entityManagerFactory, CountryPersistenceMapper mapper) {
        this.entityManagerFactory = Objects.requireNonNull(entityManagerFactory, "EntityManagerFactory no puede ser nulo");
        this.externalEntityManager = null;
        this.mapper = Objects.requireNonNull(mapper, "CountryPersistenceMapper no puede ser nulo");
    }

    public CountryJpaRepositoryAdapter(EntityManager entityManager) {
        this(entityManager, new CountryPersistenceMapper());
    }

    public CountryJpaRepositoryAdapter(EntityManager entityManager, CountryPersistenceMapper mapper) {
        this.externalEntityManager = Objects.requireNonNull(entityManager, "EntityManager no puede ser nulo");
        this.entityManagerFactory = null;
        this.mapper = Objects.requireNonNull(mapper, "CountryPersistenceMapper no puede ser nulo");
    }

    private EntityManager obtainEntityManager() {
        if (externalEntityManager != null) {
            return externalEntityManager;
        }
        return entityManagerFactory.createEntityManager();
    }

    private boolean isSelfManaged() {
        return this.entityManagerFactory != null;
    }

    @Override
    public Country save(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("El país a guardar no puede ser nulo");
        }

        EntityManager em = obtainEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean selfManaged = isSelfManaged();

        try {
            tx.begin();

            CountryJpaEntity jpaEntity = mapper.toJpaEntity(country);
            CountryJpaEntity result;

            if (jpaEntity.getId() != null && em.find(CountryJpaEntity.class, jpaEntity.getId()) != null) {
                result = em.merge(jpaEntity);
            } else {
                em.persist(jpaEntity);
                result = jpaEntity;
            }

            tx.commit();
            return mapper.toDomain(result);
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error en la transacción al persistir el país: " + country.name(), e);
        } finally {
            if (selfManaged && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public Optional<Country> findById(CountryId id) {
        if (id == null || id.value() == null) {
            return Optional.empty();
        }
        return findById(id.value());
    }

    @Override
    public Optional<Country> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }

        EntityManager em = obtainEntityManager();
        boolean selfManaged = isSelfManaged();

        try {
            CountryJpaEntity entity = em.find(CountryJpaEntity.class, id);
            return Optional.ofNullable(mapper.toDomain(entity));
        } finally {
            if (selfManaged && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<Country> findAll() {
        EntityManager em = obtainEntityManager();
        boolean selfManaged = isSelfManaged();

        try {
            List<CountryJpaEntity> entities = em.createQuery(
                    "SELECT c FROM OldCountryJpaEntity c ORDER BY c.nameCountry ASC",
                    CountryJpaEntity.class
            ).getResultList();

            List<Country> domainList = new ArrayList<>(entities.size());
            for (CountryJpaEntity entity : entities) {
                domainList.add(mapper.toDomain(entity));
            }
            return domainList;
        } finally {
            if (selfManaged && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Country country) {
        if (country != null && country.id() != null && country.id().value() != null) {
            deleteById(country.id().value());
        }
    }

    @Override
    public void deleteById(CountryId id) {
        if (id != null && id.value() != null) {
            deleteById(id.value());
        }
    }

    @Override
    public void deleteById(UUID id) {
        if (id == null) {
            return;
        }

        EntityManager em = obtainEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean selfManaged = isSelfManaged();

        try {
            tx.begin();
            CountryJpaEntity entity = em.find(CountryJpaEntity.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException("Error en la transacción al eliminar el país con ID: " + id, e);
        } finally {
            if (selfManaged && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean existsById(CountryId id) {
        return id != null && id.value() != null && existsById(id.value());
    }

    @Override
    public boolean existsById(UUID id) {
        if (id == null) {
            return false;
        }

        EntityManager em = obtainEntityManager();
        boolean selfManaged = isSelfManaged();

        try {
            Long count = em.createQuery(
                    "SELECT COUNT(c) FROM OldCountryJpaEntity c WHERE c.id = :id",
                    Long.class
            ).setParameter("id", id).getSingleResult();

            return count != null && count > 0;
        } finally {
            if (selfManaged && em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public boolean existsByCode(String code) {
        return findByCode(code).isPresent();
    }

    @Override
    public Optional<Country> findByCode(String codeCountry) {
        if (codeCountry == null || codeCountry.trim().isEmpty()) {
            return Optional.empty();
        }

        EntityManager em = obtainEntityManager();
        boolean selfManaged = isSelfManaged();

        try {
            List<CountryJpaEntity> results = em.createQuery(
                    "SELECT c FROM OldCountryJpaEntity c WHERE c.codeCountry = :code",
                    CountryJpaEntity.class
            ).setParameter("code", codeCountry.trim())
             .setMaxResults(1)
             .getResultList();

            if (results.isEmpty()) {
                return Optional.empty();
            }

            return Optional.ofNullable(mapper.toDomain(results.get(0)));
        } finally {
            if (selfManaged && em.isOpen()) {
                em.close();
            }
        }
    }
}
