package com.backintro.domain.common.exception;

/**
 * Excepción base para todos los errores de reglas de negocio en la capa de Dominio.
 */
public abstract class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
