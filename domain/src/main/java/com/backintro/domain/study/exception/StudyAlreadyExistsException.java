package com.backintro.domain.study.exception;

import com.backintro.domain.common.exception.DomainException;

public class StudyAlreadyExistsException extends DomainException {

    public StudyAlreadyExistsException(String message) {
        super(message);
    }
}