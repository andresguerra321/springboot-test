package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.command.RegisterTreatmentPlanCommand;
import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class RegisterTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final TreatmentStatusRepository treatmentStatusRepository;

    public RegisterTreatmentPlanUseCase(
            TreatmentPlanRepository repository,
            ProfessionalRepository professionalRepository,
            TreatmentStatusRepository treatmentStatusRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public TreatmentPlanResponse execute(RegisterTreatmentPlanCommand command) {
        TreatmentPlan entity = TreatmentPlan.register(
                command.encounterId(),
                command.professionalId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate(),
                command.treatmentStatusId()
        );
        TreatmentPlan saved = repository.save(entity);
        return new TreatmentPlanResponse(
                saved.id().value(),
                saved.encounterId(),
                saved.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(saved.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.title(),
                saved.description(),
                saved.startDate(),
                saved.endDate(),
                saved.treatmentStatusId(),
                treatmentStatusRepository.findById(new com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId(saved.treatmentStatusId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}