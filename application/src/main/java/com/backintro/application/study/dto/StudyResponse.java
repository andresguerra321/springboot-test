package com.backintro.application.study.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record StudyResponse(
        UUID id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}