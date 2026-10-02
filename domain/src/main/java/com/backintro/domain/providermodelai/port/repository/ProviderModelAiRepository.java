package com.backintro.domain.providermodelai.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public interface ProviderModelAiRepository {
    ProviderModelAi save(ProviderModelAi entity);
    Optional<ProviderModelAi> findById(ProviderModelAiId id);
    List<ProviderModelAi> findAll();
    void delete(ProviderModelAi entity);
}