package com.backintro.domain.medicationroute.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class MedicationRouteNotFoundException extends DomainException {

    public MedicationRouteNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public MedicationRouteNotFoundException(String message) {
        super(message);
    }
}