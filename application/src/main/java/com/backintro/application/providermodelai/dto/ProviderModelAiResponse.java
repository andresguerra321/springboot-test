package com.backintro.application.providermodelai.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ProviderModelAiResponse(
        UUID id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}