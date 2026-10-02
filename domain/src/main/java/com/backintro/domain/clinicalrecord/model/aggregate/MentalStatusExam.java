package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class MentalStatusExam {

    private UUID id;
    private UUID encounterId;
    private String appearance;
    private String behavior;
    private String attitude;
    private String consciousness;
    private String orientation;
    private String attention;
    private String memory;
    private String speech;
    private String thoughtProcess;
    private String thoughtContent;
    private String perception;
    private String affect;
    private String mood;
    private String insight;
    private String judgment;
    private Boolean suicidalIdeation;
    private Boolean homicidalIdeation;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MentalStatusExam() {
    }

    public MentalStatusExam(UUID id, UUID encounterId, String appearance, String behavior, String attitude,
                            String consciousness, String orientation, String attention, String memory, String speech,
                            String thoughtProcess, String thoughtContent, String perception, String affect,
                            String mood, String insight, String judgment, Boolean suicidalIdeation,
                            Boolean homicidalIdeation, String notes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.encounterId = encounterId;
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.affect = affect;
        this.mood = mood;
        this.insight = insight;
        this.judgment = judgment;
        this.suicidalIdeation = suicidalIdeation;
        this.homicidalIdeation = homicidalIdeation;
        this.notes = notes;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static MentalStatusExam create(UUID encounterId, String appearance, String behavior, String speech, String mood, String notes) {
        LocalDateTime now = LocalDateTime.now();
        return new MentalStatusExam(
                UUID.randomUUID(),
                encounterId,
                appearance,
                behavior,
                null,
                null,
                null,
                null,
                null,
                speech,
                null,
                null,
                null,
                null,
                mood,
                null,
                null,
                false,
                false,
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

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    public String getConsciousness() {
        return consciousness;
    }

    public void setConsciousness(String consciousness) {
        this.consciousness = consciousness;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public String getThoughtProcess() {
        return thoughtProcess;
    }

    public void setThoughtProcess(String thoughtProcess) {
        this.thoughtProcess = thoughtProcess;
    }

    public String getThoughtContent() {
        return thoughtContent;
    }

    public void setThoughtContent(String thoughtContent) {
        this.thoughtContent = thoughtContent;
    }

    public String getPerception() {
        return perception;
    }

    public void setPerception(String perception) {
        this.perception = perception;
    }

    public String getAffect() {
        return affect;
    }

    public void setAffect(String affect) {
        this.affect = affect;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getInsight() {
        return insight;
    }

    public void setInsight(String insight) {
        this.insight = insight;
    }

    public String getJudgment() {
        return judgment;
    }

    public void setJudgment(String judgment) {
        this.judgment = judgment;
    }

    public Boolean getSuicidalIdeation() {
        return suicidalIdeation;
    }

    public void setSuicidalIdeation(Boolean suicidalIdeation) {
        this.suicidalIdeation = suicidalIdeation;
    }

    public Boolean getHomicidalIdeation() {
        return homicidalIdeation;
    }

    public void setHomicidalIdeation(Boolean homicidalIdeation) {
        this.homicidalIdeation = homicidalIdeation;
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
        MentalStatusExam that = (MentalStatusExam) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
