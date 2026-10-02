package com.backintro.infrastructure.emailcontact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.emailcontact.usecase.DeleteEmailContactUseCase;
import com.backintro.application.emailcontact.usecase.GetEmailContactByIdUseCase;
import com.backintro.application.emailcontact.usecase.ListEmailContactUseCase;
import com.backintro.application.emailcontact.usecase.RegisterEmailContactUseCase;
import com.backintro.application.emailcontact.usecase.UpdateEmailContactUseCase;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactPersistenceMapper;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.repositories.EmailContactJpaRepository;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.repositories.EmailContactRepositoryAdapter;

@Configuration
public class EmailContactBeansConfig {

    @Bean
    public EmailContactPersistenceMapper emailcontactPersistenceMapper() {
        return new EmailContactPersistenceMapper();
    }

    @Bean
    public EmailContactRepository emailcontactRepository(EmailContactJpaRepository repository, EmailContactPersistenceMapper mapper) {
        return new EmailContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEmailContactUseCase registerEmailContactUseCase(EmailContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new RegisterEmailContactUseCase(repository, contactRepository);
    }

    @Bean
    public GetEmailContactByIdUseCase getEmailContactByIdUseCase(EmailContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new GetEmailContactByIdUseCase(repository, contactRepository);
    }

    @Bean
    public ListEmailContactUseCase listEmailContactUseCase(EmailContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new ListEmailContactUseCase(repository, contactRepository);
    }

    @Bean
    public UpdateEmailContactUseCase updateEmailContactUseCase(EmailContactRepository repository, com.backintro.domain.contact.port.repository.ContactRepository contactRepository) {
        return new UpdateEmailContactUseCase(repository, contactRepository);
    }

    @Bean
    public DeleteEmailContactUseCase deleteEmailContactUseCase(EmailContactRepository repository) {
        return new DeleteEmailContactUseCase(repository);
    }
}