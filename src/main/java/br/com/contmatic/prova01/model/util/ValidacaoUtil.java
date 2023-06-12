package br.com.contmatic.prova01.model.util;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.time.ZonedDateTime.now;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * The Class ValidacaoUtil.
 */
/**
 * @author guilherme.martins
 *
 */
public final class ValidacaoUtil {

    /**
     * Instantiates a new validacao util.
     */
    private ValidacaoUtil() {
    }

    /** The Constant MARGEM_ERRO_DATA. */
    private static final long MARGEM_ERRO_DATA = 1L;

    /** The Constant IDADE_MINIMA. */
    private static final int IDADE_MINIMA = 18;

    /** The Constant DATA_MINIMA. */
    private static final LocalDate DATA_MINIMA = new LocalDate(1600, 1, 1);

    /** The Constant DATA_LIMITE. */
    private static final LocalDate DATA_LIMITE = LocalDate.now();
    
    /**
     * Verificar valor minimo.
     *
     * @param valor the valor
     * @param valorMinimo the valor minimo
     * @param errorMessage the error message
     */
    public static void verificarValorMinimo(BigDecimal valor, BigDecimal valorMinimo, String errorMessage) {
        checkArgument(valor.compareTo(valorMinimo) > 0, errorMessage);
    }

    /**
     * Verificar valor maximo.
     *
     * @param valor the valor
     * @param valorMaximo the valor maximo
     * @param errorMessage the error message
     */
    public static void verificarValorMaximo(BigDecimal valor, BigDecimal valorMaximo, String errorMessage) {
        checkArgument(valor.compareTo(valorMaximo) < 0, errorMessage);
    }

    /**
     * Verificar valor minimo.
     *
     * @param valor the valor
     * @param valorMinimo the valor minimo
     * @param errorMessage the error message
     */
    public static void verificarValorMinimo(Integer valor, Integer valorMinimo, String errorMessage) {
        checkArgument(valor >= valorMinimo, errorMessage);
    }

    /**
     * Verificar valor maximo.
     *
     * @param valor the valor
     * @param valorMaximo the valor maximo
     * @param errorMessage the error message
     */
    public static void verificarValorMaximo(Integer valor, Integer valorMaximo, String errorMessage) {
        checkArgument(valor <= valorMaximo, errorMessage);
    }

    /**
     * Verificar valor nulo.
     *
     * @param object the object
     * @param errorMessage the error message
     */
    public static void verificarValorNulo(Object object, String errorMessage) {
        checkNotNull(object, errorMessage);
    }

    /**
     * Verificar tamanho.
     *
     * @param parametro the parametro
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanho(String parametro, int tamanho, String errorMessage) {
        checkArgument(parametro.length() == tamanho, errorMessage);
    }

    /**
     * Verificar tamanho maximo.
     *
     * @param parametro the parametro
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanhoMaximo(String parametro, int tamanho, String errorMessage) {
        checkArgument(parametro.length() <= tamanho, errorMessage);
    }

    /**
     * Verificar tamanho minimo.
     *
     * @param parametro the parametro
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanhoMinimo(String parametro, int tamanho, String errorMessage) {
        /*
         * if (parametro.length() < tamanho) { throw new IllegalArgumentException(errorMessage); }
         */
        checkArgument(parametro.length() >= tamanho, errorMessage);
    }

    /**
     * Verificar vazio.
     *
     * @param string the string
     * @param errorMessage the error message
     */
    public static void verificarVazio(String string, String errorMessage) {
        checkArgument(!string.trim().isEmpty(), errorMessage);
    }

    /**
     * Verificar tamanho maximo.
     *
     * @param collection the collection
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanhoMaximo(Set<?> collection, int tamanho, String errorMessage) {
        checkArgument(collection.size() <= tamanho, errorMessage);
    }

    /**
     * Verificar tamanho maximo.
     *
     * @param collection the collection
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanhoMaximo(List<?> collection, int tamanho, String errorMessage) {
        checkArgument(collection.size() <= tamanho, errorMessage);
    }

    /**
     * Verificar tamanho minimo.
     *
     * @param collection the collection
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanhoMinimo(Set<?> collection, int tamanho, String errorMessage) {
        checkArgument(collection.size() >= tamanho, errorMessage);
    }

    /**
     * Verificar tamanho minimo.
     *
     * @param collection the collection
     * @param tamanho the tamanho
     * @param errorMessage the error message
     */
    public static void verificarTamanhoMinimo(List<?> collection, int tamanho, String errorMessage) {
        checkArgument(collection.size() >= tamanho, errorMessage);
    }

    /**
     * Verificar vazio.
     *
     * @param collection the collection
     * @param errorMessage the error message
     */
    public static void verificarVazio(Set<?> collection, String errorMessage) {
        checkArgument(!collection.isEmpty(), errorMessage);
    }

    /**
     * Verificar vazio.
     *
     * @param collection the collection
     * @param errorMessage the error message
     */
    public static void verificarVazio(List<?> collection, String errorMessage) {
        checkArgument(!collection.isEmpty(), errorMessage);
    }

    /**
     * Verificar data minima.
     *
     * @param data the data
     * @param errorMessage the error message
     */
    public static void verificarDataMinima(LocalDate data, String errorMessage) {
        checkArgument(!data.isBefore(DATA_MINIMA), errorMessage);
    }

    /**
     * Verificar data limite.
     *
     * @param data the data
     * @param errorMessage the error message
     */
    public static void verificarDataLimite(LocalDate data, String errorMessage) {
        checkArgument(!data.isAfter(DATA_LIMITE), errorMessage);
    }

    /**
     * Verificar maior idade.
     *
     * @param dataNascimento the data nascimento
     * @param errorMessage the error message
     */
    public static void verificarMaiorIdade(LocalDate dataNascimento, String errorMessage) {
        Years idade = Years.yearsBetween(dataNascimento, DATA_LIMITE);
        checkArgument(idade.getYears() >= IDADE_MINIMA, errorMessage);
    }

    /**
     * Verificar data minima.
     *
     * @param data the data
     * @param errorMessage the error message
     */
    public static void verificarDataMinima(ZonedDateTime data, String errorMessage) {
        checkArgument(!data.isBefore(now().minusMinutes(MARGEM_ERRO_DATA)), errorMessage);
    }

    /**
     * Verificar data maxima.
     *
     * @param data the data
     * @param errorMessage the error message
     */
    public static void verificarDataMaxima(ZonedDateTime data, String errorMessage) {
        checkArgument(!data.isAfter(now().plusMinutes(MARGEM_ERRO_DATA)), errorMessage);
    }

    /**
     * Verificar regex.
     *
     * @param parametro the parametro
     * @param regex the regex
     * @param errorMessage the error message
     */
    public static void verificarRegex(String parametro, String regex, String errorMessage) {
        checkArgument(parametro.matches(regex), errorMessage);
    }

    /**
     * Verificar caracteres repetidos.
     *
     * @param parametro the parametro
     * @param errorMessage the error message
     */
    public static void verificarCaracteresRepetidos(String parametro, String errorMessage) {
        char primeiroChar = parametro.charAt(0);
        for(int indice = 0 ; indice < parametro.length() ; indice++) {
            char charAtual = parametro.charAt(indice);
            if (charAtual != primeiroChar) {
                return;
            }
        }
        throw new IllegalArgumentException(errorMessage);
    }
}
