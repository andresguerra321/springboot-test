package com.backintro.domain.treatmentplan.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class TreatmentPlanNotFoundException extends DomainException {
    public TreatmentPlanNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public TreatmentPlanNotFoundException(String message) {
        super(message);
    }
}