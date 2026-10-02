package com.backintro.domain.patient.model.valueobject;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object inmutable para el nombre completo de una persona.
 */
public final class PersonName implements Serializable {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String secondLastName;

    public PersonName(String firstName, String middleName, String lastName, String secondLastName) {
        this.firstName = firstName != null ? firstName.trim() : null;
        this.middleName = middleName != null ? middleName.trim() : null;
        this.lastName = lastName != null ? lastName.trim() : null;
        this.secondLastName = secondLastName != null ? secondLastName.trim() : null;
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getSecondLastName() { return secondLastName; }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        if (firstName != null) sb.append(firstName);
        if (middleName != null) sb.append(" ").append(middleName);
        if (lastName != null) sb.append(" ").append(lastName);
        if (secondLastName != null) sb.append(" ").append(secondLastName);
        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonName that = (PersonName) o;
        return Objects.equals(firstName, that.firstName) &&
               Objects.equals(middleName, that.middleName) &&
               Objects.equals(lastName, that.lastName) &&
               Objects.equals(secondLastName, that.secondLastName);
    }

    @Override
    public int hashCode() { return Objects.hash(firstName, middleName, lastName, secondLastName); }

    @Override
    public String toString() { return getFullName(); }
}
