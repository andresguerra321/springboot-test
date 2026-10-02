package com.backintro.application.citymunicipality.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record CityMunicipalityResponse(
        UUID id,
        String code,
        String name,
        String description,
        boolean active,
        UUID regionId,
        String regionName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}