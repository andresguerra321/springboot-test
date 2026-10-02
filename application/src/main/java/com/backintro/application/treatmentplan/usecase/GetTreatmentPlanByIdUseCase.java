package com.backintro.application.treatmentplan.usecase;

import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class GetTreatmentPlanByIdUseCase {
    private final TreatmentPlanRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final TreatmentStatusRepository treatmentStatusRepository;

    public GetTreatmentPlanByIdUseCase(
            TreatmentPlanRepository repository,
            ProfessionalRepository professionalRepository,
            TreatmentStatusRepository treatmentStatusRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public TreatmentPlanResponse execute(TreatmentPlanId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(id.value().toString()));
        return new TreatmentPlanResponse(
                entity.id().value(),
                entity.encounterId(),
                entity.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(entity.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.title(),
                entity.description(),
                entity.startDate(),
                entity.endDate(),
                entity.treatmentStatusId(),
                treatmentStatusRepository.findById(new com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId(entity.treatmentStatusId())).map(c -> c.name()).orElse(null),
                null,
                null
        );
    }
}