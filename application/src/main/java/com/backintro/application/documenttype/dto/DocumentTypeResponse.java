package com.backintro.application.documenttype.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record DocumentTypeResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}