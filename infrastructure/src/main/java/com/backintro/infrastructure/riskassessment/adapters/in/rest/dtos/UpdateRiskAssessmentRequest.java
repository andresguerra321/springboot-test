package com.backintro.infrastructure.riskassessment.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateRiskAssessmentRequest(
        @NotNull(message = "encounterId is required")
        UUID encounterId,

        @NotNull(message = "riskLevelId is required")
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
) {}