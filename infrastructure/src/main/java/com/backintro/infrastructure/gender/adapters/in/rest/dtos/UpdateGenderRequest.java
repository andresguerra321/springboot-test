package com.backintro.infrastructure.gender.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateGenderRequest(

        @NotBlank(message = "description is required")
        String description

) {
}