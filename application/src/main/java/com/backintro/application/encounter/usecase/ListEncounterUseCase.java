package com.backintro.application.encounter.usecase;

import java.util.List;

import com.backintro.application.encounter.dto.EncounterResponse;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class ListEncounterUseCase {
    private final EncounterRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final EncounterTypeRepository encounterTypeRepository;
    private final EncounterModalityRepository encounterModalityRepository;
    private final EncounterStatusRepository encounterStatusRepository;

    public ListEncounterUseCase(
            EncounterRepository repository,
            ProfessionalRepository professionalRepository,
            EncounterTypeRepository encounterTypeRepository,
            EncounterModalityRepository encounterModalityRepository,
            EncounterStatusRepository encounterStatusRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
        this.encounterTypeRepository = encounterTypeRepository;
        this.encounterModalityRepository = encounterModalityRepository;
        this.encounterStatusRepository = encounterStatusRepository;
    }

    public List<EncounterResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new EncounterResponse(
                entity.id().value(),
                entity.clinicalRecordId(),
                entity.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(entity.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.encounterTypeId(),
                encounterTypeRepository.findById(new com.backintro.domain.encountertype.model.valueobject.EncounterTypeId(entity.encounterTypeId())).map(c -> c.name()).orElse(null),
                entity.startedAt(),
                entity.endedAt(),
                entity.reasonForVisit(),
                entity.currentCondition(),
                entity.modalityId(),
                encounterModalityRepository.findById(new com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId(entity.modalityId())).map(c -> c.name()).orElse(null),
                entity.statusId(),
                encounterStatusRepository.findById(new com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId(entity.statusId())).map(c -> c.name()).orElse(null),
                entity.createdBy(),
                entity.updatedBy(),
                null,
                null
                ))
                .toList();
    }
}