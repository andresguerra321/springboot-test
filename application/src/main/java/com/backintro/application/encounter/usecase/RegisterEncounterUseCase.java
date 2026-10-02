package com.backintro.application.encounter.usecase;

import com.backintro.application.encounter.command.RegisterEncounterCommand;
import com.backintro.application.encounter.dto.EncounterResponse;
import com.backintro.domain.encounter.model.aggregate.Encounter;
import com.backintro.domain.encounter.port.repository.EncounterRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;
import com.backintro.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.backintro.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class RegisterEncounterUseCase {
    private final EncounterRepository repository;
    private final ProfessionalRepository professionalRepository;
    private final EncounterTypeRepository encounterTypeRepository;
    private final EncounterModalityRepository encounterModalityRepository;
    private final EncounterStatusRepository encounterStatusRepository;

    public RegisterEncounterUseCase(
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

    public EncounterResponse execute(RegisterEncounterCommand command) {
        Encounter entity = Encounter.register(
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
        Encounter saved = repository.save(entity);
        return new EncounterResponse(
                saved.id().value(),
                saved.clinicalRecordId(),
                saved.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(saved.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.encounterTypeId(),
                encounterTypeRepository.findById(new com.backintro.domain.encountertype.model.valueobject.EncounterTypeId(saved.encounterTypeId())).map(c -> c.name()).orElse(null),
                saved.startedAt(),
                saved.endedAt(),
                saved.reasonForVisit(),
                saved.currentCondition(),
                saved.modalityId(),
                encounterModalityRepository.findById(new com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId(saved.modalityId())).map(c -> c.name()).orElse(null),
                saved.statusId(),
                encounterStatusRepository.findById(new com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId(saved.statusId())).map(c -> c.name()).orElse(null),
                saved.createdBy(),
                saved.updatedBy(),
                null,
                null
        );
    }
}