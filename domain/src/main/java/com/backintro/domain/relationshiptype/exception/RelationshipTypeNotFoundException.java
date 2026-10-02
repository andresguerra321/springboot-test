package com.backintro.domain.relationshiptype.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class RelationshipTypeNotFoundException extends DomainException {

    public RelationshipTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public RelationshipTypeNotFoundException(String message) {
        super(message);
    }
}