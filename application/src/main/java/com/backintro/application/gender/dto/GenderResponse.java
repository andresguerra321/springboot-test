package com.backintro.application.gender.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record GenderResponse(
        UUID id,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}