package com.backintro.application.providermodelai.usecase;

import java.time.LocalDateTime;

import com.backintro.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import com.backintro.domain.providermodelai.event.ProviderModelAiDeletedEvent;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class DeleteProviderModelAiUseCase {
    private final ProviderModelAiRepository repository;

    public DeleteProviderModelAiUseCase(ProviderModelAiRepository repository) {
        this.repository = repository;
    }

    public ProviderModelAiDeletedEvent execute(ProviderModelAiId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ProviderModelAiNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ProviderModelAiDeletedEvent(id, LocalDateTime.now());
    }
}