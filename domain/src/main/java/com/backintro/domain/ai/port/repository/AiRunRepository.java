package com.backintro.domain.ai.port.repository;

import com.backintro.domain.ai.model.aggregate.AiModel;
import com.backintro.domain.ai.model.aggregate.ChatAiRun;
import com.backintro.domain.ai.model.aggregate.ProviderModelAi;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AiRunRepository {

    ProviderModelAi saveProvider(ProviderModelAi provider);

    Optional<ProviderModelAi> findProviderById(UUID id);

    List<ProviderModelAi> findAllProviders();

    AiModel saveModel(AiModel model);

    Optional<AiModel> findModelById(UUID id);

    List<AiModel> findModelsByProviderId(UUID providerId);

    ChatAiRun saveRun(ChatAiRun aiRun);

    Optional<ChatAiRun> findRunById(UUID id);

    List<ChatAiRun> findRunsByConversationId(UUID conversationId);
}
