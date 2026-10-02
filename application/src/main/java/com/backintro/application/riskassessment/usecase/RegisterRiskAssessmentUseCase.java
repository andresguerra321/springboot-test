package com.backintro.application.riskassessment.usecase;

import com.backintro.application.riskassessment.command.RegisterRiskAssessmentCommand;
import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class RegisterRiskAssessmentUseCase {
    private final RiskAssessmentRepository repository;
    private final RiskLevelRepository riskLevelRepository;

    public RegisterRiskAssessmentUseCase(
            RiskAssessmentRepository repository,
            RiskLevelRepository riskLevelRepository
    ) {
        this.repository = repository;
        this.riskLevelRepository = riskLevelRepository;
    }

    public RiskAssessmentResponse execute(RegisterRiskAssessmentCommand command) {
        RiskAssessment entity = RiskAssessment.register(
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
        RiskAssessment saved = repository.save(entity);
        return new RiskAssessmentResponse(
                saved.id().value(),
                saved.encounterId(),
                saved.riskLevelId(),
                riskLevelRepository.findById(new com.backintro.domain.risklevel.model.valueobject.RiskLevelId(saved.riskLevelId())).map(c -> c.name()).orElse(null),
                saved.suicidalIdeation(),
                saved.suicidePlan(),
                saved.suicideIntent(),
                saved.selfHarm(),
                saved.harmToOthers(),
                saved.protectiveFactors(),
                saved.riskFactors(),
                saved.clinicalActions(),
                saved.observations(),
                saved.assessedAt(),
                saved.assessedBy()
        );
    }
}