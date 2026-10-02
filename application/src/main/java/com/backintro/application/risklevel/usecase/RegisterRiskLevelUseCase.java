package com.backintro.application.risklevel.usecase;

import com.backintro.application.risklevel.command.RegisterRiskLevelCommand;
import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class RegisterRiskLevelUseCase {

    private final RiskLevelRepository repository;

    public RegisterRiskLevelUseCase(
            RiskLevelRepository repository
    ) {
        this.repository = repository;
    }

    public RiskLevelResponse execute(
            RegisterRiskLevelCommand command
    ) {

        RiskLevel entity = RiskLevel.register(
                command.code(),
                command.name(),
                command.severity()
        );

        RiskLevel saved =
                repository.save(entity);

        return new RiskLevelResponse(
                saved.id().value(),
                saved.code(),
                saved.name(),
                saved.active(),
                saved.severity(),
                null,
                null
        );
    }
}