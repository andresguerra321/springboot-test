package com.backintro.application.riskassessment.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterRiskAssessmentCommand(
        UUID encounterId,
        UUID riskLevelId,
        Boolean suicidalIdeation,
        Boolean suicidePlan,
        Boolean suicideIntent,
        Boolean selfHarm,
        Boolean harmToOthers,
        String protectiveFactors,
        String riskFactors,
        String clinicalActions,
        String observations,
        java.time.LocalDateTime assessedAt,
        UUID assessedBy
) {
    public RegisterRiskAssessmentCommand {
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(riskLevelId, "riskLevelId must not be null");
    }
}