package com.backintro.domain.patient.exception;

import com.backintro.domain.common.exception.DomainException;

/**
 * Excepción lanzada cuando ya existe un paciente con el mismo documento.
 */
public class PatientAlreadyExistsException extends DomainException {

    public PatientAlreadyExistsException(String documentNumber) {
        super("Ya existe un paciente con el número de documento: " + documentNumber);
    }
}
