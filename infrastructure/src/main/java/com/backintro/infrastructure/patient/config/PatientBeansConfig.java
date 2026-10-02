package com.backintro.infrastructure.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.patient.usecase.DeletePatientUseCase;
import com.backintro.application.patient.usecase.GetPatientByIdUseCase;
import com.backintro.application.patient.usecase.ListPatientUseCase;
import com.backintro.application.patient.usecase.RegisterPatientUseCase;
import com.backintro.application.patient.usecase.UpdatePatientUseCase;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;
import com.backintro.infrastructure.patient.adapters.out.persistence.repositories.PatientJpaRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.repositories.PatientRepositoryAdapter;

@Configuration
public class PatientBeansConfig {

    @Bean
    public PatientPersistenceMapper patientPersistenceMapper() {
        return new PatientPersistenceMapper();
    }

    @Bean
    public PatientRepository patientRepository(PatientJpaRepository repository, PatientPersistenceMapper mapper) {
        return new PatientRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientUseCase registerPatientUseCase(PatientRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.gender.port.repository.GenderRepository genderRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new RegisterPatientUseCase(repository, documentTypeRepository, genderRepository, cityMunicipalityRepository);
    }

    @Bean
    public GetPatientByIdUseCase getPatientByIdUseCase(PatientRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.gender.port.repository.GenderRepository genderRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new GetPatientByIdUseCase(repository, documentTypeRepository, genderRepository, cityMunicipalityRepository);
    }

    @Bean
    public ListPatientUseCase listPatientUseCase(PatientRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.gender.port.repository.GenderRepository genderRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new ListPatientUseCase(repository, documentTypeRepository, genderRepository, cityMunicipalityRepository);
    }

    @Bean
    public UpdatePatientUseCase updatePatientUseCase(PatientRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.gender.port.repository.GenderRepository genderRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new UpdatePatientUseCase(repository, documentTypeRepository, genderRepository, cityMunicipalityRepository);
    }

    @Bean
    public DeletePatientUseCase deletePatientUseCase(PatientRepository repository) {
        return new DeletePatientUseCase(repository);
    }
}