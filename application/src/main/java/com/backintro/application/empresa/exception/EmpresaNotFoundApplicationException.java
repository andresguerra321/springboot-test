package com.backintro.application.empresa.exception;

import com.backintro.application.common.ApplicationException;

import java.util.UUID;

/**
 * Excepción de aplicación lanzada cuando no se localiza una Empresa.
 */
public class EmpresaNotFoundApplicationException extends ApplicationException {

    public EmpresaNotFoundApplicationException(UUID id) {
        super("No se encontró la empresa con ID: " + id);
    }

    public EmpresaNotFoundApplicationException(String message) {
        super(message);
    }
}
