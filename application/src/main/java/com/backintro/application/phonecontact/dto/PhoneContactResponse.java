package com.backintro.application.phonecontact.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record PhoneContactResponse(
        UUID id,
        UUID contactId,
        String contactName,
        String phone,
        String notes
) {
}