package com.backintro.domain.patient.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando no se encuentra un Paciente.
 */
public class PatientNotFoundException extends DomainException {

    public PatientNotFoundException(UUID id) {
        super("No se encontró el paciente con el identificador: " + id);
    }

    public PatientNotFoundException(String message) {
        super(message);
    }
}
