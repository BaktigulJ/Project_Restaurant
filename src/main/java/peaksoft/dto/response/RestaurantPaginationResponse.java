package peaksoft.dto.response;

import lombok.Builder;

import java.util.List;
@Builder
public record RestaurantPaginationResponse(
        int page,
        int size,
        List<AllRestResponse> responses
) {
}
