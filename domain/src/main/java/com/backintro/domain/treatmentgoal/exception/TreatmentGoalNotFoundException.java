package com.backintro.domain.treatmentgoal.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class TreatmentGoalNotFoundException extends DomainException {
    public TreatmentGoalNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public TreatmentGoalNotFoundException(String message) {
        super(message);
    }
}