package com.backintro.infrastructure.providermodelai.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProviderModelAiRequest(
        @NotBlank(message = "nameProviderAi is required")
        String nameProviderAi,

        String razonSocial,

        String sitioWeb
) {}