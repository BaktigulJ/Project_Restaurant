package peaksoft.validation.experience;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExperienceValidator implements ConstraintValidator<ExperienceValidation,Integer> {
    @Override
    public boolean isValid(Integer experience, ConstraintValidatorContext context) {
        return experience>0;
    }
}
