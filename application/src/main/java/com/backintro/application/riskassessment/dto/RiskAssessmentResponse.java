package com.backintro.application.riskassessment.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record RiskAssessmentResponse(
        UUID id,
        UUID encounterId,
        UUID riskLevelId,
        String riskLevelName,
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
}