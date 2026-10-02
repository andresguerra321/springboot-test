package com.backintro.application.riskassessment.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record RiskAssessmentResponse(
        UUID id,
        UUID encounterId,
        UUID riskLevelId,
        String riskLevelName,
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
}