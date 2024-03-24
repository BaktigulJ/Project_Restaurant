package peaksoft.validation.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.endsWith("@gmail.com");
    }
}
