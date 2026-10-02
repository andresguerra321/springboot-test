package com.backintro.domain.mentalstatusexam.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class MentalStatusExamNotFoundException extends DomainException {
    public MentalStatusExamNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public MentalStatusExamNotFoundException(String message) {
        super(message);
    }
}