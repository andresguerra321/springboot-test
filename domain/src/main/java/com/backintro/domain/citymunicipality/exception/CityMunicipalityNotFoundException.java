package com.backintro.domain.citymunicipality.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class CityMunicipalityNotFoundException extends DomainException {
    public CityMunicipalityNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public CityMunicipalityNotFoundException(String message) {
        super(message);
    }
}