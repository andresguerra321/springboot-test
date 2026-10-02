package com.backintro.infrastructure.clinicalnote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.clinicalnote.usecase.DeleteClinicalNoteUseCase;
import com.backintro.application.clinicalnote.usecase.GetClinicalNoteByIdUseCase;
import com.backintro.application.clinicalnote.usecase.ListClinicalNoteUseCase;
import com.backintro.application.clinicalnote.usecase.RegisterClinicalNoteUseCase;
import com.backintro.application.clinicalnote.usecase.UpdateClinicalNoteUseCase;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNotePersistenceMapper;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories.ClinicalNoteJpaRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories.ClinicalNoteRepositoryAdapter;

@Configuration
public class ClinicalNoteBeansConfig {

    @Bean
    public ClinicalNotePersistenceMapper clinicalnotePersistenceMapper() {
        return new ClinicalNotePersistenceMapper();
    }

    @Bean
    public ClinicalNoteRepository clinicalnoteRepository(ClinicalNoteJpaRepository repository, ClinicalNotePersistenceMapper mapper) {
        return new ClinicalNoteRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalNoteUseCase registerClinicalNoteUseCase(ClinicalNoteRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new RegisterClinicalNoteUseCase(repository, professionalRepository);
    }

    @Bean
    public GetClinicalNoteByIdUseCase getClinicalNoteByIdUseCase(ClinicalNoteRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new GetClinicalNoteByIdUseCase(repository, professionalRepository);
    }

    @Bean
    public ListClinicalNoteUseCase listClinicalNoteUseCase(ClinicalNoteRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new ListClinicalNoteUseCase(repository, professionalRepository);
    }

    @Bean
    public UpdateClinicalNoteUseCase updateClinicalNoteUseCase(ClinicalNoteRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository) {
        return new UpdateClinicalNoteUseCase(repository, professionalRepository);
    }

    @Bean
    public DeleteClinicalNoteUseCase deleteClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new DeleteClinicalNoteUseCase(repository);
    }
}