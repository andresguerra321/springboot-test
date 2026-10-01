package com.backintro.domain.country.model.valueobject;

import com.backintro.domain.common.exception.DomainException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object inmutable que encapsula el código de país (ISO o identificador alfanumérico).
 */
public final class CountryCode implements Serializable {

    private final String value;

    public CountryCode(String value) {
        if (value != null && value.trim().length() > 10) {
            throw new DomainException("El código de país no puede superar 10 caracteres") {};
        }
        this.value = value != null ? value.trim().toUpperCase() : null;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCode that = (CountryCode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value != null ? value : "";
    }
}
