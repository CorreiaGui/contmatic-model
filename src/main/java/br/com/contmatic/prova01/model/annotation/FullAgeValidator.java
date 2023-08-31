package br.com.contmatic.prova01.model.annotation;

import static org.joda.time.Years.yearsBetween;

import org.joda.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * The Class FullAgeValidator.
 *
 * @author guilherme.martins
 *
 */
public class FullAgeValidator implements ConstraintValidator<FullAge, LocalDate> {

    /** The Constant IDADE_MINIMA. */
    private static final int IDADE_MINIMA = 18;

    /** The Constant DATA_LIMITE. */
    private static final LocalDate DATA_LIMITE = LocalDate.now();

    /**
     * Checks if is valid.
     *
     * @param value the value
     * @param context the context
     * @return true, if is valid
     */
    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return value == null || yearsBetween(value, DATA_LIMITE).getYears() >= IDADE_MINIMA;
    }
}
