package peaksoft.validation.dateOfBirth;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthValidation, LocalDate> {


    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        int year = localDate.getYear();
        int currentDate = LocalDate.now().getYear();
        int age = currentDate - year;
        return age > 18 && age<45;
    }
}
