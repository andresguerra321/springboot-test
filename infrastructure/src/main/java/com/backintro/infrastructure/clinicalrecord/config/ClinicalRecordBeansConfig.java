package com.backintro.infrastructure.clinicalrecord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.clinicalrecord.usecase.DeleteClinicalRecordUseCase;
import com.backintro.application.clinicalrecord.usecase.GetClinicalRecordByIdUseCase;
import com.backintro.application.clinicalrecord.usecase.ListClinicalRecordUseCase;
import com.backintro.application.clinicalrecord.usecase.RegisterClinicalRecordUseCase;
import com.backintro.application.clinicalrecord.usecase.UpdateClinicalRecordUseCase;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordPersistenceMapper;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories.ClinicalRecordJpaRepository;
import com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.repositories.ClinicalRecordRepositoryAdapter;

@Configuration
public class ClinicalRecordBeansConfig {

    @Bean
    public ClinicalRecordPersistenceMapper clinicalrecordPersistenceMapper() {
        return new ClinicalRecordPersistenceMapper();
    }

    @Bean
    public ClinicalRecordRepository clinicalrecordRepository(ClinicalRecordJpaRepository repository, ClinicalRecordPersistenceMapper mapper) {
        return new ClinicalRecordRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalRecordUseCase registerClinicalRecordUseCase(ClinicalRecordRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new RegisterClinicalRecordUseCase(repository, patientRepository, clinicalRecordStatusRepository);
    }

    @Bean
    public GetClinicalRecordByIdUseCase getClinicalRecordByIdUseCase(ClinicalRecordRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new GetClinicalRecordByIdUseCase(repository, patientRepository, clinicalRecordStatusRepository);
    }

    @Bean
    public ListClinicalRecordUseCase listClinicalRecordUseCase(ClinicalRecordRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new ListClinicalRecordUseCase(repository, patientRepository, clinicalRecordStatusRepository);
    }

    @Bean
    public UpdateClinicalRecordUseCase updateClinicalRecordUseCase(ClinicalRecordRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository clinicalRecordStatusRepository) {
        return new UpdateClinicalRecordUseCase(repository, patientRepository, clinicalRecordStatusRepository);
    }

    @Bean
    public DeleteClinicalRecordUseCase deleteClinicalRecordUseCase(ClinicalRecordRepository repository) {
        return new DeleteClinicalRecordUseCase(repository);
    }
}