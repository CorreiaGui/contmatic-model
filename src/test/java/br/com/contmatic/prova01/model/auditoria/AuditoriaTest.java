package br.com.contmatic.prova01.model.auditoria;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_REGEX;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_REGEX;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.NOME_CRIADOR_ULTRAPASSANDO_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.TAMANHO_NOME_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.TAMANHO_NOME_MINIMO;
import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static java.time.ZonedDateTime.now;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static nl.jqno.equalsverifier.Warning.INHERITED_DIRECTLY_FROM_OBJECT;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import br.com.six2six.fixturefactory.Fixture;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AuditoriaTest {

    private Auditoria auditoria;

    static int numero;

    @BeforeAll
    static void mensagem_inicio_testes() {
        System.out.println("Classe auditoria teste iniciada.");
    }

    @BeforeEach
    void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        auditoria = from(Auditoria.class).gimme("valid");
        numero++;
    }

    @AfterEach
    void teste() {
        System.out.println("> Testes em andamento < (" + numero + ")");
    }

    @AfterAll
    static void mensagem_final_teste() {
        System.out.println("Classe de TESTES finalizada.");
    }

    @Test
    @Timeout(1)
    void test01_deve_aceitar_nome_criador() {
        assertTrue(auditoria.getNomeCriador().length() < TAMANHO_NOME_MAXIMO
            && auditoria.getNomeEditor().length() >= TAMANHO_NOME_MINIMO);
    }

    @Test
    void test02_nao_deve_aceitar_nome_criador_nulo() {
        auditoria.setNomeCriador(null);
        String errorMessageee = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_CRIADOR_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_CRIADOR_NULL, errorMessageee);
    } 
    
    @Test
    void test03_nao_deve_aceitar_nome_criador_vazio() {
        auditoria.setNomeCriador("");
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_CRIADOR_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_CRIADOR_VAZIO, errorMessage);
    }

    @Test
    void test04_nao_deve_aceitar_nome_criador_numeros() {
        auditoria.setNomeCriador("123");
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_CRIADOR_REGEX);
        assertEquals(MENSAGEM_ERRO_NOME_CRIADOR_REGEX, errorMessage);
    }

    @Test
    void test05_nao_deve_aceitar_nome_criador_caractere_maximo() {
        auditoria.setNomeCriador(NOME_CRIADOR_ULTRAPASSANDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO, errorMessage);
    }

    @Test
    void test06_deve_aceitar_data_criacao() {
        ZonedDateTime teste = now();
        auditoria.setDataCriacao(teste);
        assertEquals(teste, auditoria.getDataCriacao());
    }

    @Test
    void test07_nao_deve_aceitar_data_criacao_nulo() {
        auditoria.setDataCriacao(null);
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_DATA_CRIACAO_NULL);
        assertEquals(MENSAGEM_ERRO_DATA_CRIACAO_NULL, errorMessage);
    }
    
    @Test
    void test08_nao_deve_aceitar_data_criacao_passado() {
        ZoneId zoneId = ZoneId.of("America/Phoenix");
        LocalDateTime date = LocalDateTime.now();
        ZonedDateTime data = ZonedDateTime.of(date.minusDays(1), zoneId);
        Auditoria auditoria = Fixture.from(Auditoria.class).gimme("valid");
        auditoria.setDataCriacao(data);
        assertEquals(MENSAGEM_ERRO_DATA_CRIACAO, getErrorMessage(auditoria, MENSAGEM_ERRO_DATA_CRIACAO));
    }
    
    @Test
    void test09_nao_deve_aceitar_data_criacao_futuro() {
        ZoneId zoneId = ZoneId.of("America/Phoenix");
        LocalDateTime date = LocalDateTime.now();
        ZonedDateTime data = ZonedDateTime.of(date.plusDays(1), zoneId);
        Auditoria auditoria = Fixture.from(Auditoria.class).gimme("valid");
        auditoria.setDataCriacao(data);
        assertEquals(MENSAGEM_ERRO_DATA_CRIACAO, getErrorMessage(auditoria, MENSAGEM_ERRO_DATA_CRIACAO));
    }

    @Test
    void test10_deve_aceitar_nome_editor() {
        assertTrue(auditoria.getNomeEditor().length() < TAMANHO_NOME_MAXIMO
            && auditoria.getNomeEditor().length() >= TAMANHO_NOME_MINIMO);
    }

    @Test
    void test11_nao_deve_aceitar_nome_editor_nulo() {
        auditoria.setNomeEditor(null);
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_EDITOR_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_EDITOR_NULL, errorMessage);
    }

    @Test
    void test12_nao_deve_aceitar_nome_editor_vazio() {
        auditoria.setNomeEditor("");
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_EDITOR_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_EDITOR_NULL, errorMessage);
    }

    @Test
    void test13_nao_deve_aceitar_nome_editor_numeros() {
        auditoria.setNomeEditor("123");
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_EDITOR_REGEX);
        assertEquals(MENSAGEM_ERRO_NOME_EDITOR_REGEX, errorMessage);
    }

    @Test
    void test14_nao_deve_aceitar_nome_editor_caracteres_insuficientes() {
        auditoria.setNomeEditor("a");
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_EDITOR_TAMANHO, errorMessage);
    }

    @Test
    void test15_nao_deve_aceitar_nome_editor_caractere_maximo() {
        auditoria.setNomeEditor(NOME_CRIADOR_ULTRAPASSANDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_EDITOR_TAMANHO, errorMessage);
    }

    @Test
    void test16_deve_aceitar_data_edicao() {
        ZonedDateTime teste = now();
        auditoria.setDataEdicao(teste);
        assertEquals(teste, auditoria.getDataEdicao());
    }

    @Test
    void test17_nao_deve_aceitar_data_edicao_nulo() {
        auditoria.setDataEdicao(null);
        String errorMessage = getErrorMessage(auditoria, MENSAGEM_ERRO_DATA_EDICAO_NULL);
        assertEquals(MENSAGEM_ERRO_DATA_EDICAO_NULL, errorMessage);
    }
    
    @Test
    void test18_nao_deve_aceitar_data_edicao_futuro() {
        ZoneId zoneId = ZoneId.of("America/Phoenix");
        LocalDateTime date = LocalDateTime.now();
        ZonedDateTime data = ZonedDateTime.of(date.plusDays(1), zoneId);
        Auditoria auditoria = Fixture.from(Auditoria.class).gimme("valid");
        auditoria.setDataEdicao(data);
        assertEquals(MENSAGEM_ERRO_DATA_EDICAO, getErrorMessage(auditoria, MENSAGEM_ERRO_DATA_EDICAO));
    }
    
    @Test
    void test19_nao_deve_aceitar_data_edicao_passado() {
        ZoneId zoneId = ZoneId.of("America/Phoenix");
        LocalDateTime date = LocalDateTime.now();
        ZonedDateTime data = ZonedDateTime.of(date.minusDays(1), zoneId);
        Auditoria auditoria = Fixture.from(Auditoria.class).gimme("valid");
        auditoria.setDataEdicao(data);
        assertEquals(MENSAGEM_ERRO_DATA_EDICAO, getErrorMessage(auditoria, MENSAGEM_ERRO_DATA_EDICAO));
    }

    @Test
    void test20_deve_retornar_nome_criador_to_string() {
        auditoria.setNomeCriador("Guilherme");
        assertThat(auditoria.toString(), containsString("Guilherme"));
    }

    @Test
    void test21_deve_retornar_data_criacao_to_string() {
        ZonedDateTime data = ZonedDateTime.now();
        auditoria.setDataCriacao(data);
        String dataString = data.toString();
        assertThat(auditoria.toString(), containsString(dataString));
    }

    @Test
    void test22_deve_retornar_nome_editor_to_string() {
        auditoria.setNomeEditor("Guilherme");
        assertThat(auditoria.toString(), containsString("Guilherme"));
    }

    @Test
    void test23_deve_retornar_data_edicao_to_string() {
        ZonedDateTime data = ZonedDateTime.now();
        auditoria.setDataEdicao(data);
        String dataString = data.toString();
        assertThat(auditoria.toString(), containsString(dataString));
    }
    
    @Test
    void test_equals() {
        simple().forClass(Auditoria.class)
            .suppress(INHERITED_DIRECTLY_FROM_OBJECT)
            .suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }

    @Test
    @Disabled
    void test24_deve_ser_ignorado() {
        auditoria.setNomeCriador("teste");
        assertEquals("teste", auditoria.getNomeCriador());
        System.out.println(auditoria.getNomeCriador());
    }
}
