package com.backintro.domain.professional.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de estudio académico del profesional (dentro del agregado Professional).
 */
public class ProfessionalStudy {

    private UUID id;
    private UUID studyId;
    private UUID professionalId;
    private String title;
    private String university;
    private Boolean isValid;
    private String resolutionNumber;
    private UUID countryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProfessionalStudy() {}

    public ProfessionalStudy(UUID id, UUID studyId, UUID professionalId, String title, String university,
                             Boolean isValid, String resolutionNumber, UUID countryId,
                             LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.studyId = studyId;
        this.professionalId = professionalId;
        this.title = title;
        this.university = university;
        this.isValid = isValid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = countryId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ProfessionalStudy create(UUID studyId, UUID professionalId, String title,
                                           String university, UUID countryId) {
        LocalDateTime now = LocalDateTime.now();
        return new ProfessionalStudy(UUID.randomUUID(), studyId, professionalId, title,
                university, null, null, countryId, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getStudyId() { return studyId; }
    public void setStudyId(UUID studyId) { this.studyId = studyId; }
    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }
    public Boolean getIsValid() { return isValid; }
    public void setIsValid(Boolean valid) { isValid = valid; }
    public String getResolutionNumber() { return resolutionNumber; }
    public void setResolutionNumber(String resolutionNumber) { this.resolutionNumber = resolutionNumber; }
    public UUID getCountryId() { return countryId; }
    public void setCountryId(UUID countryId) { this.countryId = countryId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((ProfessionalStudy) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "ProfessionalStudy{id=" + id + ", title='" + title + "', university='" + university + "'}";
    }
}
