package com.backintro.application.clinicalrecordstatus.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ClinicalRecordStatusResponse(
        UUID id,
        String code,
        String name,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}