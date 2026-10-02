package com.backintro.infrastructure.country.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.country.usecase.DeleteCountryUseCase;
import com.backintro.application.country.usecase.GetCountryByIdUseCase;
import com.backintro.application.country.usecase.ListCountryUseCase;
import com.backintro.application.country.usecase.RegisterCountryUseCase;
import com.backintro.application.country.usecase.UpdateCountryUseCase;
import com.backintro.domain.country.port.repository.CountryRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;
import com.backintro.infrastructure.country.adapters.out.persistence.repositories.CountryJpaRepository;
import com.backintro.infrastructure.country.adapters.out.persistence.repositories.CountryRepositoryAdapter;

@Configuration
public class CountryBeansConfig {

    @Bean
    public CountryPersistenceMapper countryPersistenceMapper() {
        return new CountryPersistenceMapper();
    }

    @Bean
    public CountryRepository countryRepository(CountryJpaRepository repository, CountryPersistenceMapper mapper) {
        return new CountryRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterCountryUseCase registerCountryUseCase(CountryRepository repository) {
        return new RegisterCountryUseCase(repository);
    }

    @Bean
    public GetCountryByIdUseCase getCountryByIdUseCase(CountryRepository repository) {
        return new GetCountryByIdUseCase(repository);
    }

    @Bean
    public ListCountryUseCase listCountryUseCase(CountryRepository repository) {
        return new ListCountryUseCase(repository);
    }

    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryRepository repository) {
        return new UpdateCountryUseCase(repository);
    }

    @Bean
    public DeleteCountryUseCase deleteCountryUseCase(CountryRepository repository) {
        return new DeleteCountryUseCase(repository);
    }
}