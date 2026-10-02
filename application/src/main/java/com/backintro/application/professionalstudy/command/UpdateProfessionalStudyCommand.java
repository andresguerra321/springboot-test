package com.backintro.application.professionalstudy.command;

import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

public record UpdateProfessionalStudyCommand(
        ProfessionalStudyId id,
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId
) {
    public UpdateProfessionalStudyCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(studyId, "studyId must not be null");
        Objects.requireNonNull(professionalId, "professionalId must not be null");
        Objects.requireNonNull(title, "title must not be null");
    }
}