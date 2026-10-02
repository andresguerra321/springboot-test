package com.backintro.application.riskassessment.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public record UpdateRiskAssessmentCommand(
        RiskAssessmentId id,
        UUID encounterId,
        UUID riskLevelId,
        boolean suicidalIdeation,
        boolean suicidePlan,
        boolean suicideIntent,
        boolean selfHarm,
        boolean harmToOthers,
        String protectiveFactors,
        String riskFactors,
        String clinicalActions,
        String observations,
        java.time.LocalDateTime assessedAt,
        UUID assessedBy
) {
    public UpdateRiskAssessmentCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(riskLevelId, "riskLevelId must not be null");
    }
}