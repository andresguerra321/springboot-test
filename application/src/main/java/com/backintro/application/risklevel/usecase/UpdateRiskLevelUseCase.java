package com.backintro.application.risklevel.usecase;

import com.backintro.application.risklevel.command.UpdateRiskLevelCommand;
import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class UpdateRiskLevelUseCase {

    private final RiskLevelRepository repository;

    public UpdateRiskLevelUseCase(
            RiskLevelRepository repository
    ) {
        this.repository = repository;
    }

    public RiskLevelResponse execute(
            UpdateRiskLevelCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new RiskLevelNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name(),
                command.severity()
        );

        var updated =
                repository.save(entity);

        return new RiskLevelResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                updated.severity(),
                null,
                null
        );
    }
}