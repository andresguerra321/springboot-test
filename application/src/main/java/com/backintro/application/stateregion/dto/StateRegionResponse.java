package com.backintro.application.stateregion.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record StateRegionResponse(
        UUID id,
        String code,
        String name,
        String description,
        boolean active,
        UUID countryId,
        String countryName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}