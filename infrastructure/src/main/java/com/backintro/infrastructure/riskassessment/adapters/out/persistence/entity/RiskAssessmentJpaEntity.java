package com.backintro.infrastructure.riskassessment.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessmentJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "encounter_id", nullable = false)
    private UUID encounterId;
    @Column(name = "risk_level_id", nullable = false)
    private UUID riskLevelId;
    @Column(name = "suicidal_ideation", nullable = true)
    private boolean suicidalIdeation;
    @Column(name = "suicide_plan", nullable = true)
    private boolean suicidePlan;
    @Column(name = "suicide_intent", nullable = true)
    private boolean suicideIntent;
    @Column(name = "self_harm", nullable = true)
    private boolean selfHarm;
    @Column(name = "harm_to_others", nullable = true)
    private boolean harmToOthers;
    @Column(name = "protective_factors", nullable = true)
    private String protectiveFactors;
    @Column(name = "risk_factors", nullable = true)
    private String riskFactors;
    @Column(name = "clinical_actions", nullable = true)
    private String clinicalActions;
    @Column(name = "observations", nullable = true)
    private String observations;
    @Column(name = "assessed_at", nullable = true)
    private java.time.LocalDateTime assessedAt;
    @Column(name = "assessed_by", nullable = true)
    private UUID assessedBy;

    public RiskAssessmentJpaEntity() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

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
    public boolean isSuicidalIdeation() {
        return suicidalIdeation;
    }
    public void setSuicidalIdeation(boolean suicidalIdeation) {
        this.suicidalIdeation = suicidalIdeation;
    }
    public boolean isSuicidePlan() {
        return suicidePlan;
    }
    public void setSuicidePlan(boolean suicidePlan) {
        this.suicidePlan = suicidePlan;
    }
    public boolean isSuicideIntent() {
        return suicideIntent;
    }
    public void setSuicideIntent(boolean suicideIntent) {
        this.suicideIntent = suicideIntent;
    }
    public boolean isSelfHarm() {
        return selfHarm;
    }
    public void setSelfHarm(boolean selfHarm) {
        this.selfHarm = selfHarm;
    }
    public boolean isHarmToOthers() {
        return harmToOthers;
    }
    public void setHarmToOthers(boolean harmToOthers) {
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
    public String getClinicalActions() {
        return clinicalActions;
    }
    public void setClinicalActions(String clinicalActions) {
        this.clinicalActions = clinicalActions;
    }
    public String getObservations() {
        return observations;
    }
    public void setObservations(String observations) {
        this.observations = observations;
    }
    public java.time.LocalDateTime getAssessedAt() {
        return assessedAt;
    }
    public void setAssessedAt(java.time.LocalDateTime assessedAt) {
        this.assessedAt = assessedAt;
    }
    public UUID getAssessedBy() {
        return assessedBy;
    }
    public void setAssessedBy(UUID assessedBy) {
        this.assessedBy = assessedBy;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RiskAssessmentJpaEntity that = (RiskAssessmentJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}