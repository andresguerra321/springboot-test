package com.backintro.domain.professionaltype.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class ProfessionalTypeNotFoundException extends DomainException {

    public ProfessionalTypeNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public ProfessionalTypeNotFoundException(String message) {
        super(message);
    }
}