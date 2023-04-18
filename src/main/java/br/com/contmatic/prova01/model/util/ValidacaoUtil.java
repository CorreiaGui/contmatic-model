package br.com.contmatic.prova01.model.util;

import static java.time.Period.between;
import static java.time.ZonedDateTime.now;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

public final class ValidacaoUtil {

	private ValidacaoUtil() {
	}

	private static final long MARGEM_ERRO_DATA = 1L;
	private static final int IDADE_MINIMA = 18;
	private static final LocalDate DATA_MINIMA = LocalDate.of(1600, 1, 1);
	private static final LocalDate DATA_LIMITE = LocalDate.now();

	public static void verificaValorMinimo(BigDecimal valor, BigDecimal valorMinimo, String errorMessage) {
		if (valor.compareTo(valorMinimo) < 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaValorMaximo(BigDecimal valor, BigDecimal valorMaximo, String errorMessage) {
		if (valor.compareTo(valorMaximo) > 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaValorMinimo(Integer valor, Integer valorMinimo, String errorMessage) {
		if (valor < valorMinimo) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaValorMaximo(Integer valor, Integer valorMaximo, String errorMessage) {
		if (valor > valorMaximo) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaValorNulo(Object object, String errorMessage) {
		if (object == null) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanho(String parametro, int tamanho, String errorMessage) {
		if (parametro.length() != tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanhoMaximo(String parametro, int tamanho, String errorMessage) {
		if (parametro.length() > tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanhoMinimo(String parametro, int tamanho, String errorMessage) {
		if (parametro.length() < tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaVazio(String string, String errorMessage) {
		if (string.trim().isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanhoMaximo(Set<?> collection, int tamanho, String errorMessage) {
		if (collection.size() > tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanhoMaximo(List<?> collection, int tamanho, String errorMessage) {
		if (collection.size() > tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanhoMinimo(Set<?> collection, int tamanho, String errorMessage) {
		if (collection.size() < tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaTamanhoMinimo(List<?> collection, int tamanho, String errorMessage) {
		if (collection.size() < tamanho) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaVazio(Set<?> collection, String errorMessage) {
		if (collection.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaVazio(List<?> collection, String errorMessage) {
		if (collection.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaDataMinima(LocalDate data, String errorMessage) {
		if (data.isBefore(DATA_MINIMA)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaDataLimite(LocalDate data, String errorMessage) {
		if (data.isAfter(DATA_LIMITE)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaMaiorIdade(LocalDate dataNascimento, String errorMessage) {
		if (between(dataNascimento, DATA_LIMITE).getYears() < IDADE_MINIMA) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaDataMinima(ZonedDateTime data, String errorMessage) {
		if (data.isBefore(now().minusMinutes(MARGEM_ERRO_DATA))) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaDataMaxima(ZonedDateTime data, String errorMessage) {
		if (data.isAfter(now().plusMinutes(MARGEM_ERRO_DATA))) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaRegex(String parametro, String regex, String errorMessage) {
		if (!parametro.matches(regex)) {
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public static void verificaCaracteresRepetidos(String parametro, String errorMessage) {
		char primeiroChar = parametro.charAt(0);
		for (int indice = 0; indice < parametro.length(); indice++) {
			char charAtual = parametro.charAt(indice);
			if (charAtual != primeiroChar) {
				return;
			}
		}
		throw new IllegalArgumentException(errorMessage);
	}
}