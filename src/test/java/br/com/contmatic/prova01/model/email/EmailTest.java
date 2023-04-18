package br.com.contmatic.prova01.model.email;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.empresa.Empresa;

class EmailTest {

	private Email email;

	@BeforeEach
	void setUp() {
		email = new Email("gc.correia21@gmail.com");
	}

	@Test
	void deve_aceitar_tipo() {
		email.setTipo("PESSOAL");
		assertEquals("PESSOAL", email.getTipo());
	}

	@Test
	void nao_deve_aceitar_tipo_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setTipo(null));
		assertTrue(thrown.getMessage().contains("O campo 'tipo do email' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_tipo_com_um_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setTipo(""));
		assertTrue(thrown.getMessage().contains("O campo 'tipo do email' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_tipo_diferente_pessoal_profissional() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setTipo("testeee"));
		assertTrue(thrown.getMessage()
				.contains("O campo 'tipo do email' diferente de Pessoal ou Profissional é inválido"));
	}

	@Test
	void nao_deve_aceitar_tipo_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setTipo("Ab"));
		assertTrue(thrown.getMessage().contains("O campo contém catacteres insuficientes."));
	}

	@Test
	void nao_deve_aceitar_tipo_caracteres_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> email.setTipo("testetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo 'tipo do email' excedeu o limite de caracteres."));
	}

	@Test
	void deve_aceitar_endereco_email() {
		email.setEndereco("email.teste213_!@dominio.com");
		assertEquals("email.teste213_!@dominio.com", email.getEndereco());
	}

	@Test
	void nao_deve_aceitar_endereco_email_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setEndereco(null));
		assertTrue(thrown.getMessage().contains("O campo 'endereço de email' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_endereco_email_com_espaco_em_branco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setEndereco(""));
		assertTrue(thrown.getMessage().contains("O campo 'endereço de email' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_endereco_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> email.setEndereco("f"));
		assertTrue(thrown.getMessage().contains("O campo contém catacteres insuficientes."));
	}

	@Test
	void nao_deve_aceitar_endereco_caracteres_excedendo_limite() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> email.setEndereco("testetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo 'endereço de email' excedeu o limite de caracteres."));
	}

	@Test
	void nao_deve_aceitar_endereco_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> email.setEndereco("teste.com"));
		assertTrue(thrown.getMessage().contains("Email inválido. exemplo: emailvalido@dominio.com"));
	}

	@Test
	void deve_retornar_verdadeiro_equals() {
		Email email1 = new Email("gui.corre@gmail.com");
		Email email2 = new Email("gui.corre@gmail.com");
		assertEquals(email1, email2);
	}

	@Test
	void deve_retornar_falso_para_equals_comparado_com_nulo() {
		assertNotEquals(email, (null));
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesma_instancia() {
		assertEquals(email, email);
	}

	@Test
	void deve_retornar_falso_equals_diferentes_classes() {
		assertNotEquals(email, Empresa.class);
	}

	@Test
	void deve_testar_mesmo_valor_hash_code() {
		Email email1 = new Email("gui.corre@gmail.com");
		Email email2 = new Email("gui.corre@gmail.com");
		assertEquals(email1.hashCode(), email2.hashCode());
	}

	@Test
	void deve_retornar_tipo_to_string() {
		email.setTipo("PESSOAL");
		assertThat(email.toString(), containsString("PESSOAL"));
	}

	@Test
	void deve_retornar_endereco_to_string() {
		email.setEndereco("guilherme@email.com");
		assertThat(email.toString(), containsString("guilherme@email.com"));
	}
}
