package com.backintro.domain.riskassessment.event;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public record RiskAssessmentUpdatedEvent(
    RiskAssessmentId id,
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
    UUID assessedBy,
    LocalDateTime occurredOn
) implements DomainEvent {

    public RiskAssessmentUpdatedEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(encounterId, "encounterId must not be null");
        Objects.requireNonNull(riskLevelId, "riskLevelId must not be null");
        Objects.requireNonNull(occurredOn, "occurredOn must not be null");
    }
}