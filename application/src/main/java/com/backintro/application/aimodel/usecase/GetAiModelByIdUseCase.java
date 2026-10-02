package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class GetAiModelByIdUseCase {
    private final AiModelRepository repository;
    private final ProviderModelAiRepository providerModelAiRepository;

    public GetAiModelByIdUseCase(
            AiModelRepository repository,
            ProviderModelAiRepository providerModelAiRepository
    ) {
        this.repository = repository;
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public AiModelResponse execute(AiModelId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new AiModelNotFoundApplicationException(id.value().toString()));
        return new AiModelResponse(
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
        );
    }
}