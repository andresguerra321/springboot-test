package com.backintro.domain.patientcontact.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class PatientContactNotFoundException extends DomainException {
    public PatientContactNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public PatientContactNotFoundException(String message) {
        super(message);
    }
}