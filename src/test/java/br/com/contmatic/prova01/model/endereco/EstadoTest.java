package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.NOME_EXCEDENDO_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        estado.setSigla(null);
        String errorMessage = getErrorMessage(estado, MENSAGEM_ERRO_SIGLA_NULL);
        assertEquals(MENSAGEM_ERRO_SIGLA_NULL, errorMessage);
    }

    @Test
    void deve_aceitar_nome_valido() {
        estado.setNome("São Paulo");
        assertEquals("São Paulo", estado.getNome());
    }

    @Test
    void nao_deve_aceitar_nome_nulo() {
        estado.setNome(null);
        String errorMessage = getErrorMessage(estado, MENSAGEM_ERRO_NOME_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_vazio() {
        estado.setNome("");
        String errorMessage = getErrorMessage(estado, MENSAGEM_ERRO_NOME_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_caracteres_insuficientes() {
        estado.setNome("a");
        String errorMessage = getErrorMessage(estado, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_NOME, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_excedendo_maximo() {
        estado.setNome(NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(estado, MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_como_numeros_caractes_especiais() {
        estado.setNome("@123");
        String errorMessage = getErrorMessage(estado, MENSAGEM_ERRO_NOME_REGEX);
        assertEquals(MENSAGEM_ERRO_NOME_REGEX, errorMessage);
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
        assertThat(estado.toString(), containsString("SP"));
    }

    @Test
    void deve_retornar_nome_to_string() {
        estado.setNome("São Paulo");
        assertThat(estado.toString(), containsString("São Paulo"));
    }

    @Test
    void equals_test() {
        simple().forClass(Estado.class).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
