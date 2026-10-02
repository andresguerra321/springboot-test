package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class GetRiskAssessmentByIdUseCase {
    private final RiskAssessmentRepository repository;
    private final RiskLevelRepository riskLevelRepository;

    public GetRiskAssessmentByIdUseCase(
            RiskAssessmentRepository repository,
            RiskLevelRepository riskLevelRepository
    ) {
        this.repository = repository;
        this.riskLevelRepository = riskLevelRepository;
    }

    public RiskAssessmentResponse execute(RiskAssessmentId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(id.value().toString()));
        return new RiskAssessmentResponse(
                entity.id().value(),
                entity.encounterId(),
                entity.riskLevelId(),
                riskLevelRepository.findById(new com.backintro.domain.risklevel.model.valueobject.RiskLevelId(entity.riskLevelId())).map(c -> c.name()).orElse(null),
                entity.suicidalIdeation(),
                entity.suicidePlan(),
                entity.suicideIntent(),
                entity.selfHarm(),
                entity.harmToOthers(),
                entity.protectiveFactors(),
                entity.riskFactors(),
                entity.clinicalActions(),
                entity.observations(),
                entity.assessedAt(),
                entity.assessedBy()
        );
    }
}