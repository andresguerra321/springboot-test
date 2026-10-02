package com.backintro.domain.professional.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ProfessionalNotFoundException extends DomainException {
    public ProfessionalNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ProfessionalNotFoundException(String message) {
        super(message);
    }
}