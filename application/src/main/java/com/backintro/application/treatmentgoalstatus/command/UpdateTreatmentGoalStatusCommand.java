package com.backintro.application.treatmentgoalstatus.command;

import java.util.Objects;

import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

public record UpdateTreatmentGoalStatusCommand(
        TreatmentGoalStatusId id,
        String code,
        String name,
        String description
) {

    public UpdateTreatmentGoalStatusCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}