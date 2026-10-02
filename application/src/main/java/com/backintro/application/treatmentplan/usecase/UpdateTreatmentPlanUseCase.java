package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.command.UpdateTreatmentPlanCommand;
import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class UpdateTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final TreatmentStatusRepository treatmentStatusRepository;

    public UpdateTreatmentPlanUseCase(
            TreatmentPlanRepository repository,
            ProfessionalRepository professionalRepository,
            TreatmentStatusRepository treatmentStatusRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public TreatmentPlanResponse execute(UpdateTreatmentPlanCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.encounterId(),
                command.professionalId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate(),
                command.treatmentStatusId()
        );

        var updated = repository.save(entity);
        return new TreatmentPlanResponse(
                updated.id().value(),
                updated.encounterId(),
                updated.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(updated.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.title(),
                updated.description(),
                updated.startDate(),
                updated.endDate(),
                updated.treatmentStatusId(),
                treatmentStatusRepository.findById(new com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId(updated.treatmentStatusId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}