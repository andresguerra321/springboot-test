package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.command.UpdateRiskAssessmentCommand;
import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.application.riskassessment.exception.RiskAssessmentNotFoundApplicationException;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class UpdateRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;
    private final RiskLevelRepository riskLevelRepository;

    public UpdateRiskAssessmentUseCase(
            RiskAssessmentRepository repository,
            RiskLevelRepository riskLevelRepository
    ) {
        this.repository = repository;
        this.riskLevelRepository = riskLevelRepository;
    }

    public RiskAssessmentResponse execute(UpdateRiskAssessmentCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new RiskAssessmentNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.encounterId(),
                command.riskLevelId(),
                command.suicidalIdeation(),
                command.suicidePlan(),
                command.suicideIntent(),
                command.selfHarm(),
                command.harmToOthers(),
                command.protectiveFactors(),
                command.riskFactors(),
                command.clinicalActions(),
                command.observations(),
                command.assessedAt(),
                command.assessedBy()
        );

        var updated = repository.save(entity);
        return new RiskAssessmentResponse(
                updated.id().value(),
                updated.encounterId(),
                updated.riskLevelId(),
                riskLevelRepository.findById(new com.backintro.domain.risklevel.model.valueobject.RiskLevelId(updated.riskLevelId())).map(c -> c.name()).orElse(null),
                updated.suicidalIdeation(),
                updated.suicidePlan(),
                updated.suicideIntent(),
                updated.selfHarm(),
                updated.harmToOthers(),
                updated.protectiveFactors(),
                updated.riskFactors(),
                updated.clinicalActions(),
                updated.observations(),
                updated.assessedAt(),
                updated.assessedBy()
        );
    }
}