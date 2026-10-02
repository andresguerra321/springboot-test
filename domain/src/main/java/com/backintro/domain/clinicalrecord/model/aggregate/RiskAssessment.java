package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class RiskAssessment {

    private UUID id;
    private UUID encounterId;
    private UUID riskLevelId;
    private Boolean suicidalIdeation;
    private Boolean suicidePlan;
    private Boolean suicideIntent;
    private Boolean selfHarm;
    private Boolean harmToOthers;
    private String protectiveFactors;
    private String riskFactors;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RiskAssessment() {
    }

    public RiskAssessment(UUID id, UUID encounterId, UUID riskLevelId, Boolean suicidalIdeation,
                          Boolean suicidePlan, Boolean suicideIntent, Boolean selfHarm, Boolean harmToOthers,
                          String protectiveFactors, String riskFactors, String notes,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.encounterId = encounterId;
        this.riskLevelId = riskLevelId;
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.protectiveFactors = protectiveFactors;
        this.riskFactors = riskFactors;
        this.notes = notes;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static RiskAssessment create(UUID encounterId, UUID riskLevelId, String notes) {
        LocalDateTime now = LocalDateTime.now();
        return new RiskAssessment(
                UUID.randomUUID(),
                encounterId,
                riskLevelId,
                false,
                false,
                false,
                false,
                false,
                null,
                null,
                notes,
                now,
                now
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(UUID encounterId) {
        this.encounterId = encounterId;
    }

    public UUID getRiskLevelId() {
        return riskLevelId;
    }

    public void setRiskLevelId(UUID riskLevelId) {
        this.riskLevelId = riskLevelId;
    }

    public Boolean getSuicidalIdeation() {
        return suicidalIdeation;
    }

    public void setSuicidalIdeation(Boolean suicidalIdeation) {
        this.suicidalIdeation = suicidalIdeation;
    }

    public Boolean getSuicidePlan() {
        return suicidePlan;
    }

    public void setSuicidePlan(Boolean suicidePlan) {
        this.suicidePlan = suicidePlan;
    }

    public Boolean getSuicideIntent() {
        return suicideIntent;
    }

    public void setSuicideIntent(Boolean suicideIntent) {
        this.suicideIntent = suicideIntent;
    }

    public Boolean getSelfHarm() {
        return selfHarm;
    }

    public void setSelfHarm(Boolean selfHarm) {
        this.selfHarm = selfHarm;
    }

    public Boolean getHarmToOthers() {
        return harmToOthers;
    }

    public void setHarmToOthers(Boolean harmToOthers) {
        this.harmToOthers = harmToOthers;
    }

    public String getProtectiveFactors() {
        return protectiveFactors;
    }

    public void setProtectiveFactors(String protectiveFactors) {
        this.protectiveFactors = protectiveFactors;
    }

    public String getRiskFactors() {
        return riskFactors;
    }

    public void setRiskFactors(String riskFactors) {
        this.riskFactors = riskFactors;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskAssessment that = (RiskAssessment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
