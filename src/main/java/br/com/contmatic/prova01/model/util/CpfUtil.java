package br.com.contmatic.prova01.model.util;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarCaracteresRepetidos;

public final class CpfUtil {

	private static final int VALOR_PADRAO = 0;
	private static final int QUANTIDADE_NUMEROS_SEM_DIGITOS = 9;
	private static final int QUANTIDADE_NUMEROS_CPF = 11;
	private static final String ERROR_MESSAGE_NUMEROS_IGUAIS_CPF = "Números repetidos no campo CPF é inválidos.";
	private static final int POSICAO_SEGUNDO_DIGITO = 10;
	private static final int POSICAO_PRIMEIRO_DIGITO = 9;
	private static final String ERROR_MESSAGE_CPF = "Cpf inválido.";
	private static final int VALOR_INICIAL_PESO_PRIMEIRO_DIGITO = 10;
	private static final int VALOR_INICIAL_PESO_SEGUNDO_DIGITO = 11;
	private static final int POSICAO_DE_0_TABELA_ASCII = 48;
	private static final int VALOR_INICIAL_DA_SOMA = 0;

	private CpfUtil() {
	}

	public static void isCpf(String cpf) {
		verificarCaracteresRepetidos(cpf, ERROR_MESSAGE_NUMEROS_IGUAIS_CPF);
		validarDigitos(cpf);
	}

	private static char calcularDigitoVerificador(String cpf, int peso, int posicaoDigito) {
		int soma = obterValorSoma(cpf, peso, posicaoDigito);
		int resultado = obterResultado(soma);
		return (char) (resultado + POSICAO_DE_0_TABELA_ASCII);
	}

	private static int obterResultado(int soma) {
		int resultado = QUANTIDADE_NUMEROS_CPF - (soma % QUANTIDADE_NUMEROS_CPF);
		if (resultado > QUANTIDADE_NUMEROS_SEM_DIGITOS) {
			return VALOR_PADRAO;
		}
		return resultado;
	}

	private static int obterValorSoma(String cpf, int peso, int posicaoDigito) {
		int soma = VALOR_INICIAL_DA_SOMA;
		for (int indice = 0; indice < posicaoDigito; indice++) {
			int numero = (cpf.charAt(indice) - POSICAO_DE_0_TABELA_ASCII);
			soma += (numero * peso);
			peso--;
		}
		return soma;
	}

	private static void verificarCpfValido(String cpf, char digito1, char digito2) {
		if (cpf.charAt(POSICAO_PRIMEIRO_DIGITO) != digito1 || cpf.charAt(POSICAO_SEGUNDO_DIGITO) != digito2) {
			throw new IllegalArgumentException(ERROR_MESSAGE_CPF);
		}
	}

	private static void validarDigitos(String cpf) {
		char digito1 = calcularDigitoVerificador(cpf, VALOR_INICIAL_PESO_PRIMEIRO_DIGITO, POSICAO_PRIMEIRO_DIGITO);
		char digito2 = calcularDigitoVerificador(cpf, VALOR_INICIAL_PESO_SEGUNDO_DIGITO, POSICAO_SEGUNDO_DIGITO);
		verificarCpfValido(cpf, digito1, digito2);
	}
}
