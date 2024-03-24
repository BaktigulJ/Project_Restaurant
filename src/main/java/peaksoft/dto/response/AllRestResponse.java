package peaksoft.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import peaksoft.enums.RestType;

@Builder
public record AllRestResponse(
        Long id,
        String name,
        String location,
        @Enumerated(EnumType.STRING)
        RestType restType,
        int numberOfEmployees,
        int service
) {
}
