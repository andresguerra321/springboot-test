package com.backintro.infrastructure.providermodelai.adapters.out.persistence.mappers;

import com.backintro.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;

public class ProviderModelAiPersistenceMapper {

    public ProviderModelAiJpaEntity toJpa(ProviderModelAi domain) {
        if (domain == null) return null;
        ProviderModelAiJpaEntity jpa = new ProviderModelAiJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameProviderAi(domain.nameProviderAi());
        jpa.setRazonSocial(domain.razonSocial());
        jpa.setSitioWeb(domain.sitioWeb());
        jpa.setActive(domain.active());
        return jpa;
    }

    public ProviderModelAi toDomain(ProviderModelAiJpaEntity jpa) {
        if (jpa == null) return null;
        return ProviderModelAi.restore(
                new ProviderModelAiId(jpa.getId()),
                jpa.getNameProviderAi(),
                jpa.getRazonSocial(),
                jpa.getSitioWeb(),
                jpa.isActive()
        );
    }
}