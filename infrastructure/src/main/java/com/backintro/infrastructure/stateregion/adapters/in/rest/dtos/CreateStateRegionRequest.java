package com.backintro.infrastructure.stateregion.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateStateRegionRequest(
        String code,

        @NotBlank(message = "name is required")
        String name,

        String description,

        @jakarta.validation.constraints.NotNull(message = "countryId is required")
        UUID countryId
) {}