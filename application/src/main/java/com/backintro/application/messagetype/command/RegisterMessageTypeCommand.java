package com.backintro.application.messagetype.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterMessageTypeCommand(
        String nameType
) {
    public RegisterMessageTypeCommand {
        Objects.requireNonNull(nameType, "nameType must not be null");
    }
}