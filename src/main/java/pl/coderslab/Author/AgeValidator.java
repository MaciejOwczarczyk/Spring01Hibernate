package pl.coderslab.Author;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, Long> {

    @Override
    public void initialize(Age constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return (LocalDate.now().getYear() - value) > 18;
    }
}
