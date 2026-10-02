package com.backintro.domain.treatmentgoalstatus.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class TreatmentGoalStatusNotFoundException extends DomainException {

    public TreatmentGoalStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public TreatmentGoalStatusNotFoundException(String message) {
        super(message);
    }
}