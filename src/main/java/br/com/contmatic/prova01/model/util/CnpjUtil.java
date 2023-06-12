package br.com.contmatic.prova01.model.util;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarCaracteresRepetidos;

/**
 * The Class CnpjUtil.
 */
public final class CnpjUtil {

    /** The Constant VALOR_PADRAO. */
    private static final int VALOR_PADRAO = 0;

    /** The Constant RESULTADO_MINIMO. */
    private static final int RESULTADO_MINIMO = 1;

    /** The Constant TAMANHO_LIMITE_PESO. */
    private static final int TAMANHO_LIMITE_PESO = 10;

    /** The Constant VALOR_INICIAL_SOMA. */
    private static final int VALOR_INICIAL_SOMA = 0;

    /** The Constant VALOR_INICIAL_PESO. */
    private static final int VALOR_INICIAL_PESO = 2;

    /** The Constant POSICAO_DE_0_TABELA_ASCII. */
    private static final int POSICAO_DE_0_TABELA_ASCII = 48;

    /** The Constant POSICAO_13O_DIGITO. */
    private static final int POSICAO_13O_DIGITO = 12;

    /** The Constant POSICAO_12O_DIGITO. */
    private static final int POSICAO_12O_DIGITO = 11;

    /** The Constant QUANTIDADE_DE_NUMEROS_ANTES_PRIMEIRO_DIGITO. */
    private static final int QUANTIDADE_DE_NUMEROS_ANTES_PRIMEIRO_DIGITO = 11;

    /** The Constant POSICAO_PRIMEIRO_DIGITO_VERIFICADOR. */
    private static final int POSICAO_PRIMEIRO_DIGITO_VERIFICADOR = 12;

    /** The Constant POSICAO_SEGUNDO_DIGITO_VERIFICADOR. */
    private static final int POSICAO_SEGUNDO_DIGITO_VERIFICADOR = 13;

    /** The Constant MENSAGEM_ERRO_NUMEROS_IGUAIS_CNPJ. */
    private static final String MENSAGEM_ERRO_NUMEROS_IGUAIS_CNPJ = "Números repetidos no campo CNPJ é inválido.";

    /** The Constant MENSAGEM_ERRO_CNPJ. */
    private static final String MENSAGEM_ERRO_CNPJ = "CNPJ inválido";

    /**
     * Instantiates a new cnpj util.
     */
    private CnpjUtil() {
    }

    /**
     * Is cnpj.
     *
     * @param cnpj the cnpj
     */
    public static void isCnpj(String cnpj) {
        verificarCaracteresRepetidos(cnpj, MENSAGEM_ERRO_NUMEROS_IGUAIS_CNPJ);
        validarDigitos(cnpj);
    }

    /**
     * Calcular digito veridicador.
     *
     * @param cnpj the cnpj
     * @param peso the peso
     * @param posicaoDigito the posicao digito
     * @return the char
     */
    private static char calcularDigitoVeridicador(String cnpj, int peso, int posicaoDigito) {
        int soma = obterValorSoma(cnpj, peso, posicaoDigito);
        int resultado = obterResultado(soma);
        return (char) ((POSICAO_12O_DIGITO - resultado) + POSICAO_DE_0_TABELA_ASCII);
    }

    /**
     * Obter resultado.
     *
     * @param soma the soma
     * @return the int
     */
    private static int obterResultado(int soma) {
        int resultado = soma % QUANTIDADE_DE_NUMEROS_ANTES_PRIMEIRO_DIGITO;
        return resultado <= RESULTADO_MINIMO ? VALOR_PADRAO : resultado;
    }

    /**
     * Obter valor soma.
     *
     * @param cnpj the cnpj
     * @param peso the peso
     * @param posicaoDigito the posicao digito
     * @return the int
     */
    private static int obterValorSoma(String cnpj, int peso, int posicaoDigito) {
        int soma = VALOR_INICIAL_SOMA;
        for(int indice = posicaoDigito ; indice >= 0 ; indice--) {
            int numero = (cnpj.charAt(indice) - POSICAO_DE_0_TABELA_ASCII);
            soma += (numero * peso);
            peso++;
            if (peso == TAMANHO_LIMITE_PESO) {
                peso = VALOR_INICIAL_PESO;
            }
        }
        return soma;
    }

    /**
     * Verifica cnpj valido.
     *
     * @param cnpj the cnpj
     * @param digito1 the digito 1
     * @param digito2 the digito 2
     */
    private static void verificaCnpjValido(String cnpj, char digito1, char digito2) {
        if (cnpj.charAt(POSICAO_PRIMEIRO_DIGITO_VERIFICADOR) != digito1 || cnpj.charAt(POSICAO_SEGUNDO_DIGITO_VERIFICADOR) != digito2) {
            throw new IllegalArgumentException(MENSAGEM_ERRO_CNPJ);
        }
    }

    /**
     * Validar digitos.
     *
     * @param cnpj the cnpj
     */
    private static void validarDigitos(String cnpj) {
        char digito1 = calcularDigitoVeridicador(cnpj, VALOR_INICIAL_PESO, POSICAO_12O_DIGITO);
        char digito2 = calcularDigitoVeridicador(cnpj, VALOR_INICIAL_PESO, POSICAO_13O_DIGITO);
        verificaCnpjValido(cnpj, digito1, digito2);
    }
}
