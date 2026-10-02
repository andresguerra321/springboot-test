package com.backintro.domain.documenttype.exception;

import com.backintro.domain.common.exception.DomainException;

public class DocumentTypeAlreadyExistsException extends DomainException {

    public DocumentTypeAlreadyExistsException(String message) {
        super(message);
    }
}