package com.backintro.application.country.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record CountryResponse(
        UUID id,
        String code,
        String name,
        String description,
        boolean active,
        String telephonePrefix,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}