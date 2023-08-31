package br.com.contmatic.prova01.model.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * The Interface Present.
 *
 * @author guilherme.martins
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PresentValidator.class)
public @interface Present {

    /**
     * Message.
     *
     * @return the string
     */
    String message() default "Data inválida.";

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
