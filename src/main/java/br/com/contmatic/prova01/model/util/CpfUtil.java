package br.com.contmatic.prova01.model.util;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarCaracteresRepetidos;

/**
 * The Class CpfUtil.
 *
 * @author guilherme.martins
 */
public final class CpfUtil {

    /** The Constant VALOR_PADRAO. */
    private static final int VALOR_PADRAO = 0;

    /** The Constant QUANTIDADE_NUMEROS_SEM_DIGITOS. */
    private static final int QUANTIDADE_NUMEROS_SEM_DIGITOS = 9;

    /** The Constant QUANTIDADE_NUMEROS_CPF. */
    private static final int QUANTIDADE_NUMEROS_CPF = 11;

    /** The Constant ERROR_MESSAGE_NUMEROS_IGUAIS_CPF. */
    private static final String ERROR_MESSAGE_NUMEROS_IGUAIS_CPF = "Números repetidos no campo CPF é inválidos.";

    /** The Constant POSICAO_SEGUNDO_DIGITO. */
    private static final int POSICAO_SEGUNDO_DIGITO = 10;

    /** The Constant POSICAO_PRIMEIRO_DIGITO. */
    private static final int POSICAO_PRIMEIRO_DIGITO = 9;

    /** The Constant ERROR_MESSAGE_CPF. */
    private static final String ERROR_MESSAGE_CPF = "Cpf inválido.";

    /** The Constant VALOR_INICIAL_PESO_PRIMEIRO_DIGITO. */
    private static final int VALOR_INICIAL_PESO_PRIMEIRO_DIGITO = 10;

    /** The Constant VALOR_INICIAL_PESO_SEGUNDO_DIGITO. */
    private static final int VALOR_INICIAL_PESO_SEGUNDO_DIGITO = 11;

    /** The Constant POSICAO_DE_0_TABELA_ASCII. */
    private static final int POSICAO_DE_0_TABELA_ASCII = 48;

    /** The Constant VALOR_INICIAL_DA_SOMA. */
    private static final int VALOR_INICIAL_DA_SOMA = 0;

    /**
     * Instantiates a new cpf util.
     */
    private CpfUtil() {
    }

    /**
     * Is cpf.
     *
     * @param cpf the cpf
     */
    public static void isCpf(String cpf) {
        verificarCaracteresRepetidos(cpf, ERROR_MESSAGE_NUMEROS_IGUAIS_CPF);
        validarDigitos(cpf);
    }

    /**
     * Calcular digito verificador.
     *
     * @param cpf the cpf
     * @param peso the peso
     * @param posicaoDigito the posicao digito
     * @return the char
     */
    private static char calcularDigitoVerificador(String cpf, int peso, int posicaoDigito) {
        int soma = obterValorSoma(cpf, peso, posicaoDigito);
        int resultado = obterResultado(soma);
        return (char) (resultado + POSICAO_DE_0_TABELA_ASCII);
    }

    /**
     * Obter resultado.
     *
     * @param soma the soma
     * @return the int
     */
    private static int obterResultado(int soma) {
        int resultado = QUANTIDADE_NUMEROS_CPF - (soma % QUANTIDADE_NUMEROS_CPF);
        return resultado > QUANTIDADE_NUMEROS_SEM_DIGITOS ? VALOR_PADRAO : resultado;
    }

    /**
     * Obter valor soma.
     *
     * @param cpf the cpf
     * @param peso the peso
     * @param posicaoDigito the posicao digito
     * @return the int
     */
    private static int obterValorSoma(String cpf, int peso, int posicaoDigito) {
        int soma = VALOR_INICIAL_DA_SOMA;
        for(int indice = 0 ; indice < posicaoDigito ; indice++) {
            int numero = (cpf.charAt(indice) - POSICAO_DE_0_TABELA_ASCII);
            soma += (numero * peso);
            peso--;
        }
        return soma;
    }

    /**
     * Verificar cpf valido.
     *
     * @param cpf the cpf
     * @param digito1 the digito 1
     * @param digito2 the digito 2
     */
    private static void verificarCpfValido(String cpf, char digito1, char digito2) {
        if (cpf.charAt(POSICAO_PRIMEIRO_DIGITO) != digito1 || cpf.charAt(POSICAO_SEGUNDO_DIGITO) != digito2) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CPF);
        }
    }

    /**
     * Validar digitos.
     *
     * @param cpf the cpf
     */
    private static void validarDigitos(String cpf) {
        char digito1 = calcularDigitoVerificador(cpf, VALOR_INICIAL_PESO_PRIMEIRO_DIGITO, POSICAO_PRIMEIRO_DIGITO);
        char digito2 = calcularDigitoVerificador(cpf, VALOR_INICIAL_PESO_SEGUNDO_DIGITO, POSICAO_SEGUNDO_DIGITO);
        verificarCpfValido(cpf, digito1, digito2);
    }
}
