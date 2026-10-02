package com.backintro.infrastructure.consenttype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.consenttype.usecase.DeleteConsentTypeUseCase;
import com.backintro.application.consenttype.usecase.GetConsentTypeByIdUseCase;
import com.backintro.application.consenttype.usecase.ListConsentTypeUseCase;
import com.backintro.application.consenttype.usecase.RegisterConsentTypeUseCase;
import com.backintro.application.consenttype.usecase.UpdateConsentTypeUseCase;
import com.backintro.domain.consenttype.port.repository.ConsentTypeRepository;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.mappers.ConsentTypePersistenceMapper;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.repositories.ConsentTypeJpaRepository;
import com.backintro.infrastructure.consenttype.adapters.out.persistence.repositories.ConsentTypeRepositoryAdapter;

@Configuration
public class ConsentTypeBeansConfig {

    @Bean
    public ConsentTypePersistenceMapper consenttypePersistenceMapper() {
        return new ConsentTypePersistenceMapper();
    }

    @Bean
    public ConsentTypeRepository consenttypeRepository(ConsentTypeJpaRepository repository, ConsentTypePersistenceMapper mapper) {
        return new ConsentTypeRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterConsentTypeUseCase registerConsentTypeUseCase(ConsentTypeRepository repository) {
        return new RegisterConsentTypeUseCase(
                repository
        );
    }

    @Bean
    public GetConsentTypeByIdUseCase getConsentTypeByIdUseCase(ConsentTypeRepository repository) {
        return new GetConsentTypeByIdUseCase(
                repository
        );
    }

    @Bean
    public ListConsentTypeUseCase listConsentTypeUseCase(ConsentTypeRepository repository) {
        return new ListConsentTypeUseCase(
                repository
        );
    }

    @Bean
    public UpdateConsentTypeUseCase updateConsentTypeUseCase(ConsentTypeRepository repository) {
        return new UpdateConsentTypeUseCase(
                repository
        );
    }

    @Bean
    public DeleteConsentTypeUseCase deleteConsentTypeUseCase(ConsentTypeRepository repository) {
        return new DeleteConsentTypeUseCase(
                repository
        );
    }
}