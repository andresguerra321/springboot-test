package com.backintro.application.sendertype.command;

import java.util.Objects;
import java.util.UUID;

public record RegisterSenderTypeCommand(
        String nameType
) {
    public RegisterSenderTypeCommand {
        Objects.requireNonNull(nameType, "nameType must not be null");
    }
}