package com.backintro.infrastructure.professional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.professional.usecase.DeleteProfessionalUseCase;
import com.backintro.application.professional.usecase.GetProfessionalByIdUseCase;
import com.backintro.application.professional.usecase.ListProfessionalUseCase;
import com.backintro.application.professional.usecase.RegisterProfessionalUseCase;
import com.backintro.application.professional.usecase.UpdateProfessionalUseCase;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalPersistenceMapper;
import com.backintro.infrastructure.professional.adapters.out.persistence.repositories.ProfessionalJpaRepository;
import com.backintro.infrastructure.professional.adapters.out.persistence.repositories.ProfessionalRepositoryAdapter;

@Configuration
public class ProfessionalBeansConfig {

    @Bean
    public ProfessionalPersistenceMapper professionalPersistenceMapper() {
        return new ProfessionalPersistenceMapper();
    }

    @Bean
    public ProfessionalRepository professionalRepository(ProfessionalJpaRepository repository, ProfessionalPersistenceMapper mapper) {
        return new ProfessionalRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProfessionalUseCase registerProfessionalUseCase(ProfessionalRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository professionalTypeRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new RegisterProfessionalUseCase(repository, documentTypeRepository, professionalTypeRepository, cityMunicipalityRepository);
    }

    @Bean
    public GetProfessionalByIdUseCase getProfessionalByIdUseCase(ProfessionalRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository professionalTypeRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new GetProfessionalByIdUseCase(repository, documentTypeRepository, professionalTypeRepository, cityMunicipalityRepository);
    }

    @Bean
    public ListProfessionalUseCase listProfessionalUseCase(ProfessionalRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository professionalTypeRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new ListProfessionalUseCase(repository, documentTypeRepository, professionalTypeRepository, cityMunicipalityRepository);
    }

    @Bean
    public UpdateProfessionalUseCase updateProfessionalUseCase(ProfessionalRepository repository, com.backintro.domain.documenttype.port.repository.DocumentTypeRepository documentTypeRepository, com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository professionalTypeRepository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new UpdateProfessionalUseCase(repository, documentTypeRepository, professionalTypeRepository, cityMunicipalityRepository);
    }

    @Bean
    public DeleteProfessionalUseCase deleteProfessionalUseCase(ProfessionalRepository repository) {
        return new DeleteProfessionalUseCase(repository);
    }
}