package br.com.contmatic.prova01.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.util.enums.SiglaEstado;

class EstadoTest {

	Estado estado;

	@BeforeEach
	void set_up() {
		estado = new Estado(SiglaEstado.valueOf("SP"));
	}

	@Test
	void deve_aceitar_sigla_valida() {
		assertEquals(SiglaEstado.valueOf("SP"), estado.getSigla());
	}

	@Test
	void nao_deve_aceitar_sigla_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> estado.setSigla(null));
		assertTrue(thrown.getMessage().contains("O campo sigla é de preenchimento obrigatório."));
	}

	@Test
	void deve_aceitar_nome_valido() {
		estado.setNome("São Paulo");
		assertEquals("São Paulo", estado.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> estado.setNome(null));
		assertTrue(thrown.getMessage().contains("O campo nome é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> estado.setNome(""));
		assertTrue(thrown.getMessage().contains("O campo nome com espaços em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> estado.setNome("BC"));
		assertTrue(thrown.getMessage().contains("O campo nome do estado necessita de pelo menos três caracteres."));
	}

	@Test
	void nao_deve_aceitar_nome_excedendo_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> estado.setNome("testetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo nome do estado excedeu o limite de caracteres."));
	}

	@Test
	void nao_deve_aceitar_nome_como_numeros_caractes_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> estado.setNome("São P4ulo!"));
		assertTrue(
				thrown.getMessage().contains("O campo nome do estado com números ou caracteres especiais é inválido."));
	}

	@Test
	void deve_retornar_mesmo_hash_code() {
		assertEquals(estado.hashCode(), estado.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesmo_objeto() {
		assertEquals(estado, estado);
	}

	@Test
	void deve_retornar_falso_equals_objeto_nulo() {
		assertNotEquals(estado, (null));
	}

	@Test
	void deve_retornar_falso_equals_classes_diferentes() {
		assertNotEquals(estado, new Object());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesma_instancia() {
		Estado estado2 = new Estado(SiglaEstado.valueOf("SP"));
		assertEquals(estado, estado2);
	}

	@Test
	void deve_retornar_falso_equals_instancia_diferentes() {
		Estado estado2 = new Estado(SiglaEstado.valueOf("RJ"));
		assertNotEquals(estado, estado2);
	}

	@Test
	void deve_retornar_sigla_to_string() {
		assertThat(estado.toString(), containsString("Estado [sigla=SP"));
	}

	@Test
	void deve_retornar_nome_to_string() {
		estado.setNome("São Paulo");
		assertThat(estado.toString(), containsString("nome=São Paulo"));
	}
}
