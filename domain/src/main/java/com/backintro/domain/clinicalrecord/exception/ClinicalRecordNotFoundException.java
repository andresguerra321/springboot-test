package com.backintro.domain.clinicalrecord.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class ClinicalRecordNotFoundException extends DomainException {

    public ClinicalRecordNotFoundException(UUID id) {
        super("Historia clínica no encontrada con el id: " + id);
    }

    public ClinicalRecordNotFoundException(String message) {
        super(message);
    }
}
