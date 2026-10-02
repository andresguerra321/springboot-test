package com.backintro.application.treatmentgoalstatus.command;

import java.util.Objects;

public record RegisterTreatmentGoalStatusCommand(
        String code,
        String name,
        String description
) {

    public RegisterTreatmentGoalStatusCommand {
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}