package com.backintro.infrastructure.patientallergy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.patientallergy.usecase.DeletePatientAllergyUseCase;
import com.backintro.application.patientallergy.usecase.GetPatientAllergyByIdUseCase;
import com.backintro.application.patientallergy.usecase.ListPatientAllergyUseCase;
import com.backintro.application.patientallergy.usecase.RegisterPatientAllergyUseCase;
import com.backintro.application.patientallergy.usecase.UpdatePatientAllergyUseCase;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories.PatientAllergyJpaRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories.PatientAllergyRepositoryAdapter;

@Configuration
public class PatientAllergyBeansConfig {

    @Bean
    public PatientAllergyPersistenceMapper patientallergyPersistenceMapper() {
        return new PatientAllergyPersistenceMapper();
    }

    @Bean
    public PatientAllergyRepository patientallergyRepository(PatientAllergyJpaRepository repository, PatientAllergyPersistenceMapper mapper) {
        return new PatientAllergyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientAllergyUseCase registerPatientAllergyUseCase(PatientAllergyRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository) {
        return new RegisterPatientAllergyUseCase(repository, patientRepository);
    }

    @Bean
    public GetPatientAllergyByIdUseCase getPatientAllergyByIdUseCase(PatientAllergyRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository) {
        return new GetPatientAllergyByIdUseCase(repository, patientRepository);
    }

    @Bean
    public ListPatientAllergyUseCase listPatientAllergyUseCase(PatientAllergyRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository) {
        return new ListPatientAllergyUseCase(repository, patientRepository);
    }

    @Bean
    public UpdatePatientAllergyUseCase updatePatientAllergyUseCase(PatientAllergyRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository) {
        return new UpdatePatientAllergyUseCase(repository, patientRepository);
    }

    @Bean
    public DeletePatientAllergyUseCase deletePatientAllergyUseCase(PatientAllergyRepository repository) {
        return new DeletePatientAllergyUseCase(repository);
    }
}