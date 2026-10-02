package com.backintro.application.study.usecase;

import java.util.List;

import com.backintro.application.study.dto.StudyResponse;
import com.backintro.domain.study.port.repository.StudyRepository;

public class ListStudyUseCase {

    private final StudyRepository repository;

    public ListStudyUseCase(
            StudyRepository repository
    ) {
        this.repository = repository;
    }

    public List<StudyResponse> execute() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new StudyResponse(
                entity.id().value(),
                entity.name(),
                null,
                null
                        )
                )
                .toList();
    }
}