package br.com.contmatic.prova01.model.email;

import static br.com.contmatic.prova01.model.util.enums.TipoEmail.PESSOAL;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.empresa.Empresa;
import br.com.contmatic.prova01.model.util.enums.TipoEmail;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

class EmailTest {

	private Email email;

	@BeforeEach
	void setUp() {
	    FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
		email = Fixture.from(Email.class).gimme("Email valido");
	}

	@Test
	void deve_aceitar_tipo() {
		assertEquals(PESSOAL, email.getTipo());
	}

	@Test
	void nao_deve_aceitar_tipo_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class, ()
				-> email.setTipo(null));
		assertTrue(thrown.getMessage().contains("O campo 'tipo do email' é de preenchimento obrigatório."));
	}

	@Test
	void deve_aceitar_endereco_email() {
		assertEquals("guilherme@email.com", email.getEndereco());
	}

	@Test
	void nao_deve_aceitar_endereco_email_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> email.setEndereco(null));
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
		email.setTipo(TipoEmail.valueOf("PESSOAL"));
		assertThat(email.toString(), containsString("PESSOAL"));
	}

	@Test
	void deve_retornar_endereco_to_string() {
		assertThat(email.toString(), containsString("guilherme@email.com"));
	}
}
