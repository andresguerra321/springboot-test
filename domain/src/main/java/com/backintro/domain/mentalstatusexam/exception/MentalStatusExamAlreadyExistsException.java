package com.backintro.domain.mentalstatusexam.exception;

import com.backintro.domain.common.exception.DomainException;

public class MentalStatusExamAlreadyExistsException extends DomainException {
    public MentalStatusExamAlreadyExistsException(String message) {
        super(message);
    }
}