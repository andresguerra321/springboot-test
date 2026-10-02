package com.backintro.infrastructure.country.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCountryRequest(
        String code,

        @NotBlank(message = "name is required")
        String name,

        String description,

        String telephonePrefix
) {}