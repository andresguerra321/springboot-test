package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.command.RegisterProviderModelAiCommand;
import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class RegisterProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public RegisterProviderModelAiUseCase(
            ProviderModelAiRepository repository
    ) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(RegisterProviderModelAiCommand command) {
        ProviderModelAi entity = ProviderModelAi.register(
                command.nameProviderAi(),
                command.razonSocial(),
                command.sitioWeb()
        );
        ProviderModelAi saved = repository.save(entity);
        return new ProviderModelAiResponse(
                saved.id().value(),
                saved.nameProviderAi(),
                saved.razonSocial(),
                saved.sitioWeb(),
                saved.active(),
                null,
                null
        );
    }
}