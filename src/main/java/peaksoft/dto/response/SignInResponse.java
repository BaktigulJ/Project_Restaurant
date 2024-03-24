package peaksoft.dto.response;

import lombok.*;
import peaksoft.enums.Role;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class SignInResponse {
    private String token;
    private Long id;
    private Role role;
    private String email;

    public SignInResponse(Long id, Role role, String email) {
        this.id = id;
        this.role = role;
        this.email = email;
    }
}
