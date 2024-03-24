package peaksoft.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import peaksoft.enums.RestType;
import peaksoft.validation.dateOfBirth.DateOfBirthValidation;
import peaksoft.validation.email.EmailValidation;
import peaksoft.validation.experience.ExperienceValidation;
import peaksoft.validation.password.PasswordValidation;
import peaksoft.validation.phoneNumber.PhoneNumberValidation;

import java.time.LocalDate;

public record SaveRestaurantRequest(
        @NotBlank(message = "the name must be unique")
        String name,
        @NotBlank(message = "the location should not be empty")
        String location,
        @Enumerated(EnumType.STRING)
        RestType restType,
        @ExperienceValidation
        int service,
        @NotBlank(message = "the last name should not be empty")
        String lastName,
        @NotBlank(message = "the first name should not be empty")
        String firstName,
        @DateOfBirthValidation
        LocalDate dateOfBirth,
        @Email @EmailValidation
        String email,
        @PasswordValidation
        String password,
        @PhoneNumberValidation
        String phoneNumber,
        @ExperienceValidation
        int experience) {
}
