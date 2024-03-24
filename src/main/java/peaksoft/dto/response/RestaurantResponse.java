package peaksoft.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class RestaurantResponse {
    private String name;
    private String location;
    private String restType;

    public RestaurantResponse(String name, String location, String restType) {
        this.name = name;
        this.location = location;
        this.restType = restType;
    }
}
