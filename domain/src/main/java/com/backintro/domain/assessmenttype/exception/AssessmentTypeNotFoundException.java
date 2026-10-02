package com.backintro.domain.assessmenttype.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class AssessmentTypeNotFoundException extends DomainException {

    public AssessmentTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public AssessmentTypeNotFoundException(String message) {
        super(message);
    }
}