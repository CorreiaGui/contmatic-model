package br.com.contmatic.prova01.model.email;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.NOME_EXCEDENDO_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_MINIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.enums.TipoEmail.PESSOAL;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        email.setTipo(PESSOAL);
        assertEquals(PESSOAL, email.getTipo());
    }

    @Test
    void nao_deve_aceitar_tipo_nulo() {
        email.setTipo(null);
        String errorMessage = getErrorMessage(email, MENSAGEM_ERRO_TIPO_EMAIL_NULL);
        assertEquals(MENSAGEM_ERRO_TIPO_EMAIL_NULL, errorMessage);
    }

    @Test
    void deve_aceitar_endereco_email() {
        assertTrue(email.getEndereco().length() <= TAMANHO_MAXIMO_EMAIL 
                && email.getEndereco().length() >= TAMANHO_MINIMO_EMAIL);
    }

    @Test
    void nao_deve_aceitar_endereco_email_nulo() {
        email.setEndereco(null);
        String errorMessage = getErrorMessage(email, MENSAGEM_ERRO_EMAIL_NULL);
        assertEquals(MENSAGEM_ERRO_EMAIL_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_email_com_espaco_em_branco() {
        email.setEndereco("");
        String errorMessage = getErrorMessage(email, MENSAGEM_ERRO_EMAIL_VAZIO);
        assertEquals(MENSAGEM_ERRO_EMAIL_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_caracteres_insuficientes() {
        email.setEndereco("a");
        String errorMessage = getErrorMessage(email, MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_caracteres_excedendo_limite() {
        email.setEndereco(NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(email, MENSAGEM_ERRO_EMAIL_TAMANHO_MAXIMO);
        assertEquals(MENSAGEM_ERRO_EMAIL_TAMANHO_MAXIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_invalido() {
        email.setEndereco("teste.com");
        String errorMessage = getErrorMessage(email, MENSAGEM_ERRO_EMAIL_REGEX);
        assertEquals(MENSAGEM_ERRO_EMAIL_REGEX, errorMessage);
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
        Email email = new Email("guilherme@email.com");
        assertThat(email.toString(), containsString("guilherme@email.com"));
    }

    @Test
    void equalsverify() {
        simple().forClass(Email.class).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
