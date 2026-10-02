package com.backintro.application.mentalstatusexam.usecase;

import java.util.List;

import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class ListMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public ListMentalStatusExamUseCase(
            MentalStatusExamRepository repository
    ) {
        this.repository = repository;
    }

    public List<MentalStatusExamResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new MentalStatusExamResponse(
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
                ))
                .toList();
    }
}