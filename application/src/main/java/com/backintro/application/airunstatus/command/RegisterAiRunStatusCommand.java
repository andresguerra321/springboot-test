package com.backintro.application.airunstatus.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterAiRunStatusCommand(
        String nameStatus
) {
    public RegisterAiRunStatusCommand {
        Objects.requireNonNull(nameStatus, "nameStatus must not be null");
    }
}