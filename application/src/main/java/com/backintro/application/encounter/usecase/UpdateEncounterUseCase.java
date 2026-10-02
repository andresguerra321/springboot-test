package com.backintro.application.encounter.usecase;

import com.backintro.application.encounter.command.UpdateEncounterCommand;
import com.backintro.application.encounter.dto.EncounterResponse;
import com.backintro.application.encounter.exception.EncounterNotFoundApplicationException;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class UpdateEncounterUseCase {
    private final EncounterRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final EncounterTypeRepository encounterTypeRepository;
    private final EncounterModalityRepository encounterModalityRepository;
    private final EncounterStatusRepository encounterStatusRepository;

    public UpdateEncounterUseCase(
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

    public EncounterResponse execute(UpdateEncounterCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new EncounterNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.clinicalRecordId(),
                command.professionalId(),
                command.encounterTypeId(),
                command.startedAt(),
                command.endedAt(),
                command.reasonForVisit(),
                command.currentCondition(),
                command.modalityId(),
                command.statusId(),
                command.createdBy(),
                command.updatedBy()
        );

        var updated = repository.save(entity);
        return new EncounterResponse(
                updated.id().value(),
                updated.clinicalRecordId(),
                updated.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(updated.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.encounterTypeId(),
                encounterTypeRepository.findById(new com.backintro.domain.encountertype.model.valueobject.EncounterTypeId(updated.encounterTypeId())).map(c -> c.name()).orElse(null),
                updated.startedAt(),
                updated.endedAt(),
                updated.reasonForVisit(),
                updated.currentCondition(),
                updated.modalityId(),
                encounterModalityRepository.findById(new com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId(updated.modalityId())).map(c -> c.name()).orElse(null),
                updated.statusId(),
                encounterStatusRepository.findById(new com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId(updated.statusId())).map(c -> c.name()).orElse(null),
                updated.createdBy(),
                updated.updatedBy(),
                null,
                null
        );
    }
}