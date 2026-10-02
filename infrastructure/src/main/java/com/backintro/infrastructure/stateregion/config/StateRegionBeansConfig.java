package com.backintro.infrastructure.stateregion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.stateregion.usecase.DeleteStateRegionUseCase;
import com.backintro.application.stateregion.usecase.GetStateRegionByIdUseCase;
import com.backintro.application.stateregion.usecase.ListStateRegionUseCase;
import com.backintro.application.stateregion.usecase.RegisterStateRegionUseCase;
import com.backintro.application.stateregion.usecase.UpdateStateRegionUseCase;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionPersistenceMapper;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories.StateRegionJpaRepository;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.repositories.StateRegionRepositoryAdapter;

@Configuration
public class StateRegionBeansConfig {

    @Bean
    public StateRegionPersistenceMapper stateregionPersistenceMapper() {
        return new StateRegionPersistenceMapper();
    }

    @Bean
    public StateRegionRepository stateregionRepository(StateRegionJpaRepository repository, StateRegionPersistenceMapper mapper) {
        return new StateRegionRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterStateRegionUseCase registerStateRegionUseCase(StateRegionRepository repository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new RegisterStateRegionUseCase(repository, countryRepository);
    }

    @Bean
    public GetStateRegionByIdUseCase getStateRegionByIdUseCase(StateRegionRepository repository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new GetStateRegionByIdUseCase(repository, countryRepository);
    }

    @Bean
    public ListStateRegionUseCase listStateRegionUseCase(StateRegionRepository repository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new ListStateRegionUseCase(repository, countryRepository);
    }

    @Bean
    public UpdateStateRegionUseCase updateStateRegionUseCase(StateRegionRepository repository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new UpdateStateRegionUseCase(repository, countryRepository);
    }

    @Bean
    public DeleteStateRegionUseCase deleteStateRegionUseCase(StateRegionRepository repository) {
        return new DeleteStateRegionUseCase(repository);
    }
}