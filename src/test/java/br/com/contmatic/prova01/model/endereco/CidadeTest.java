package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_ESTADO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.NOME_EXCEDENDO_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.TAMANHO_NOME;
import static br.com.contmatic.prova01.model.util.enums.SiglaEstado.SP;
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

class CidadeTest {

    Cidade cidade;

    Estado estado;

    @BeforeEach
    void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        estado = from(Estado.class).gimme("Estado valido");
        cidade = from(Cidade.class).gimme("Cidade valida");
    }

    @Test
    void deve_aceitar_nome_cidade() {
        cidade.setNome("São Paulo");
        assertEquals("São Paulo", cidade.getNome());
    }

    @Test
    void deve_aceitar_nome_cidade_randomico() {
        assertTrue(cidade.getNome().length() >= TAMANHO_MINIMO_NOME && cidade.getNome().length() <= TAMANHO_NOME);
    }

    @Test
    void nao_deve_aceitar_nome_nulo() {
        cidade.setNome(null);
        String errorMessage = getErrorMessage(cidade, MENSAGEM_ERRO_NOME_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_vazio() {
        cidade.setNome("");
        String errorMessage = getErrorMessage(cidade, MENSAGEM_ERRO_NOME_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_numeros() {
        cidade.setNome("123");
        String errorMessage = getErrorMessage(cidade, MENSAGEM_ERRO_NOME_REGEX);
        assertEquals(MENSAGEM_ERRO_NOME_REGEX, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_caracteres_insuficientes() {
        cidade.setNome("a");
        String errorMessage = getErrorMessage(cidade, MENSAGEM_ERRO_NOME_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_NOME_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_excedendo_maximo_caracteres() {
        cidade.setNome(NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(cidade, MENSAGEM_ERRO_NOME_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_estado_valido() {
        Cidade cidade = new Cidade("sp", estado);
        assertEquals(estado, cidade.getEstado());
    }

    @Test
    void nao_deve_aceitar_estado_null() {
        cidade.setEstado(null);
        String errorMessage = getErrorMessage(cidade, MENSAGEM_ERRO_ESTADO_NULL);
        assertEquals(MENSAGEM_ERRO_ESTADO_NULL, errorMessage);
    }

    @Test
    void deve_retornar_mesmo_hash_code() {
        Cidade cidade2 = new Cidade("São Paulo", estado);
        Cidade cidade3 = new Cidade("São Paulo", estado);
        assertEquals(cidade3.hashCode(), cidade2.hashCode());
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
        Cidade cidade3 = new Cidade("São Paulo", estado);
        assertEquals(cidade3, cidade2);
    }

    @Test
    void deve_retornar_falso_equals_instancias_diferentes() {
        Cidade cidade2 = new Cidade("Diadema", estado);
        assertNotEquals(cidade, cidade2);
    }

    @Test
    void deve_retornar_nome_to_string() {
        Cidade cidade = new Cidade("São Paulo", estado);
        assertThat(cidade.toString(), containsString("São Paulo"));
    }

    @Test
    void deve_retornar_estado_to_string() {
        Estado estado = new Estado(SP);
        Cidade cidade = new Cidade("São Paulo", estado);
        assertThat(cidade.toString(), containsString("SP"));
    }

    @Test
    void equals_test() {
        simple().forClass(Cidade.class).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
