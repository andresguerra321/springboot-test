package com.backintro.infrastructure.citymunicipality.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.citymunicipality.usecase.DeleteCityMunicipalityUseCase;
import com.backintro.application.citymunicipality.usecase.GetCityMunicipalityByIdUseCase;
import com.backintro.application.citymunicipality.usecase.ListCityMunicipalityUseCase;
import com.backintro.application.citymunicipality.usecase.RegisterCityMunicipalityUseCase;
import com.backintro.application.citymunicipality.usecase.UpdateCityMunicipalityUseCase;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.mappers.CityMunicipalityPersistenceMapper;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.repositories.CityMunicipalityJpaRepository;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.repositories.CityMunicipalityRepositoryAdapter;

@Configuration
public class CityMunicipalityBeansConfig {

    @Bean
    public CityMunicipalityPersistenceMapper citymunicipalityPersistenceMapper() {
        return new CityMunicipalityPersistenceMapper();
    }

    @Bean
    public CityMunicipalityRepository citymunicipalityRepository(CityMunicipalityJpaRepository repository, CityMunicipalityPersistenceMapper mapper) {
        return new CityMunicipalityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterCityMunicipalityUseCase registerCityMunicipalityUseCase(CityMunicipalityRepository repository, com.backintro.domain.stateregion.port.repository.StateRegionRepository stateRegionRepository) {
        return new RegisterCityMunicipalityUseCase(repository, stateRegionRepository);
    }

    @Bean
    public GetCityMunicipalityByIdUseCase getCityMunicipalityByIdUseCase(CityMunicipalityRepository repository, com.backintro.domain.stateregion.port.repository.StateRegionRepository stateRegionRepository) {
        return new GetCityMunicipalityByIdUseCase(repository, stateRegionRepository);
    }

    @Bean
    public ListCityMunicipalityUseCase listCityMunicipalityUseCase(CityMunicipalityRepository repository, com.backintro.domain.stateregion.port.repository.StateRegionRepository stateRegionRepository) {
        return new ListCityMunicipalityUseCase(repository, stateRegionRepository);
    }

    @Bean
    public UpdateCityMunicipalityUseCase updateCityMunicipalityUseCase(CityMunicipalityRepository repository, com.backintro.domain.stateregion.port.repository.StateRegionRepository stateRegionRepository) {
        return new UpdateCityMunicipalityUseCase(repository, stateRegionRepository);
    }

    @Bean
    public DeleteCityMunicipalityUseCase deleteCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new DeleteCityMunicipalityUseCase(repository);
    }
}