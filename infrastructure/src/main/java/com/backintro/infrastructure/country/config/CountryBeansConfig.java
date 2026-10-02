package com.backintro.infrastructure.country.config;

import com.backintro.application.country.usecase.DeleteCountryUseCase;
import com.backintro.application.country.usecase.GetCountryByCodeUseCase;
import com.backintro.application.country.usecase.GetCountryByIdUseCase;
import com.backintro.application.country.usecase.ListCountryUseCase;
import com.backintro.application.country.usecase.RegisterCountryUseCase;
import com.backintro.application.country.usecase.UpdateCountryUseCase;
import com.backintro.domain.country.port.repository.CountryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans de Spring para registrar los Casos de Uso de Country de la capa de Aplicación
 * manteniendo la capa de aplicación desacoplada de anotaciones de Spring.
 */
@Configuration
public class CountryBeansConfig {

    @Bean
    public RegisterCountryUseCase registerCountryUseCase(CountryRepository countryRepository) {
        return new RegisterCountryUseCase(countryRepository);
    }

    @Bean
    public GetCountryByIdUseCase getCountryByIdUseCase(CountryRepository countryRepository) {
        return new GetCountryByIdUseCase(countryRepository);
    }

    @Bean
    public GetCountryByCodeUseCase getCountryByCodeUseCase(CountryRepository countryRepository) {
        return new GetCountryByCodeUseCase(countryRepository);
    }

    @Bean
    public ListCountryUseCase listCountryUseCase(CountryRepository countryRepository) {
        return new ListCountryUseCase(countryRepository);
    }

    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryRepository countryRepository) {
        return new UpdateCountryUseCase(countryRepository);
    }

    @Bean
    public DeleteCountryUseCase deleteCountryUseCase(CountryRepository countryRepository) {
        return new DeleteCountryUseCase(countryRepository);
    }
}
