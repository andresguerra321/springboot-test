package com.backintro.infrastructure.gender.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateGenderRequest(

        @NotBlank(message = "description is required")
        String description

) {
}