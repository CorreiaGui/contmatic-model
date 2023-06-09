package br.com.contmatic.prova01.model.auditoria;

import static java.time.ZonedDateTime.now;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
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
        auditoria = new Auditoria();
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
        auditoria.setNomeCriador("Guilherme");
        assertEquals("Guilherme", auditoria.getNomeCriador());
    }

    @Test
    void test02_nao_deve_aceitar_nome_criador_nulo() {
        NullPointerException erro = assertThrows(NullPointerException.class, () -> auditoria.setNomeCriador(null));
        //assertTrue(erro.getMessage().contains("O campo 'nome do criador' é de preenchimento obrigatório."));
        System.out.println(erro.getMessage());
    }

    @Test
    void test03_nao_deve_aceitar_nome_criador_vazio() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeCriador(""));
        assertTrue(thrown.getMessage().contains("O campo 'nome do criador' é de preenchimento obrigatório."));
    }

    @Test
    void test04_nao_deve_aceitar_nome_criador_numeros() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeCriador("Guilherme123!@"));
        assertTrue(thrown.getMessage().contains("Números e caracteres especiais no campo 'nome do criador' é inválido"));
    }

    @Test
    void test05_nao_deve_aceitar_nome_criador_caracteres_insuficientes() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeCriador("Cj"));
        assertTrue(thrown.getMessage().contains("O campo nome do criador contém caracteres insuficientes."));
    }

    @Test
    void test06_nao_deve_aceitar_nome_criador_caractere_maximo() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeCriador("Teestetestetestetestetestetestetestetestetesteteste"));
        assertTrue(thrown.getMessage().contains("O campo nome do criador excedeu o limite de caracteres válidos."));
    }

    @Test
    void test07_deve_aceitar_data_criacao() {
        ZonedDateTime teste = now();
        auditoria.setDataCriacao(teste);
        assertEquals(teste, auditoria.getDataCriacao());
    }

    @Test
    void test08_nao_deve_aceitar_data_criacao_nulo() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> auditoria.setDataCriacao(null));
        assertTrue(thrown.getMessage().contains("O campo 'data de criação' é de preenchimento obrigatório."));
    }

    @Test
    void test09_nao_deve_aceitar_data_criacao_futuro() {
        LocalDateTime hora = LocalDateTime.of(2028, Month.MARCH, 21, 15, 50);
        ZoneId fusoHorario = ZoneId.of("America/Phoenix");
        ZonedDateTime data = ZonedDateTime.of(hora, fusoHorario);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setDataCriacao(data));
        assertTrue(thrown.getMessage().contains("A data de criação inserida é inválida."));
    }

    @Test
    void test10_nao_deve_aceitar_data_criacao_passado() {
        LocalDateTime hora = LocalDateTime.of(1900, Month.MARCH, 21, 15, 50);
        ZoneId fusoHorario = ZoneId.of("America/Phoenix");
        ZonedDateTime data1 = ZonedDateTime.of(hora, fusoHorario);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setDataCriacao(data1));
        assertTrue(thrown.getMessage().contains("A data de criação inserida é inválida."));
    }

    @Test
    void test11_deve_aceitar_nome_editor() {
        auditoria.setNomeEditor("Guilherme Correia Martins");
        assertEquals("Guilherme Correia Martins", auditoria.getNomeEditor());
    }

    @Test
    void test12_nao_deve_aceitar_nome_editor_nulo() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> auditoria.setNomeEditor(null));
        assertTrue(thrown.getMessage().contains("O campo 'nome do editor' é de preenchimento obrigatório"));
    }

    @Test
    void test13_nao_deve_aceitar_nome_editor_vazio() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeEditor(""));
        assertTrue(thrown.getMessage().contains("O campo 'nome do editor' é de preenchimento obrigatório"));
    }

    @Test
    void test14_nao_deve_aceitar_nome_editor_numeros() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeEditor("Guilherme123!@"));
        assertTrue(thrown.getMessage().contains("Números e caracteres especiais no campo 'nome do editor' é inválido"));
    }

    @Test
    void test15_nao_deve_aceitar_nome_editor_caracteres_insuficientes() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeEditor("Cj"));
        assertTrue(thrown.getMessage().contains("O campo nome do editor contém caracteres insuficientes."));
    }

    @Test
    void test16_nao_deve_aceitar_nome_editor_caractere_maximo() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setNomeEditor("Teestetestetestetestetestetestetestetestetesteteste"));
        assertTrue(thrown.getMessage().contains("O campo 'nome do editor' excedeu o limite de caracteres válidos."));
    }

    @Test
    void test17_deve_aceitar_data_edicao() {
        ZonedDateTime teste = now();
        auditoria.setDataEdicao(teste);
        assertEquals(teste, auditoria.getDataEdicao());
    }

    @Test
    void test18_nao_deve_aceitar_data_edicao_nulo() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> auditoria.setDataEdicao(null));
        assertTrue(thrown.getMessage().contains("O campo 'data de edição' é de preenchimento obrigatório."));
    }

    @Test
    void test19_nao_deve_aceitar_data_edicao_futuro() {
        LocalDateTime hora = LocalDateTime.of(2028, Month.MARCH, 21, 15, 50);
        ZoneId fusoHorario = ZoneId.of("America/Phoenix");
        ZonedDateTime data = ZonedDateTime.of(hora, fusoHorario);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setDataEdicao(data));
        assertTrue(thrown.getMessage().contains("A data de edição inserida é inválida."));
    }

    @Test
    void test20_nao_deve_aceitar_data_edicao_passado() {
        LocalDateTime hora = LocalDateTime.of(1900, Month.MARCH, 21, 15, 50);
        ZoneId fusoHorario = ZoneId.of("America/Phoenix");
        ZonedDateTime data1 = ZonedDateTime.of(hora, fusoHorario);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> auditoria.setDataEdicao(data1));
        assertTrue(thrown.getMessage().contains("A data de edição inserida é inválida."));
    }

    @Test
    void test21_deve_retornar_nome_criador_to_string() {
        String nomeCriador = "Gui";
        auditoria.setNomeCriador(nomeCriador);
        String resultado = auditoria.toString();
        assertThat(resultado, containsString(nomeCriador));
    }

    @Test
    void test22_deve_retornar_data_criacao_to_string() {
        ZonedDateTime data = ZonedDateTime.now();
        auditoria.setDataCriacao(data);
        String dataString = data.toString();
        assertThat(auditoria.toString(), containsString(dataString));
    }

    @Test
    void test23_deve_retornar_nome_editor_to_string() {
        String nomeEditor = "Gui";
        auditoria.setNomeEditor(nomeEditor);
        String resultado = auditoria.toString();
        assertThat(resultado, containsString(nomeEditor));
    }

    @Test
    void test24_deve_retornar_data_edicao_to_string() {
        ZonedDateTime data = ZonedDateTime.now();
        auditoria.setDataEdicao(data);
        String dataString = data.toString();
        assertThat(auditoria.toString(), containsString(dataString));
    }

    @Test
    @Disabled
    void test25_deve_ser_ignorado() {
        auditoria.setNomeCriador("teste");
        assertEquals("teste", auditoria.getNomeCriador());
        System.out.println(auditoria.getNomeCriador());
    }
}
