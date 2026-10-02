package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.command.UpdateProviderModelAiCommand;
import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class UpdateProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public UpdateProviderModelAiUseCase(
            ProviderModelAiRepository repository
    ) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(UpdateProviderModelAiCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.nameProviderAi(),
                command.razonSocial(),
                command.sitioWeb()
        );

        var updated = repository.save(entity);
        return new ProviderModelAiResponse(
                updated.id().value(),
                updated.nameProviderAi(),
                updated.razonSocial(),
                updated.sitioWeb(),
                updated.active(),
                null,
                null
        );
    }
}