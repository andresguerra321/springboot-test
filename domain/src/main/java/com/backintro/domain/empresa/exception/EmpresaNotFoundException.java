package com.backintro.domain.empresa.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando una Empresa no es encontrada por su identificador o criterio.
 */
public class EmpresaNotFoundException extends DomainException {

    public EmpresaNotFoundException(UUID id) {
        super("No se encontró la empresa con el identificador: " + id);
    }

    public EmpresaNotFoundException(String message) {
        super(message);
    }
}
