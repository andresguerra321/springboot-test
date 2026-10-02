package com.backintro.infrastructure.riskassessment.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateRiskAssessmentRequest(
        @jakarta.validation.constraints.NotNull(message = "encounterId is required")
        UUID encounterId,

        @jakarta.validation.constraints.NotNull(message = "riskLevelId is required")
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
) {}