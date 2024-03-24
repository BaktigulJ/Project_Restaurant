package peaksoft.dto.request;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantRequest {
    private String name;
    private String location;
    private String restType;
    private String numberOfEmployees;
    private int service;

}
