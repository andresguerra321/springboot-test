package com.backintro.domain.clinicalrecord.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ClinicalRecordNotFoundException extends DomainException {
    public ClinicalRecordNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ClinicalRecordNotFoundException(String message) {
        super(message);
    }
}