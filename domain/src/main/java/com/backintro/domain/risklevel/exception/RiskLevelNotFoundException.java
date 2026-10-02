package com.backintro.domain.risklevel.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

public class RiskLevelNotFoundException extends DomainException {

    public RiskLevelNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }

    public RiskLevelNotFoundException(String message) {
        super(message);
    }
}