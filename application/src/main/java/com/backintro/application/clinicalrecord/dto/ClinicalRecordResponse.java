package com.backintro.application.clinicalrecord.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record ClinicalRecordResponse(
        UUID id,
        UUID patientId,
        String patientName,
        java.time.LocalDateTime creationDate,
        String recordNumber,
        java.time.LocalDateTime openedAt,
        java.time.LocalDateTime closedAt,
        UUID statusId,
        String statusName,
        UUID createdBy,
        LocalDateTime createdAt
) {
}