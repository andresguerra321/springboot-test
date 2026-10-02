package com.backintro.application.providermodelai.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;

public record UpdateProviderModelAiCommand(
        ProviderModelAiId id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb
) {
    public UpdateProviderModelAiCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(nameProviderAi, "nameProviderAi must not be null");
    }
}