package com.backintro.domain.geography.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando no se encuentra una entidad geográfica.
 */
public class GeographyNotFoundException extends DomainException {

    public GeographyNotFoundException(String entityName, UUID id) {
        super("No se encontró " + entityName + " con el identificador: " + id);
    }
}
