package com.backintro.domain.study.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class StudyNotFoundException extends DomainException {

    public StudyNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public StudyNotFoundException(String message) {
        super(message);
    }
}