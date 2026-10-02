package com.backintro.domain.patient.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class PatientNotFoundException extends DomainException {
    public PatientNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public PatientNotFoundException(String message) {
        super(message);
    }
}