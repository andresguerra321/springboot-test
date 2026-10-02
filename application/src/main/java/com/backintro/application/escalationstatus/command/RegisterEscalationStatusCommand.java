package com.backintro.application.escalationstatus.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterEscalationStatusCommand(
        String nameStatus
) {
    public RegisterEscalationStatusCommand {
        Objects.requireNonNull(nameStatus, "nameStatus must not be null");
    }
}