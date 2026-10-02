package com.backintro.domain.country.exception;

import com.backintro.domain.common.exception.DomainException;

public class CountryAlreadyExistsException extends DomainException {
    public CountryAlreadyExistsException(String message) {
        super(message);
    }
}