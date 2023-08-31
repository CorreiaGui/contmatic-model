package br.com.contmatic.prova01.model.annotation;

import static java.time.ZonedDateTime.now;

import java.time.ZonedDateTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * The Class PresentValidator.
 *
 * @author guilherme.martins
 */
public class PresentValidator implements ConstraintValidator<Present, ZonedDateTime> {

    /**
     * Checks if is valid.
     *
     * @param value the value
     * @param context the context
     * @return true, if is valid
     */
    @Override
    public boolean isValid(ZonedDateTime value, ConstraintValidatorContext context) {
        return value == null 
                || !(value.isBefore(now().minusMinutes(1L)) 
                || value.isAfter(now().plusMinutes(1L)));
    }
}
