package com.backintro.application.diagnosticsystem.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record DiagnosticSystemResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        String version,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}