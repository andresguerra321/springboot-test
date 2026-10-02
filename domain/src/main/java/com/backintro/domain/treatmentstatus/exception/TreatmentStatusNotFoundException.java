package com.backintro.domain.treatmentstatus.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class TreatmentStatusNotFoundException extends DomainException {

    public TreatmentStatusNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public TreatmentStatusNotFoundException(String message) {
        super(message);
    }
}