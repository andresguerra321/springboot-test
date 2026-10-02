package com.backintro.domain.catalog.exception;

import com.backintro.domain.common.exception.DomainException;

import java.util.UUID;

/**
 * Excepción lanzada cuando no se encuentra un elemento de catálogo.
 */
public class CatalogNotFoundException extends DomainException {

    public CatalogNotFoundException(String catalogName, UUID id) {
        super("No se encontró el catálogo '" + catalogName + "' con el identificador: " + id);
    }

    public CatalogNotFoundException(String catalogName, String code) {
        super("No se encontró el catálogo '" + catalogName + "' con el código: " + code);
    }
}
