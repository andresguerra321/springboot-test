package com.backintro.domain.professional.port.repository;

import com.backintro.domain.professional.model.aggregate.Professional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de Professional.
 */
public interface ProfessionalRepository {

    Professional save(Professional professional);

    Optional<Professional> findById(UUID id);

    Optional<Professional> findByDocumentTypeIdAndDocumentNumber(UUID documentTypeId, String documentNumber);

    List<Professional> findAll();

    List<Professional> findAllActive();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
