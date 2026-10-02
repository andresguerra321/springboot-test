package com.backintro.application.risklevel.usecase;

import java.util.List;

import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class ListRiskLevelUseCase {

    private final RiskLevelRepository repository;

    public ListRiskLevelUseCase(
            RiskLevelRepository repository
    ) {
        this.repository = repository;
    }

    public List<RiskLevelResponse> execute() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new RiskLevelResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                entity.severity(),
                null,
                null
                        )
                )
                .toList();
    }
}