package com.backintro.domain.assessmenttype.event;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public record AssessmentTypeDeletedEvent(
    AssessmentTypeId id,
    LocalDateTime occurredOn
) implements DomainEvent {

    public AssessmentTypeDeletedEvent {

        Objects.requireNonNull(
            id,
            "id must not be null"
        );

        Objects.requireNonNull(
            occurredOn,
            "occurredOn must not be null"
        );
    }
}