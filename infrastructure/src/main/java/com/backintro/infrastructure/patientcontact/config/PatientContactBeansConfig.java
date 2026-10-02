package com.backintro.infrastructure.patientcontact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.patientcontact.usecase.DeletePatientContactUseCase;
import com.backintro.application.patientcontact.usecase.GetPatientContactByIdUseCase;
import com.backintro.application.patientcontact.usecase.ListPatientContactUseCase;
import com.backintro.application.patientcontact.usecase.RegisterPatientContactUseCase;
import com.backintro.application.patientcontact.usecase.UpdatePatientContactUseCase;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactPersistenceMapper;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.repositories.PatientContactJpaRepository;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.repositories.PatientContactRepositoryAdapter;

@Configuration
public class PatientContactBeansConfig {

    @Bean
    public PatientContactPersistenceMapper patientcontactPersistenceMapper() {
        return new PatientContactPersistenceMapper();
    }

    @Bean
    public PatientContactRepository patientcontactRepository(PatientContactJpaRepository repository, PatientContactPersistenceMapper mapper) {
        return new PatientContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientContactUseCase registerPatientContactUseCase(PatientContactRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository relationshipTypeRepository) {
        return new RegisterPatientContactUseCase(repository, patientRepository, relationshipTypeRepository);
    }

    @Bean
    public GetPatientContactByIdUseCase getPatientContactByIdUseCase(PatientContactRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository relationshipTypeRepository) {
        return new GetPatientContactByIdUseCase(repository, patientRepository, relationshipTypeRepository);
    }

    @Bean
    public ListPatientContactUseCase listPatientContactUseCase(PatientContactRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository relationshipTypeRepository) {
        return new ListPatientContactUseCase(repository, patientRepository, relationshipTypeRepository);
    }

    @Bean
    public UpdatePatientContactUseCase updatePatientContactUseCase(PatientContactRepository repository, com.backintro.domain.patient.port.repository.PatientRepository patientRepository, com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository relationshipTypeRepository) {
        return new UpdatePatientContactUseCase(repository, patientRepository, relationshipTypeRepository);
    }

    @Bean
    public DeletePatientContactUseCase deletePatientContactUseCase(PatientContactRepository repository) {
        return new DeletePatientContactUseCase(repository);
    }
}