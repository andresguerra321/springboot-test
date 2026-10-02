package com.backintro.application.risklevel.usecase;

import java.time.LocalDateTime;

import com.backintro.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.backintro.domain.risklevel.event.RiskLevelDeletedEvent;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class DeleteRiskLevelUseCase {

    private final RiskLevelRepository repository;

    public DeleteRiskLevelUseCase(
            RiskLevelRepository repository
    ) {
        this.repository = repository;
    }

    public RiskLevelDeletedEvent execute(
            RiskLevelId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RiskLevelNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new RiskLevelDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}