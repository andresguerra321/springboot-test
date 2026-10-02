package com.backintro.domain.patient.model.valueobject;

import com.backintro.domain.common.exception.DomainException;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object inmutable para el número de documento de un paciente.
 */
public final class DocumentNumber implements Serializable {

    private final String value;

    public DocumentNumber(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("El número de documento no puede estar vacío") {};
        }
        if (value.trim().length() > 30) {
            throw new DomainException("El número de documento no puede superar 30 caracteres") {};
        }
        this.value = value.trim();
    }

    public String getValue() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(value, ((DocumentNumber) o).value);
    }

    @Override
    public int hashCode() { return Objects.hash(value); }

    @Override
    public String toString() { return value; }
}
