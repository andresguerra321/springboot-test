package com.backintro.domain.clinicalnote.exception;

import com.backintro.domain.common.exception.DomainException;

public class ClinicalNoteAlreadyExistsException extends DomainException {
    public ClinicalNoteAlreadyExistsException(String message) {
        super(message);
    }
}