package com.backintro.infrastructure.citymunicipality.adapters.in.rest.dtos;

import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCityMunicipalityRequest(
        String code,

        @NotBlank(message = "name is required")
        String name,

        String description,

        @jakarta.validation.constraints.NotNull(message = "regionId is required")
        UUID regionId
) {}