package com.backintro.domain.contact.port.repository;

import com.backintro.domain.contact.model.aggregate.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto de salida para el repositorio de Contact.
 */
public interface ContactRepository {

    Contact save(Contact contact);

    Optional<Contact> findById(UUID id);

    List<Contact> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
