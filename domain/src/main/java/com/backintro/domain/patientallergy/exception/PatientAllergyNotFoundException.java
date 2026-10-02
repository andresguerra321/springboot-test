package com.backintro.domain.patientallergy.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class PatientAllergyNotFoundException extends DomainException {
    public PatientAllergyNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public PatientAllergyNotFoundException(String message) {
        super(message);
    }
}