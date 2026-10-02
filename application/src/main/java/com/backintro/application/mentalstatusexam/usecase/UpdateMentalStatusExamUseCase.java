package com.backintro.application.mentalstatusexam.usecase;

import com.backintro.application.mentalstatusexam.command.UpdateMentalStatusExamCommand;
import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class UpdateMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public UpdateMentalStatusExamUseCase(
            MentalStatusExamRepository repository
    ) {
        this.repository = repository;
    }

    public MentalStatusExamResponse execute(UpdateMentalStatusExamCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.encounterId(),
                command.appearance(),
                command.behavior(),
                command.attitude(),
                command.consciousness(),
                command.orientation(),
                command.attention(),
                command.memory(),
                command.speech(),
                command.mood(),
                command.affect(),
                command.thoughtProcess(),
                command.thoughtContent(),
                command.perception(),
                command.judgment(),
                command.insight(),
                command.psychomotorActivity(),
                command.observations(),
                command.createdBy()
        );

        var updated = repository.save(entity);
        return new MentalStatusExamResponse(
                updated.id().value(),
                updated.encounterId(),
                updated.appearance(),
                updated.behavior(),
                updated.attitude(),
                updated.consciousness(),
                updated.orientation(),
                updated.attention(),
                updated.memory(),
                updated.speech(),
                updated.mood(),
                updated.affect(),
                updated.thoughtProcess(),
                updated.thoughtContent(),
                updated.perception(),
                updated.judgment(),
                updated.insight(),
                updated.psychomotorActivity(),
                updated.observations(),
                updated.createdBy(),
                null
        );
    }
}