package com.backintro.application.mentalstatusexam.usecase;

import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class GetMentalStatusExamByIdUseCase {
    private final MentalStatusExamRepository repository;

    public GetMentalStatusExamByIdUseCase(
            MentalStatusExamRepository repository
    ) {
        this.repository = repository;
    }

    public MentalStatusExamResponse execute(MentalStatusExamId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(id.value().toString()));
        return new MentalStatusExamResponse(
                entity.id().value(),
                entity.encounterId(),
                entity.appearance(),
                entity.behavior(),
                entity.attitude(),
                entity.consciousness(),
                entity.orientation(),
                entity.attention(),
                entity.memory(),
                entity.speech(),
                entity.mood(),
                entity.affect(),
                entity.thoughtProcess(),
                entity.thoughtContent(),
                entity.perception(),
                entity.judgment(),
                entity.insight(),
                entity.psychomotorActivity(),
                entity.observations(),
                entity.createdBy(),
                null
        );
    }
}