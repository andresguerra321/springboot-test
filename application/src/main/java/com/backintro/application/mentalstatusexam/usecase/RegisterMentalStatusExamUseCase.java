package com.backintro.application.mentalstatusexam.usecase;

import com.backintro.application.mentalstatusexam.command.RegisterMentalStatusExamCommand;
import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class RegisterMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public RegisterMentalStatusExamUseCase(
            MentalStatusExamRepository repository
    ) {
        this.repository = repository;
    }

    public MentalStatusExamResponse execute(RegisterMentalStatusExamCommand command) {
        MentalStatusExam entity = MentalStatusExam.register(
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
        MentalStatusExam saved = repository.save(entity);
        return new MentalStatusExamResponse(
                saved.id().value(),
                saved.encounterId(),
                saved.appearance(),
                saved.behavior(),
                saved.attitude(),
                saved.consciousness(),
                saved.orientation(),
                saved.attention(),
                saved.memory(),
                saved.speech(),
                saved.mood(),
                saved.affect(),
                saved.thoughtProcess(),
                saved.thoughtContent(),
                saved.perception(),
                saved.judgment(),
                saved.insight(),
                saved.psychomotorActivity(),
                saved.observations(),
                saved.createdBy(),
                null
        );
    }
}