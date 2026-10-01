package com.backintro.domain.empresa.model.valueobject;

import com.backintro.domain.common.exception.DomainException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object inmutable que representa el Número de Identificación Tributaria (NIT).
 */
public final class Nit implements Serializable {

    private final String value;

    public Nit(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("El NIT de la empresa no puede ser nulo ni vacío") {};
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nit nit = (Nit) o;
        return Objects.equals(value, nit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
