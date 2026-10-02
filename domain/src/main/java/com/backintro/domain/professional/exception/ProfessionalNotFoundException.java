package com.backintro.domain.professional.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando no se encuentra un Profesional.
 */
public class ProfessionalNotFoundException extends DomainException {

    public ProfessionalNotFoundException(UUID id) {
        super("No se encontró el profesional con el identificador: " + id);
    }

    public ProfessionalNotFoundException(String message) {
        super(message);
    }
}
