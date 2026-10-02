package com.backintro.domain.mentalstatusexam.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.mentalstatusexam.event.MentalStatusExamRegisteredEvent;
import com.backintro.domain.mentalstatusexam.event.MentalStatusExamUpdatedEvent;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

public class MentalStatusExam extends AggregateRoot {
    private final MentalStatusExamId id;
    private UUID encounterId;
    private String appearance;
    private String behavior;
    private String attitude;
    private String consciousness;
    private String orientation;
    private String attention;
    private String memory;
    private String speech;
    private String mood;
    private String affect;
    private String thoughtProcess;
    private String thoughtContent;
    private String perception;
    private String judgment;
    private String insight;
    private String psychomotorActivity;
    private String observations;
    private UUID createdBy;

    private MentalStatusExam(
        MentalStatusExamId id,
        UUID encounterId,
        String appearance,
        String behavior,
        String attitude,
        String consciousness,
        String orientation,
        String attention,
        String memory,
        String speech,
        String mood,
        String affect,
        String thoughtProcess,
        String thoughtContent,
        String perception,
        String judgment,
        String insight,
        String psychomotorActivity,
        String observations,
        UUID createdBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        this.createdBy = createdBy;
    }

    public static MentalStatusExam register(
        UUID encounterId,
        String appearance,
        String behavior,
        String attitude,
        String consciousness,
        String orientation,
        String attention,
        String memory,
        String speech,
        String mood,
        String affect,
        String thoughtProcess,
        String thoughtContent,
        String perception,
        String judgment,
        String insight,
        String psychomotorActivity,
        String observations,
        UUID createdBy) {

        MentalStatusExamId id = MentalStatusExamId.generate();

        MentalStatusExam entity = new MentalStatusExam(
            id,
            encounterId,
            appearance,
            behavior,
            attitude,
            consciousness,
            orientation,
            attention,
            memory,
            speech,
            mood,
            affect,
            thoughtProcess,
            thoughtContent,
            perception,
            judgment,
            insight,
            psychomotorActivity,
            observations,
            createdBy);

        entity.recordEvent(
            new MentalStatusExamRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static MentalStatusExam restore(
        MentalStatusExamId id,
        UUID encounterId,
        String appearance,
        String behavior,
        String attitude,
        String consciousness,
        String orientation,
        String attention,
        String memory,
        String speech,
        String mood,
        String affect,
        String thoughtProcess,
        String thoughtContent,
        String perception,
        String judgment,
        String insight,
        String psychomotorActivity,
        String observations,
        UUID createdBy) {
        return new MentalStatusExam(
            id,
            encounterId,
            appearance,
            behavior,
            attitude,
            consciousness,
            orientation,
            attention,
            memory,
            speech,
            mood,
            affect,
            thoughtProcess,
            thoughtContent,
            perception,
            judgment,
            insight,
            psychomotorActivity,
            observations,
            createdBy);
    }

    public void update(
        UUID encounterId,
        String appearance,
        String behavior,
        String attitude,
        String consciousness,
        String orientation,
        String attention,
        String memory,
        String speech,
        String mood,
        String affect,
        String thoughtProcess,
        String thoughtContent,
        String perception,
        String judgment,
        String insight,
        String psychomotorActivity,
        String observations,
        UUID createdBy) {

        this.encounterId = Objects.requireNonNull(encounterId);
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        this.createdBy = createdBy;

        recordEvent(
            new MentalStatusExamUpdatedEvent(
                this.id,
                this.encounterId,
                this.appearance,
                this.behavior,
                this.attitude,
                this.consciousness,
                this.orientation,
                this.attention,
                this.memory,
                this.speech,
                this.mood,
                this.affect,
                this.thoughtProcess,
                this.thoughtContent,
                this.perception,
                this.judgment,
                this.insight,
                this.psychomotorActivity,
                this.observations,
                this.createdBy,
                LocalDateTime.now()));
    }

    public MentalStatusExamId id() {
        return id;
    }

    public UUID encounterId() {
        return encounterId;
    }
    public String appearance() {
        return appearance;
    }
    public String behavior() {
        return behavior;
    }
    public String attitude() {
        return attitude;
    }
    public String consciousness() {
        return consciousness;
    }
    public String orientation() {
        return orientation;
    }
    public String attention() {
        return attention;
    }
    public String memory() {
        return memory;
    }
    public String speech() {
        return speech;
    }
    public String mood() {
        return mood;
    }
    public String affect() {
        return affect;
    }
    public String thoughtProcess() {
        return thoughtProcess;
    }
    public String thoughtContent() {
        return thoughtContent;
    }
    public String perception() {
        return perception;
    }
    public String judgment() {
        return judgment;
    }
    public String insight() {
        return insight;
    }
    public String psychomotorActivity() {
        return psychomotorActivity;
    }
    public String observations() {
        return observations;
    }
    public UUID createdBy() {
        return createdBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public MentalStatusExamId getId() {
        return id();
    }

    public UUID getEncounterId() {
        return encounterId();
    }
    public String getAppearance() {
        return appearance();
    }
    public String getBehavior() {
        return behavior();
    }
    public String getAttitude() {
        return attitude();
    }
    public String getConsciousness() {
        return consciousness();
    }
    public String getOrientation() {
        return orientation();
    }
    public String getAttention() {
        return attention();
    }
    public String getMemory() {
        return memory();
    }
    public String getSpeech() {
        return speech();
    }
    public String getMood() {
        return mood();
    }
    public String getAffect() {
        return affect();
    }
    public String getThoughtProcess() {
        return thoughtProcess();
    }
    public String getThoughtContent() {
        return thoughtContent();
    }
    public String getPerception() {
        return perception();
    }
    public String getJudgment() {
        return judgment();
    }
    public String getInsight() {
        return insight();
    }
    public String getPsychomotorActivity() {
        return psychomotorActivity();
    }
    public String getObservations() {
        return observations();
    }
    public UUID getCreatedBy() {
        return createdBy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MentalStatusExam that = (MentalStatusExam) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MentalStatusExam{" +
                "id=" + id +
                '}';
    }
}