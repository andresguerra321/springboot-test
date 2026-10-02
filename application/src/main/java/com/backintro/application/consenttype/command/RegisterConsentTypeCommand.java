package com.backintro.application.consenttype.command;

import java.util.Objects;

public record RegisterConsentTypeCommand(
        String code,
        String name,
        String description
) {

    public RegisterConsentTypeCommand {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}