package br.com.contmatic.prova01.model.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * The Interface FullAge.
 */
/**
 * @author guilherme.martins
 *
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = FullAgeValidator.class)
public @interface FullAge {

    /**
     * Message.
     *
     * @return the string
     */
    String message() default "A data inserida se refere a uma pessoa menor de idade.";

    /**
     * Groups.
     *
     * @return the class[]
     */
    Class<?>[] groups() default { };

    /**
     * Payload.
     *
     * @return the class<? extends payload>[]
     */
    Class<? extends Payload>[] payload() default { };
}
