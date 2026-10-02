package com.backintro.application.providermodelai.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterProviderModelAiCommand(
        String nameProviderAi,
        String razonSocial,
        String sitioWeb
) {
    public RegisterProviderModelAiCommand {
        Objects.requireNonNull(nameProviderAi, "nameProviderAi must not be null");
    }
}