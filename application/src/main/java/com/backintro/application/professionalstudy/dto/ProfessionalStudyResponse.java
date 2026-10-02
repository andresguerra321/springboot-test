package com.backintro.application.professionalstudy.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ProfessionalStudyResponse(
        UUID id,
        UUID studyId,
        String studyName,
        UUID professionalId,
        String professionalName,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId,
        String countryName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}