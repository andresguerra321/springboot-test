package com.backintro.domain.assessmenttype.exception;

import com.backintro.domain.common.exception.DomainException;

public class AssessmentTypeAlreadyExistsException extends DomainException {

    public AssessmentTypeAlreadyExistsException(String message) {
        super(message);
    }
}