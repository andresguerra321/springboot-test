package com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers;

import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactJpaEntity;

public class EmailContactPersistenceMapper {

    public EmailContactJpaEntity toJpa(EmailContact domain) {
        if (domain == null) return null;
        EmailContactJpaEntity jpa = new EmailContactJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setContactId(domain.contactId());
        jpa.setEmail(domain.email());
        jpa.setNotes(domain.notes());
        return jpa;
    }

    public EmailContact toDomain(EmailContactJpaEntity jpa) {
        if (jpa == null) return null;
        return EmailContact.restore(
                new EmailContactId(jpa.getId()),
                jpa.getContactId(),
                jpa.getEmail(),
                jpa.getNotes()
        );
    }
}