package com.backintro.domain.relationshiptype.exception;

import com.backintro.domain.common.exception.DomainException;

public class RelationshipTypeAlreadyExistsException extends DomainException {

    public RelationshipTypeAlreadyExistsException(String message) {
        super(message);
    }
}