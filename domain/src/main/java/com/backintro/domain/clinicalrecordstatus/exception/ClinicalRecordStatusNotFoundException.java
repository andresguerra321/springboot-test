package com.backintro.domain.clinicalrecordstatus.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class ClinicalRecordStatusNotFoundException extends DomainException {

    public ClinicalRecordStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public ClinicalRecordStatusNotFoundException(String message) {
        super(message);
    }
}