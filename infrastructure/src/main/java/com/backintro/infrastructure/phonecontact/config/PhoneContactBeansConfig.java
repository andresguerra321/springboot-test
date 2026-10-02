package com.backintro.infrastructure.phonecontact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.phonecontact.usecase.DeletePhoneContactUseCase;
import com.backintro.application.phonecontact.usecase.GetPhoneContactByIdUseCase;
import com.backintro.application.phonecontact.usecase.ListPhoneContactUseCase;
import com.backintro.application.phonecontact.usecase.RegisterPhoneContactUseCase;
import com.backintro.application.phonecontact.usecase.UpdatePhoneContactUseCase;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers.PhoneContactPersistenceMapper;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories.PhoneContactJpaRepository;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.repositories.PhoneContactRepositoryAdapter;

@Configuration
public class PhoneContactBeansConfig {

    @Bean
    public PhoneContactPersistenceMapper phonecontactPersistenceMapper() {
        return new PhoneContactPersistenceMapper();
    }

    @Bean
    public PhoneContactRepository phonecontactRepository(PhoneContactJpaRepository repository, PhoneContactPersistenceMapper mapper) {
        return new PhoneContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPhoneContactUseCase registerPhoneContactUseCase(PhoneContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new RegisterPhoneContactUseCase(repository, contactRepository);
    }

    @Bean
    public GetPhoneContactByIdUseCase getPhoneContactByIdUseCase(PhoneContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new GetPhoneContactByIdUseCase(repository, contactRepository);
    }

    @Bean
    public ListPhoneContactUseCase listPhoneContactUseCase(PhoneContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new ListPhoneContactUseCase(repository, contactRepository);
    }

    @Bean
    public UpdatePhoneContactUseCase updatePhoneContactUseCase(PhoneContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new UpdatePhoneContactUseCase(repository, contactRepository);
    }

    @Bean
    public DeletePhoneContactUseCase deletePhoneContactUseCase(PhoneContactRepository repository) {
        return new DeletePhoneContactUseCase(repository);
    }
}