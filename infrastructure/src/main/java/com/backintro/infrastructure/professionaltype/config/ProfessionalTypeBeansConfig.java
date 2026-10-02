package com.backintro.infrastructure.professionaltype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.professionaltype.usecase.DeleteProfessionalTypeUseCase;
import com.backintro.application.professionaltype.usecase.GetProfessionalTypeByIdUseCase;
import com.backintro.application.professionaltype.usecase.ListProfessionalTypeUseCase;
import com.backintro.application.professionaltype.usecase.RegisterProfessionalTypeUseCase;
import com.backintro.application.professionaltype.usecase.UpdateProfessionalTypeUseCase;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.mappers.ProfessionalTypePersistenceMapper;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.repositories.ProfessionalTypeJpaRepository;
import com.backintro.infrastructure.professionaltype.adapters.out.persistence.repositories.ProfessionalTypeRepositoryAdapter;

@Configuration
public class ProfessionalTypeBeansConfig {

    @Bean
    public ProfessionalTypePersistenceMapper professionaltypePersistenceMapper() {
        return new ProfessionalTypePersistenceMapper();
    }

    @Bean
    public ProfessionalTypeRepository professionaltypeRepository(ProfessionalTypeJpaRepository repository, ProfessionalTypePersistenceMapper mapper) {
        return new ProfessionalTypeRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterProfessionalTypeUseCase registerProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new RegisterProfessionalTypeUseCase(
                repository
        );
    }

    @Bean
    public GetProfessionalTypeByIdUseCase getProfessionalTypeByIdUseCase(ProfessionalTypeRepository repository) {
        return new GetProfessionalTypeByIdUseCase(
                repository
        );
    }

    @Bean
    public ListProfessionalTypeUseCase listProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new ListProfessionalTypeUseCase(
                repository
        );
    }

    @Bean
    public UpdateProfessionalTypeUseCase updateProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new UpdateProfessionalTypeUseCase(
                repository
        );
    }

    @Bean
    public DeleteProfessionalTypeUseCase deleteProfessionalTypeUseCase(ProfessionalTypeRepository repository) {
        return new DeleteProfessionalTypeUseCase(
                repository
        );
    }
}