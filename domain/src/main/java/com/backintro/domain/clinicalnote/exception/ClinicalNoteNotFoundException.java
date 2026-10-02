package com.backintro.domain.clinicalnote.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ClinicalNoteNotFoundException extends DomainException {
    public ClinicalNoteNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ClinicalNoteNotFoundException(String message) {
        super(message);
    }
}