package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_RESPONSAVEL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.NOME_EXCEDENDO_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MINIMO_NOME;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.util.TesteUtil;
import br.com.six2six.fixturefactory.Fixture;

class SetorTest {

    Setor setor;

    @BeforeEach
    void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        setor = Fixture.from(Setor.class).gimme("Setor sem funcionario");
    }

    @Test
    void deve_aceitar_nome_valido() {
        setor.setNome("adm");
        assertEquals("adm", setor.getNome());
    }
    
    @Test
    void deve_aceitar_nome_valido_randomico() {
        assertTrue(setor.getNome().length() >= TAMANHO_MINIMO_NOME && setor.getNome().length() <= TAMANHO_MAXIMO_NOME);
    } 

    @Test
    void nao_deve_aceitar_nome_nulo() {
        setor.setNome(null);
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_NOME_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_vazio() {
        setor.setNome("");
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_NOME_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_menor_tamanho_minimo() {
        setor.setNome("a");
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_NOME, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_maior_tamanho_maximo() {
        setor.setNome(NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_NOME_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_lista_funcionarios() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario("41659541875");
        funcionarios.add(funcionario);
        setor.setFuncionarios(funcionarios);
        assertEquals(funcionarios, setor.getFuncionarios());
    }

    @Test
    void nao_deve_aceitar_lista_funcionarios_nulo() {
        setor.setFuncionarios(null);
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL);
        assertEquals(MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_funcionarios_vazio() {
        List<Funcionario> funcionarios = new ArrayList<>();
        setor.setFuncionarios(funcionarios);
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO);
        assertEquals(MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_funcionarios_excedendo_tamanho_maximo() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        for(Integer indice = TAMANHO_LISTA_FUNCIONARIO + 2 ; indice != 0 ; indice--) {
            Funcionario funcionario = new Funcionario("41659541875");
            funcionarios.add(funcionario);
        }
        setor.setFuncionarios(funcionarios);
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO);
        assertEquals(MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_funcionario_responsavel_valido() {
        Funcionario responsavel = new Funcionario("41659541875");
        setor.setResponsavel(responsavel);
        assertEquals(responsavel, setor.getResponsavel());
    }

    @Test
    void nao_deve_aceitar_funcionario_responsavel_nulo() {
        setor.setResponsavel(null);
        String errorMessage = TesteUtil.getErrorMessage(setor, MENSAGEM_ERRO_RESPONSAVEL_NULL);
        assertEquals(MENSAGEM_ERRO_RESPONSAVEL_NULL, errorMessage);
    }

    @Test
    void deve_comparar_hash_code() {
        Setor setor2 = new Setor("adm");
        assertEquals(setor.hashCode(), setor2.hashCode());
    }

    @Test
    void deve_comparar_equals_mesmo_objeto() {
        assertEquals(setor, setor);
    }

    @Test
    void deve_comparar_equal_nulo() {
        assertNotEquals(setor, (null));
    }

    @Test
    void deve_comparar_equal_classes_diferentes() {
        assertNotEquals(setor, new Object());
    }

    @Test
    void deve_comparar_equals_objetos_diferentes() {
        Setor setor2 = new Setor("adm");
        assertEquals(setor, setor2);
    }

    @Test
    void deve_retornar_nome_to_string() {
        assertThat(setor.toString(), containsString("adm"));
    }

    @Test
    void deve_retornar_funcionario_to_string() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario("41659541875");
        funcionarios.add(funcionario);
        setor.setFuncionarios(funcionarios);
        assertThat(setor.toString(), containsString("41659541875"));
    }

    @Test
    void deve_retornar_responsavel_to_string() {
        Funcionario responsavel = new Funcionario("41659541875");
        responsavel.setNome("Guilherme");
        setor.setResponsavel(responsavel);
        assertThat(setor.toString(), containsString("Guilherme"));
    }
    
    @Test
    void equals_test() {
        simple().forClass(Setor.class).withPrefabValues(Funcionario.class, 
            new Funcionario("1"), new Funcionario("2")).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
