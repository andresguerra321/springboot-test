package com.backintro.application.aimodel.usecase;

import java.util.List;

import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class ListAiModelUseCase {
    private final AiModelRepository repository;
    private final ProviderModelAiRepository providerModelAiRepository;

    public ListAiModelUseCase(
            AiModelRepository repository,
            ProviderModelAiRepository providerModelAiRepository
    ) {
        this.repository = repository;
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public List<AiModelResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new AiModelResponse(
                entity.id().value(),
                entity.providerModelId(),
                providerModelAiRepository.findById(new com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId(entity.providerModelId())).map(c -> c.nameProviderAi()).orElse(null),
                entity.nameModel(),
                entity.modelKey(),
                entity.inputTokenPrice(),
                entity.outputTokenPrice(),
                entity.maxTokens(),
                entity.contextWindow(),
                entity.active(),
                null,
                null
                ))
                .toList();
    }
}