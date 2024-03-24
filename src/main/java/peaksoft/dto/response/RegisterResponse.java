package peaksoft.dto.response;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class RegisterResponse {
     private String token;
     private SimpleResponse simpleResponse;
}
