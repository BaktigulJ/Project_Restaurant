package peaksoft.validation.experience;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import peaksoft.validation.email.EmailValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExperienceValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExperienceValidation {
    String message() default "{Cannot be zero or negative number}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
