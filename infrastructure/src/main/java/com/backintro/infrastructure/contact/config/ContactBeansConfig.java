package com.backintro.infrastructure.contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.contact.usecase.DeleteContactUseCase;
import com.backintro.application.contact.usecase.GetContactByIdUseCase;
import com.backintro.application.contact.usecase.ListContactUseCase;
import com.backintro.application.contact.usecase.RegisterContactUseCase;
import com.backintro.application.contact.usecase.UpdateContactUseCase;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;
import com.backintro.infrastructure.contact.adapters.out.persistence.repositories.ContactJpaRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.repositories.ContactRepositoryAdapter;

@Configuration
public class ContactBeansConfig {

    @Bean
    public ContactPersistenceMapper contactPersistenceMapper() {
        return new ContactPersistenceMapper();
    }

    @Bean
    public ContactRepository contactRepository(ContactJpaRepository repository, ContactPersistenceMapper mapper) {
        return new ContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterContactUseCase registerContactUseCase(ContactRepository repository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new RegisterContactUseCase(repository, cityMunicipalityRepository);
    }

    @Bean
    public GetContactByIdUseCase getContactByIdUseCase(ContactRepository repository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new GetContactByIdUseCase(repository, cityMunicipalityRepository);
    }

    @Bean
    public ListContactUseCase listContactUseCase(ContactRepository repository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new ListContactUseCase(repository, cityMunicipalityRepository);
    }

    @Bean
    public UpdateContactUseCase updateContactUseCase(ContactRepository repository, com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository cityMunicipalityRepository) {
        return new UpdateContactUseCase(repository, cityMunicipalityRepository);
    }

    @Bean
    public DeleteContactUseCase deleteContactUseCase(ContactRepository repository) {
        return new DeleteContactUseCase(repository);
    }
}