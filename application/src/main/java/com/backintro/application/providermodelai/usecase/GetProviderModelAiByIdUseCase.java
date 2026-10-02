package com.backintro.application.providermodelai.usecase;

import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class GetProviderModelAiByIdUseCase {
    private final ProviderModelAiRepository repository;

    public GetProviderModelAiByIdUseCase(
            ProviderModelAiRepository repository
    ) {
        this.repository = repository;
    }

    public ProviderModelAiResponse execute(ProviderModelAiId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(id.value().toString()));
        return new ProviderModelAiResponse(
                entity.id().value(),
                entity.nameProviderAi(),
                entity.razonSocial(),
                entity.sitioWeb(),
                entity.active(),
                null,
                null
        );
    }
}