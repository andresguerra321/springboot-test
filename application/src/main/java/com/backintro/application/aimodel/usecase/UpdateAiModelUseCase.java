package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.command.UpdateAiModelCommand;
import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class UpdateAiModelUseCase {
    private final AiModelRepository repository;
    private final ProviderModelAiRepository providerModelAiRepository;

    public UpdateAiModelUseCase(
            AiModelRepository repository,
            ProviderModelAiRepository providerModelAiRepository
    ) {
        this.repository = repository;
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public AiModelResponse execute(UpdateAiModelCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new AiModelNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.providerModelId(),
                command.nameModel(),
                command.modelKey(),
                command.inputTokenPrice(),
                command.outputTokenPrice(),
                command.maxTokens(),
                command.contextWindow()
        );

        var updated = repository.save(entity);
        return new AiModelResponse(
                updated.id().value(),
                updated.providerModelId(),
                providerModelAiRepository.findById(new com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId(updated.providerModelId())).map(c -> c.nameProviderAi()).orElse(null),
                updated.nameModel(),
                updated.modelKey(),
                updated.inputTokenPrice(),
                updated.outputTokenPrice(),
                updated.maxTokens(),
                updated.contextWindow(),
                updated.active(),
                null,
                null
        );
    }
}