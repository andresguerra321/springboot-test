package com.backintro.domain.professionalstudy.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ProfessionalStudyNotFoundException extends DomainException {
    public ProfessionalStudyNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ProfessionalStudyNotFoundException(String message) {
        super(message);
    }
}