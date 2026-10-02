package com.backintro.infrastructure.treatmentstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTreatmentStatusRequest(

        @NotBlank(message = "code is required")
        @Size(min = 1, max = 20, message = "code must have between 1 and 20 characters")
        String code,

        @NotBlank(message = "name is required")
        String name,

        String description

) {
}