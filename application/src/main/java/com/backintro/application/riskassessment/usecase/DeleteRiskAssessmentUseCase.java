package com.backintro.application.riskassessment.usecase;

import java.time.LocalDateTime;

import com.backintro.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.backintro.domain.riskassessment.event.RiskAssessmentDeletedEvent;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;

public class DeleteRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;

    public DeleteRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        this.repository = repository;
    }

    public RiskAssessmentDeletedEvent execute(RiskAssessmentId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new RiskAssessmentDeletedEvent(id, LocalDateTime.now());
    }
}