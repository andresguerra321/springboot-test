package com.backintro.domain.providermodelai.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.providermodelai.event.ProviderModelAiRegisteredEvent;
import com.backintro.domain.providermodelai.event.ProviderModelAiUpdatedEvent;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public class ProviderModelAi extends AggregateRoot {
    private final ProviderModelAiId id;
    private String nameProviderAi;
    private String razonSocial;
    private String sitioWeb;
    private boolean active;

    private ProviderModelAi(
        ProviderModelAiId id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameProviderAi = Objects.requireNonNull(nameProviderAi, "nameProviderAi must not be null");
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        this.active = active;
    }

    public static ProviderModelAi register(
        String nameProviderAi,
        String razonSocial,
        String sitioWeb) {

        ProviderModelAiId id = ProviderModelAiId.generate();

        ProviderModelAi entity = new ProviderModelAi(
            id,
            nameProviderAi,
            razonSocial,
            sitioWeb,
            true);

        entity.recordEvent(
            new ProviderModelAiRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ProviderModelAi restore(
        ProviderModelAiId id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        boolean active) {
        return new ProviderModelAi(
            id,
            nameProviderAi,
            razonSocial,
            sitioWeb,
            active);
    }

    public void update(
        String nameProviderAi,
        String razonSocial,
        String sitioWeb) {

        this.nameProviderAi = Objects.requireNonNull(nameProviderAi);
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;

        recordEvent(
            new ProviderModelAiUpdatedEvent(
                this.id,
                this.nameProviderAi,
                this.razonSocial,
                this.sitioWeb,
                LocalDateTime.now()));
    }

    public ProviderModelAiId id() {
        return id;
    }

    public String nameProviderAi() {
        return nameProviderAi;
    }
    public String razonSocial() {
        return razonSocial;
    }
    public String sitioWeb() {
        return sitioWeb;
    }
    public boolean active() {
        return active;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ProviderModelAiId getId() {
        return id();
    }

    public String getNameProviderAi() {
        return nameProviderAi();
    }
    public String getRazonSocial() {
        return razonSocial();
    }
    public String getSitioWeb() {
        return sitioWeb();
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderModelAi that = (ProviderModelAi) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProviderModelAi{" +
                "id=" + id +
                '}';
    }
}