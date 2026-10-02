package com.backintro.infrastructure.contact.adapters.out.persistence.mappers;

import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.infrastructure.contact.adapters.out.persistence.entity.ContactJpaEntity;

public class ContactPersistenceMapper {

    public ContactJpaEntity toJpa(Contact domain) {
        if (domain == null) return null;
        ContactJpaEntity jpa = new ContactJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setFullName(domain.fullName());
        jpa.setEmail(domain.email());
        jpa.setNotes(domain.notes());
        jpa.setCityId(domain.cityId());
        jpa.setCreatedBy(domain.createdBy());
        jpa.setUpdatedBy(domain.updatedBy());
        return jpa;
    }

    public Contact toDomain(ContactJpaEntity jpa) {
        if (jpa == null) return null;
        return Contact.restore(
                new ContactId(jpa.getId()),
                jpa.getFullName(),
                jpa.getEmail(),
                jpa.getNotes(),
                jpa.getCityId(),
                jpa.getCreatedBy(),
                jpa.getUpdatedBy()
        );
    }
}