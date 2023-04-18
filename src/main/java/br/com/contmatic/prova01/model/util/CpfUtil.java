package br.com.contmatic.prova01.model.util;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaCaracteresRepetidos;

public final class CpfUtil {

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
		verificaCaracteresRepetidos(cpf, ERROR_MESSAGE_NUMEROS_IGUAIS_CPF);
		validarDigitos(cpf);
	}

	private static char calcularDigitoVerificador(String cpf, int peso, int posicaoDigito) {
		int soma = VALOR_INICIAL_DA_SOMA;
		for (int indice = 0; indice < posicaoDigito; indice++) {
			int numero = (cpf.charAt(indice) - POSICAO_DE_0_TABELA_ASCII);
			soma += (numero * peso);
			peso--;
		}
		int resultado = 11 - (soma % 11);
		if (resultado > 9) {
			return 0;
		}
		return (char) (resultado + POSICAO_DE_0_TABELA_ASCII);
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
