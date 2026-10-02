package com.backintro.application.treatmentplan.usecase;

import java.util.List;

import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class ListTreatmentPlanUseCase {
    private final TreatmentPlanRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final TreatmentStatusRepository treatmentStatusRepository;

    public ListTreatmentPlanUseCase(
            TreatmentPlanRepository repository,
            ProfessionalRepository professionalRepository,
            TreatmentStatusRepository treatmentStatusRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public List<TreatmentPlanResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new TreatmentPlanResponse(
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
                ))
                .toList();
    }
}