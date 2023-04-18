package br.com.contmatic.prova01.model.telefone;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTest {

	Telefone telefone;

	@BeforeEach
	void set_up() {
		telefone = new Telefone("55", "11", "948623933");
	}

	@Test
	void deve_aceitar_ddi_valido() {
		assertEquals("55", telefone.getDdi());
	}

	@Test
	void nao_deve_aceitar_ddi_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdi(null));
		assertTrue(thrown.getMessage().contains("O campo DDI é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_ddi_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdi("   "));
		assertTrue(thrown.getMessage().contains("O campo DDI com espaço em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_ddi_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdi("AA"));
		assertTrue(thrown.getMessage().contains("O campo DDI diferente de número é inválido."));
	}

	@Test
	void nao_deve_aceitar_ddi_excedendo_limite_caracteress() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("2132131231"));
		assertTrue(thrown.getMessage().contains("O campo DDI excedeu o limite de caracteres."));
	}

	@Test
	void deve_aceitar_ddd_valido() {
		assertEquals("11", telefone.getDdd());
	}

	@Test
	void nao_deve_aceitar_ddd_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdd(null));
		assertTrue(thrown.getMessage().contains("O campo DDD é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_ddd_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdd(""));
		assertTrue(thrown.getMessage().contains("O campo DDD com espaços em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_ddd_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdd("ab"));
		assertTrue(thrown.getMessage().contains("O campo DDD diferente de número é inválido. Exemplo: DDD 11"));
	}

	@Test
	void nao_deve_aceitar_ddd_diferente_dois_digitos() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setDdd("123123"));
		assertTrue(thrown.getMessage().contains("O campo DDD diferente de número é inválido. Exemplo: DDD 11"));
	}

	@Test
	void deve_aceitar_numero_valido() {
		assertEquals("948623933", telefone.getNumero());
	}

	@Test
	void nao_deve_aceitar_numero_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setNumero(null));
		assertTrue(thrown.getMessage().contains("O campo Numero é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_numero_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setNumero("  "));
		assertTrue(thrown.getMessage().contains("O campo número com espaços em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_numero_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> telefone.setNumero("a!"));
		assertTrue(thrown.getMessage().contains("O campo Número não permite caracteres especiais e letras."));
	}

	@Test
	void nao_deve_aceitar_numero_menor_tamanho_minimo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("1234567"));
		assertTrue(thrown.getMessage().contains("O campo número necessita de pelo menos oito caractere."));
	}

	@Test
	void nao_deve_aceitar_numero_excedendo_tamanho_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("123456789000"));
		assertTrue(thrown.getMessage().contains("O campo número excedeu o limite de caracteres"));
	}

	@Test
	void deve_retornar_mesmo_hash_code() {
		assertEquals(telefone.hashCode(), telefone.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesmo_objeto() {
		assertEquals(telefone, telefone);
	}

	@Test
	void deve_retornar_falso_equals_objeto_nulo() {
		assertNotEquals(telefone, (null));
	}

	@Test
	void deve_retornar_falso_equals_classes_diferentes() {
		assertNotEquals(telefone, new Object());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesma_instancia() {
		Telefone telefone2 = new Telefone("55", "11", "948623933");
		assertEquals(telefone, telefone2);
	}

	@Test
	void deve_retornar_falso_equals_instancias_diferentes() {
		Telefone telefone2 = new Telefone("55", "13", "948623933");
		assertNotEquals(telefone, telefone2);
	}

	@Test
	void deve_retornar_ddi_to_string() {
		assertThat(telefone.toString(), containsString("ddi=55"));
	}

	@Test
	void deve_retornar_ddd_to_string() {
		assertThat(telefone.toString(), containsString("ddd=11"));
	}

	@Test
	void deve_retornar_telefone_to_string() {
		assertThat(telefone.toString(), containsString("numero=948623933"));
	}
}
