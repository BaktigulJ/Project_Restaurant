package peaksoft.dto.request;

import jakarta.validation.constraints.NotNull;
import peaksoft.enums.RestType;
import peaksoft.validation.experience.ExperienceValidation;

public record EditRestaurantRequest(
        String name,
        String location,
        RestType restType,
        @ExperienceValidation
        @NotNull
        Integer service
) {
}
