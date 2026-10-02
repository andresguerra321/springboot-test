package com.backintro.application.priority.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterPriorityCommand(
        String namePriority
) {
    public RegisterPriorityCommand {
        Objects.requireNonNull(namePriority, "namePriority must not be null");
    }
}