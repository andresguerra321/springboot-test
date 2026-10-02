package com.backintro.domain.professionalstudy.exception;

import com.backintro.domain.common.exception.DomainException;

public class ProfessionalStudyAlreadyExistsException extends DomainException {
    public ProfessionalStudyAlreadyExistsException(String message) {
        super(message);
    }
}