package com.backintro.application.assessmenttype.command;

import java.util.Objects;

public record RegisterAssessmentTypeCommand(
        String code,
        String name,
        String description
) {

    public RegisterAssessmentTypeCommand {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}