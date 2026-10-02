package com.backintro.domain.clinicalrecord.port.repository;

import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.model.aggregate.Encounter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClinicalRecordRepository {

    ClinicalRecord save(ClinicalRecord clinicalRecord);

    Optional<ClinicalRecord> findById(UUID id);

    Optional<ClinicalRecord> findByPatientId(UUID patientId);

    List<ClinicalRecord> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);

    Encounter saveEncounter(Encounter encounter);

    Optional<Encounter> findEncounterById(UUID encounterId);

    List<Encounter> findEncountersByClinicalRecordId(UUID clinicalRecordId);
}
