package com.backintro.application.emailcontact.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record EmailContactResponse(
        UUID id,
        UUID contactId,
        String contactName,
        String email,
        String notes,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}