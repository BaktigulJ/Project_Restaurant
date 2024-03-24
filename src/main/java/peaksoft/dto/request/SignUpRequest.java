package peaksoft.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import peaksoft.enums.Role;
import peaksoft.validation.phoneNumber.PhoneNumberValidation;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder

public class SignUpRequest {
    @NotBlank(message = "first name is blank")
    private String firstName;
    @NotBlank(message = "last name is blank")
    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    @Email
    private String email;
    private String password;
    private String passwordConfirm;
    @PhoneNumberValidation
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role;
    private int experience;
}
