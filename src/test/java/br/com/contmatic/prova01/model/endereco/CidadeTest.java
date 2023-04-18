package br.com.contmatic.prova01.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CidadeTest {

	Cidade cidade;

	Estado estado;

	@BeforeEach
	void set_up() {
		estado = new Estado("SP");
		cidade = new Cidade("São Paulo", estado);
	}

	@Test
	void deve_aceitar_nome_cidade() {
		cidade.setNome("São Paulo");
		assertEquals("São Paulo", cidade.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cidade.setNome(null));
		assertTrue(thrown.getMessage().contains("O campo nome da cidade é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cidade.setNome("  "));
		assertTrue(thrown.getMessage().contains("O campo nome com espaços em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cidade.setNome("123"));
		assertTrue(thrown.getMessage().contains("O campo nome com números ou caracteres especiais é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cidade.setNome("a"));
		assertTrue(thrown.getMessage().contains("O campo nome da cidade com menos de três caractere é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_excedendo_maximo_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cidade.setNome("testetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo nome da cidade excedeu a quantidade de caracteres."));
	}

	@Test
	void deve_aceitar_estado_valido() {
		assertEquals(estado, cidade.getEstado());
	}

	@Test
	void nao_deve_aceitar_estado_null() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> cidade.setEstado(null));
		assertTrue(thrown.getMessage().contains("O campo estado é de preenchimento obrigatório"));
	}

	@Test
	void deve_retornar_mesmo_hash_code() {
		Cidade cidade2 = new Cidade("São Paulo", estado);
		assertEquals(cidade.hashCode(), cidade2.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesmo_objeto() {
		assertEquals(cidade, cidade);
	}

	@Test
	void deve_retornar_falso_equals_objeto_nulo() {
		assertNotEquals(cidade, (null));
	}

	@Test
	void deve_retornar_falso_equals_classes_diferentes() {
		assertNotEquals(cidade, new Object());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesma_instancia() {
		Cidade cidade2 = new Cidade("São Paulo", estado);
		assertEquals(cidade, cidade2);
	}

	@Test
	void deve_retornar_falso_equals_instancias_diferentes() {
		Cidade cidade2 = new Cidade("Diadema", estado);
		assertNotEquals(cidade, cidade2);
	}

	@Test
	void deve_retornar_nome_to_string() {
		assertThat(cidade.toString(), containsString("nome=São Paulo"));
	}

	@Test
	void deve_retornar_estado_to_string() {
		assertThat(cidade.toString(), containsString("sigla=SP"));
	}
}
