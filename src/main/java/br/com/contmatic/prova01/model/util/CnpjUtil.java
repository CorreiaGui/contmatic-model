package br.com.contmatic.prova01.model.util;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarCaracteresRepetidos;

public final class CnpjUtil {

	private static final int VALOR_INICIAL_SOMA = 0;
	private static final int VALOR_INICIAL_PESO = 2;
	private static final int POSICAO_DE_0_TABELA_ASCII = 48;
	private static final int POSICAO_13O_DIGITO = 12;
	private static final int POSICAO_12O_DIGITO = 11;
	private static final int POSICAO_PRIMEIRO_DIGITO_VERIFICADOR = 12;
	private static final int POSICAO_SEGUNDO_DIGITO_VERIFICADOR = 13;
	private static final String MENSAGEM_ERRO_NUMEROS_IGUAIS_CNPJ = "Números repetidos no campo CNPJ é inválido.";
	private static final String MENSAGEM_ERRO_CNPJ = "CNPJ inválido";

	private CnpjUtil() {
	}

	public static void isCnpj(String cnpj) {
		verificarCaracteresRepetidos(cnpj, MENSAGEM_ERRO_NUMEROS_IGUAIS_CNPJ);
		validarDigitos(cnpj);
	}

	private static char calcularDigitoVeridicador(String cnpj, int peso, int posicaoDigito) {
		int soma = obterValorSoma(cnpj, peso, posicaoDigito);
		int resultado = obterResultado(soma);
		return (char) ((POSICAO_12O_DIGITO - resultado) + POSICAO_DE_0_TABELA_ASCII);
	}

	private static int obterResultado(int soma) {
		int resultado = soma % 11; 
		if (resultado <= 1) {
			return 0;
		}
		return resultado;
	}

	private static int obterValorSoma(String cnpj, int peso, int posicaoDigito) {
		int soma = VALOR_INICIAL_SOMA;
		for (int indice = posicaoDigito; indice >= 0; indice--) {
			int numero = (cnpj.charAt(indice) - POSICAO_DE_0_TABELA_ASCII);
			soma += (numero * peso);
			peso++;
			if (peso == 10) {
				peso = VALOR_INICIAL_PESO;
			}
		}
		return soma;
	}

	private static void verificaCnpjValido(String cnpj, char digito1, char digito2) {
		if (cnpj.charAt(POSICAO_PRIMEIRO_DIGITO_VERIFICADOR) != digito1
				|| cnpj.charAt(POSICAO_SEGUNDO_DIGITO_VERIFICADOR) != digito2) {
			throw new IllegalArgumentException(MENSAGEM_ERRO_CNPJ);
		}
	}

	private static void validarDigitos(String cnpj) {
		char digito1 = calcularDigitoVeridicador(cnpj, VALOR_INICIAL_PESO, POSICAO_12O_DIGITO);
		char digito2 = calcularDigitoVeridicador(cnpj, VALOR_INICIAL_PESO, POSICAO_13O_DIGITO);
		verificaCnpjValido(cnpj, digito1, digito2);
	}

}