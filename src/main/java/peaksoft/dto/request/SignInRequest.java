package peaksoft.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Builder

public class SignInRequest {
       private String email;
       private String password;

    public SignInRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
