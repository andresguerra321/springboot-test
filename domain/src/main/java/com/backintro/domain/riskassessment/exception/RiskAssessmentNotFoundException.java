package com.backintro.domain.riskassessment.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class RiskAssessmentNotFoundException extends DomainException {
    public RiskAssessmentNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public RiskAssessmentNotFoundException(String message) {
        super(message);
    }
}