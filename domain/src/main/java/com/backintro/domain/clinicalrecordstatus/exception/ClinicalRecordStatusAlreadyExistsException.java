package com.backintro.domain.clinicalrecordstatus.exception;

import com.backintro.domain.common.exception.DomainException;

public class ClinicalRecordStatusAlreadyExistsException extends DomainException {

    public ClinicalRecordStatusAlreadyExistsException(String message) {
        super(message);
    }
}