package com.backintro.domain.professionalstudy.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.professionalstudy.event.ProfessionalStudyRegisteredEvent;
import com.backintro.domain.professionalstudy.event.ProfessionalStudyUpdatedEvent;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

public class ProfessionalStudy extends AggregateRoot {
    private final ProfessionalStudyId id;
    private UUID studyId;
    private UUID professionalId;
    private String title;
    private String university;
    private boolean valid;
    private String resolutionNumber;
    private UUID countryId;

    private ProfessionalStudy(
        ProfessionalStudyId id,
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.studyId = Objects.requireNonNull(studyId, "studyId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.university = university;
        this.valid = valid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = countryId;
    }

    public static ProfessionalStudy register(
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId) {

        ProfessionalStudyId id = ProfessionalStudyId.generate();

        ProfessionalStudy entity = new ProfessionalStudy(
            id,
            studyId,
            professionalId,
            title,
            university,
            valid,
            resolutionNumber,
            countryId);

        entity.recordEvent(
            new ProfessionalStudyRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ProfessionalStudy restore(
        ProfessionalStudyId id,
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId) {
        return new ProfessionalStudy(
            id,
            studyId,
            professionalId,
            title,
            university,
            valid,
            resolutionNumber,
            countryId);
    }

    public void update(
        UUID studyId,
        UUID professionalId,
        String title,
        String university,
        boolean valid,
        String resolutionNumber,
        UUID countryId) {

        this.studyId = Objects.requireNonNull(studyId);
        this.professionalId = Objects.requireNonNull(professionalId);
        this.title = Objects.requireNonNull(title);
        this.university = university;
        this.valid = valid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = countryId;

        recordEvent(
            new ProfessionalStudyUpdatedEvent(
                this.id,
                this.studyId,
                this.professionalId,
                this.title,
                this.university,
                this.valid,
                this.resolutionNumber,
                this.countryId,
                LocalDateTime.now()));
    }

    public ProfessionalStudyId id() {
        return id;
    }

    public UUID studyId() {
        return studyId;
    }
    public UUID professionalId() {
        return professionalId;
    }
    public String title() {
        return title;
    }
    public String university() {
        return university;
    }
    public boolean valid() {
        return valid;
    }
    public String resolutionNumber() {
        return resolutionNumber;
    }
    public UUID countryId() {
        return countryId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ProfessionalStudyId getId() {
        return id();
    }

    public UUID getStudyId() {
        return studyId();
    }
    public UUID getProfessionalId() {
        return professionalId();
    }
    public String getTitle() {
        return title();
    }
    public String getUniversity() {
        return university();
    }
    public boolean isValid() {
        return valid();
    }
    public String getResolutionNumber() {
        return resolutionNumber();
    }
    public UUID getCountryId() {
        return countryId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalStudy that = (ProfessionalStudy) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProfessionalStudy{" +
                "id=" + id +
                '}';
    }
}