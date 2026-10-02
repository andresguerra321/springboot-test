package com.backintro.domain.clinicalrecord.exception;

import com.backintro.domain.common.exception.DomainException;

public class ClinicalRecordAlreadyExistsException extends DomainException {
    public ClinicalRecordAlreadyExistsException(String message) {
        super(message);
    }
}