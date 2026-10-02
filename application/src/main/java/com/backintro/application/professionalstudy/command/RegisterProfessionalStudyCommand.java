package com.backintro.application.professionalstudy.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterProfessionalStudyCommand(
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId
) {
    public RegisterProfessionalStudyCommand {
        Objects.requireNonNull(studyId, "studyId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(title, "title must not be null");
    }
}