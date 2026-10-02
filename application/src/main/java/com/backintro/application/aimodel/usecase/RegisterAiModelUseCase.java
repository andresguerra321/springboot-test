package com.backintro.application.aimodel.usecase;

import com.backintro.application.aimodel.command.RegisterAiModelCommand;
import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.domain.aimodel.model.aggregate.AiModel;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.domain.providermodelai.port.repository.ProviderModelAiRepository;

public class RegisterAiModelUseCase {
    private final AiModelRepository repository;
    private final ProviderModelAiRepository providerModelAiRepository;

    public RegisterAiModelUseCase(
            AiModelRepository repository,
            ProviderModelAiRepository providerModelAiRepository
    ) {
        this.repository = repository;
        this.providerModelAiRepository = providerModelAiRepository;
    }

    public AiModelResponse execute(RegisterAiModelCommand command) {
        AiModel entity = AiModel.register(
                command.providerModelId(),
                command.nameModel(),
                command.modelKey(),
                command.inputTokenPrice(),
                command.outputTokenPrice(),
                command.maxTokens(),
                command.contextWindow()
        );
        AiModel saved = repository.save(entity);
        return new AiModelResponse(
                saved.id().value(),
                saved.providerModelId(),
                providerModelAiRepository.findById(new com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId(saved.providerModelId())).map(c -> c.nameProviderAi()).orElse(null),
                saved.nameModel(),
                saved.modelKey(),
                saved.inputTokenPrice(),
                saved.outputTokenPrice(),
                saved.maxTokens(),
                saved.contextWindow(),
                saved.active(),
                null,
                null
        );
    }
}