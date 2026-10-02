package com.backintro.domain.citymunicipality.exception;

import com.backintro.domain.common.exception.DomainException;

public class CityMunicipalityAlreadyExistsException extends DomainException {
    public CityMunicipalityAlreadyExistsException(String message) {
        super(message);
    }
}