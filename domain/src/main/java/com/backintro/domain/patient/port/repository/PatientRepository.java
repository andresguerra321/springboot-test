package com.backintro.domain.patient.port.repository;

import com.backintro.domain.patient.model.aggregate.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de Patient.
 */
public interface PatientRepository {

    Patient save(Patient patient);

    Optional<Patient> findById(UUID id);

    Optional<Patient> findByDocumentTypeIdAndDocumentNumber(UUID documentTypeId, String documentNumber);

    List<Patient> findAll();

    List<Patient> findAllActive();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
