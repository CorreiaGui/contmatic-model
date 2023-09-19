package br.com.contmatic.prova01.model.telefone;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_NULL;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_REGEX;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_NULL;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_REGEX;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_NULL;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_DDD;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_DDI;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_MINIMO_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_NUMERO;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTest {

	Telefone telefone;

	@BeforeEach
	void set_up() {
	    loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
		telefone = from(Telefone.class).gimme("Telefone valido");
	}

	@Test
	void deve_aceitar_ddi_valido() {
		assertTrue(telefone.getDdi().length() > TAMANHO_MINIMO && 
		    telefone.getDdi().length() <= TAMANHO_DDI);
	}

	@Test
	void nao_deve_aceitar_ddi_nulo() {
	    telefone.setDdi(null);
	    String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDI_NULL);
	    assertEquals(MENSAGEM_ERRO_DDI_NULL, errorMessage);
	}
	
	@Test
	void nao_deve_aceitar_ddi_espaco_branco() {
	    telefone.setDdi("   ");
	    assertEquals(MENSAGEM_ERRO_DDI_VAZIO, getErrorMessage(telefone, MENSAGEM_ERRO_DDI_VAZIO));
	}

	@Test
	void nao_deve_aceitar_ddi_vazio() {
	    telefone.setDdi("");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDI_VAZIO);
        assertEquals(MENSAGEM_ERRO_DDI_VAZIO, errorMessage);
	}

	@Test
	void nao_deve_aceitar_ddi_com_letras() {
	    telefone.setDdi("aa");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDI_REGEX);
        assertEquals(MENSAGEM_ERRO_DDI_REGEX, errorMessage);
	}

	@Test
	void nao_deve_aceitar_ddi_excedendo_limite_caracteress() {
	    telefone.setDdi("1231231");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDI_TAMANHO);
        assertEquals(MENSAGEM_ERRO_DDI_TAMANHO, errorMessage);
	}

	@Test
	void deve_aceitar_ddd_valido() {
		assertEquals(TAMANHO_DDD, telefone.getDdd().length());
	}

	@Test
	void nao_deve_aceitar_ddd_nulo() {
	    telefone.setDdd(null);
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDD_NULL);
        assertEquals(MENSAGEM_ERRO_DDD_NULL, errorMessage);
	}
	
	@Test
	void nao_deve_aceitar_ddd_espaco_branco() {
	    telefone.setDdd("   ");
	    String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDD_VAZIO);
	    assertEquals(MENSAGEM_ERRO_DDD_VAZIO, errorMessage);
	}

	@Test
	void nao_deve_aceitar_ddd_vazio() {
	    telefone.setDdd("");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDD_VAZIO);
        assertEquals(MENSAGEM_ERRO_DDD_VAZIO, errorMessage);
	}

	@Test
	void nao_deve_aceitar_ddd_letras() {
	    telefone.setDdd("a");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDD_REGEX);
        assertEquals(MENSAGEM_ERRO_DDD_REGEX, errorMessage);
	}

	@Test
	void nao_deve_aceitar_ddd_diferente_dois_digitos() {
	    telefone.setDdd("1");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_DDD_TAMANHO);
        assertEquals(MENSAGEM_ERRO_DDD_TAMANHO, errorMessage);
	}

	@Test
	void deve_aceitar_numero_valido() {
		assertTrue(telefone.getNumero().length() == TAMANHO_NUMERO 
		    || telefone.getNumero().length() == TAMANHO_MINIMO_NUMERO);
	}

	@Test
	void nao_deve_aceitar_numero_nulo() {
	    telefone.setNumero(null);
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_NUMERO_NULL);
        assertEquals(MENSAGEM_ERRO_NUMERO_NULL, errorMessage);
	}
 
	@Test
	void nao_deve_aceitar_numero_vazio() {
	    telefone.setNumero("");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_NUMERO_VAZIO);
        assertEquals(MENSAGEM_ERRO_NUMERO_VAZIO, errorMessage);
	}
	
	@Test
	void nao_deve_aceitar_numero_espaco_branco() {
	    telefone.setNumero("  ");
	    String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_NUMERO_VAZIO);
	    assertEquals(MENSAGEM_ERRO_NUMERO_VAZIO, errorMessage);
	}

	@Test
	void nao_deve_aceitar_numero_com_letras() {
	    telefone.setNumero("aa");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_NUMERO_REGEX);
        assertEquals(MENSAGEM_ERRO_NUMERO_REGEX, errorMessage);
	}

	@Test
	void nao_deve_aceitar_numero_menor_tamanho_minimo() {
	    telefone.setNumero("1234");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO, errorMessage);
	}

	@Test
	void nao_deve_aceitar_numero_excedendo_tamanho_maximo() {
	    telefone.setNumero("112321323123131234");
        String errorMessage = getErrorMessage(telefone, MENSAGEM_ERRO_NUMERO_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NUMERO_TAMANHO, errorMessage);
	}

	@Test
	void deve_retornar_mesmo_hash_code() {
	    Telefone tel2 = new Telefone("55", "11", "948623933");
	    Telefone tel1 = new Telefone("55", "11", "948623933");
		assertEquals(tel1.hashCode(), tel2.hashCode());
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
	    Telefone tel2 = new Telefone("55", "11", "948623933");
        Telefone tel1 = new Telefone("55", "11", "948623933");
	    assertEquals(tel1, tel2);
	}
	
	@Test
	void deve_retornar_falso_equals_instancias_diferentes() {
		Telefone telefone2 = new Telefone("55", "13", "948623933");
		assertNotEquals(telefone, telefone2);
	}

	@Test
	void deve_retornar_ddi_to_string() {
	    telefone.setDdi("55");
		assertThat(telefone.toString(), containsString("55"));
	}

	@Test
	void deve_retornar_ddd_to_string() {
	    telefone.setDdd("11");
		assertThat(telefone.toString(), containsString("11"));
	}

	@Test
	void deve_retornar_telefone_to_string() {
	    telefone.setNumero("948623933");
		assertThat(telefone.toString(), containsString("948623933"));
	}
	
	@Test
	void equals_test() {
	    simple().forClass(Telefone.class).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
	}
}
