package com.backintro.application.patientcontact.dto;

import java.util.UUID;
import java.time.LocalDateTime;

public record PatientContactResponse(
        UUID id,
        UUID contactId,
        UUID patientId,
        String patientName,
        Boolean primaryContact,
        Boolean emergencyContact,
        UUID relationshipTypeId,
        String relationshipTypeName
) {
}