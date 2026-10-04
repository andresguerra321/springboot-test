package com.backintro.domain.riskassessment.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.riskassessment.event.RiskAssessmentRegisteredEvent;
import com.backintro.domain.riskassessment.event.RiskAssessmentUpdatedEvent;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public class RiskAssessment extends AggregateRoot {
    private final RiskAssessmentId id;
    private UUID encounterId;
    private UUID riskLevelId;
    private Boolean suicidalIdeation;
    private Boolean suicidePlan;
    private Boolean suicideIntent;
    private Boolean selfHarm;
    private Boolean harmToOthers;
    private String protectiveFactors;
    private String riskFactors;
    private String clinicalActions;
    private String observations;
    private java.time.LocalDateTime assessedAt;
    private UUID assessedBy;

    private RiskAssessment(
        RiskAssessmentId id,
        UUID encounterId,
        UUID riskLevelId,
        Boolean suicidalIdeation,
        Boolean suicidePlan,
        Boolean suicideIntent,
        Boolean selfHarm,
        Boolean harmToOthers,
        String protectiveFactors,
        String riskFactors,
        String clinicalActions,
        String observations,
        java.time.LocalDateTime assessedAt,
        UUID assessedBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.riskLevelId = Objects.requireNonNull(riskLevelId, "riskLevelId must not be null");
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.protectiveFactors = protectiveFactors;
        this.riskFactors = riskFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = assessedBy;
    }

    public static RiskAssessment register(
        UUID encounterId,
        UUID riskLevelId,
        Boolean suicidalIdeation,
        Boolean suicidePlan,
        Boolean suicideIntent,
        Boolean selfHarm,
        Boolean harmToOthers,
        String protectiveFactors,
        String riskFactors,
        String clinicalActions,
        String observations,
        java.time.LocalDateTime assessedAt,
        UUID assessedBy) {

        RiskAssessmentId id = RiskAssessmentId.generate();

        RiskAssessment entity = new RiskAssessment(
            id,
            encounterId,
            riskLevelId,
            suicidalIdeation,
            suicidePlan,
            suicideIntent,
            selfHarm,
            harmToOthers,
            protectiveFactors,
            riskFactors,
            clinicalActions,
            observations,
            assessedAt,
            assessedBy);

        entity.recordEvent(
            new RiskAssessmentRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static RiskAssessment restore(
        RiskAssessmentId id,
        UUID encounterId,
        UUID riskLevelId,
        Boolean suicidalIdeation,
        Boolean suicidePlan,
        Boolean suicideIntent,
        Boolean selfHarm,
        Boolean harmToOthers,
        String protectiveFactors,
        String riskFactors,
        String clinicalActions,
        String observations,
        java.time.LocalDateTime assessedAt,
        UUID assessedBy) {
        return new RiskAssessment(
            id,
            encounterId,
            riskLevelId,
            suicidalIdeation,
            suicidePlan,
            suicideIntent,
            selfHarm,
            harmToOthers,
            protectiveFactors,
            riskFactors,
            clinicalActions,
            observations,
            assessedAt,
            assessedBy);
    }

    public void update(
        UUID encounterId,
        UUID riskLevelId,
        Boolean suicidalIdeation,
        Boolean suicidePlan,
        Boolean suicideIntent,
        Boolean selfHarm,
        Boolean harmToOthers,
        String protectiveFactors,
        String riskFactors,
        String clinicalActions,
        String observations,
        java.time.LocalDateTime assessedAt,
        UUID assessedBy) {

        this.encounterId = Objects.requireNonNull(encounterId);
        this.riskLevelId = Objects.requireNonNull(riskLevelId);
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.protectiveFactors = protectiveFactors;
        this.riskFactors = riskFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = assessedBy;

        recordEvent(
            new RiskAssessmentUpdatedEvent(
                this.id,
                this.encounterId,
                this.riskLevelId,
                this.suicidalIdeation,
                this.suicidePlan,
                this.suicideIntent,
                this.selfHarm,
                this.harmToOthers,
                this.protectiveFactors,
                this.riskFactors,
                this.clinicalActions,
                this.observations,
                this.assessedAt,
                this.assessedBy,
                LocalDateTime.now()));
    }

    public RiskAssessmentId id() {
        return id;
    }

    public UUID encounterId() {
        return encounterId;
    }
    public UUID riskLevelId() {
        return riskLevelId;
    }
    public Boolean suicidalIdeation() {
        return suicidalIdeation;
    }
    public Boolean suicidePlan() {
        return suicidePlan;
    }
    public Boolean suicideIntent() {
        return suicideIntent;
    }
    public Boolean selfHarm() {
        return selfHarm;
    }
    public Boolean harmToOthers() {
        return harmToOthers;
    }
    public String protectiveFactors() {
        return protectiveFactors;
    }
    public String riskFactors() {
        return riskFactors;
    }
    public String clinicalActions() {
        return clinicalActions;
    }
    public String observations() {
        return observations;
    }
    public java.time.LocalDateTime assessedAt() {
        return assessedAt;
    }
    public UUID assessedBy() {
        return assessedBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public RiskAssessmentId getId() {
        return id();
    }

    public UUID getEncounterId() {
        return encounterId();
    }
    public UUID getRiskLevelId() {
        return riskLevelId();
    }
    public Boolean isSuicidalIdeation() {
        return suicidalIdeation();
    }
    public Boolean isSuicidePlan() {
        return suicidePlan();
    }
    public Boolean isSuicideIntent() {
        return suicideIntent();
    }
    public Boolean isSelfHarm() {
        return selfHarm();
    }
    public Boolean isHarmToOthers() {
        return harmToOthers();
    }
    public String getProtectiveFactors() {
        return protectiveFactors();
    }
    public String getRiskFactors() {
        return riskFactors();
    }
    public String getClinicalActions() {
        return clinicalActions();
    }
    public String getObservations() {
        return observations();
    }
    public java.time.LocalDateTime getAssessedAt() {
        return assessedAt();
    }
    public UUID getAssessedBy() {
        return assessedBy();
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

    @Override
    public String toString() {
        return "RiskAssessment{" +
                "id=" + id +
                '}';
    }
}