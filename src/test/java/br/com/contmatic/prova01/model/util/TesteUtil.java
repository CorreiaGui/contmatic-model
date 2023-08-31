package br.com.contmatic.prova01.model.util;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

/**
 * The Class TesteUtil.
 *
 * @author guilherme.martins
 */
public class TesteUtil {

    /**
     * Gets the error message.
     *
     * @param <T> the generic type
     * @param obj the obj
     * @param erro the erro
     * @return the error message
     */
    public static <T> String getErrorMessage(T obj, String erro) {

        ValidatorFactory factory = buildDefaultValidatorFactory();

        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(obj);
        
        ConstraintViolation<T> errorMessage = violations.stream()
            .filter(parametro -> erro.equals(parametro.getMessage()))
            .findFirst() 
            .orElse(null); 
        
        return errorMessage != null ? errorMessage.getMessage() : null;
    }
}
