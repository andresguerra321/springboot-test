package com.backintro.application.treatmentplan.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public record UpdateTreatmentPlanCommand(
        TreatmentPlanId id,
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        java.time.LocalDate startDate,
        java.time.LocalDate endDate,
        UUID treatmentStatusId
) {
    public UpdateTreatmentPlanCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(treatmentStatusId, "treatmentStatusId must not be null");
    }
}