package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_MENOR_IDADE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MESSAGEM_ERRO_CPF;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_MINIMA;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_EMAIL_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_ENDERECO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_ENDERECO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_ENDERECO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_SETOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.NOME_EXCEDENDO_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMAMNHO_CPF;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MINIMO_NOME;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

class FuncionarioTest {

    Funcionario funcionario;

    @BeforeEach
    void set_up() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        funcionario = Fixture.from(Funcionario.class).gimme("Funcionario valido");
    }

    @Test
    void deve_aceitar_cpf_valido() {
        funcionario.setCpf("41659541875");
        assertEquals("41659541875", funcionario.getCpf());
    }
    
    @Test
    void deve_aceitar_cpf_valido_randomico() {
        assertEquals(TAMAMNHO_CPF, funcionario.getCpf().length());
    }
    
    @Test
    void nao_deve_aceitar_cpf_espaco_branco() {
        funcionario.setCpf("     ");
        assertEquals(MENSAGEM_ERRO_CPF_VAZIO, getErrorMessage(funcionario, MENSAGEM_ERRO_CPF_VAZIO));
    }

    @Test
    void nao_deve_aceitar_cpf_vazio() {
        funcionario.setCpf("");
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_CPF_VAZIO);
        assertEquals(MENSAGEM_ERRO_CPF_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_letras_cpf() {
        funcionario.setCpf("a");
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_CPF_REGEX);
        assertEquals(MENSAGEM_ERRO_CPF_REGEX, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cpf_diferente_11_digitos() {
        funcionario.setCpf("21312312312312312312313123");
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_CPF_TAMANHO);
        assertEquals(MENSAGEM_ERRO_CPF_TAMANHO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cpf_invalido() {
        funcionario.setCpf("15308179833");
        String errorMessage = getErrorMessage(funcionario, MESSAGEM_ERRO_CPF);
        assertEquals(MESSAGEM_ERRO_CPF, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cpf_numeros_iguais() {
        funcionario.setCpf("11111111111");
        String errorMessage = getErrorMessage(funcionario, MESSAGEM_ERRO_CPF);
        assertEquals(MESSAGEM_ERRO_CPF, errorMessage);
    }

    @Test
    void deve_aceitar_nome_valido() {
        funcionario.setNome("Guilherme Correia");
        assertEquals("Guilherme Correia", funcionario.getNome());
    }

    @Test
    void deve_verificar_nome_valido_randomico() {
        assertTrue(funcionario.getNome().length() >= TAMANHO_MINIMO_NOME && funcionario.getNome().length() <= TAMANHO_MAXIMO_NOME);
    }

    @Test
    void nao_deve_aceitar_nome_nulo() {
        funcionario.setNome(null);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_NOME_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_vazio() {
        funcionario.setNome("");
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_NOME_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_menor_tamanho_minimo() {
        funcionario.setNome("a");
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_NOME, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_maior_tamanho_maximo() {
        funcionario.setNome(NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_NOME_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_TAMANHO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_com_numero() {
        funcionario.setNome("12321");
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_NOME_REGEX);
        assertEquals(MENSAGEM_ERRO_NOME_REGEX, errorMessage);
    }

    @Test
    void deve_aceitar_data_nascimento_valida() {
        LocalDate data = new LocalDate(2000, 3, 1);
        funcionario.setDataNascimento(data);
        assertEquals(data, funcionario.getDataNascimento());
    }

    @Test
    void nao_deve_aceitar_data_nascimento_nulo() {
        funcionario.setDataNascimento(null);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_DATA_NULL);
        assertEquals(MENSAGEM_ERRO_DATA_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_data_nascimento_maior_data_limite() {
        LocalDate data1 = new LocalDate(3200, 3, 1);
        funcionario.setDataNascimento(data1);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_DATA_MINIMA);
        assertEquals(MENSAGEM_ERRO_DATA_MINIMA, errorMessage);
    }
    
    @Test
    void nao_deve_aceitar_funcionario_menor_idade() {
        LocalDate data1 = new LocalDate(2010, 3, 1);
        funcionario.setDataNascimento(data1);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_MENOR_IDADE);
        assertEquals(MENSAGEM_ERRO_MENOR_IDADE, errorMessage);
    }

    @Test
    void deve_aceitar_lista_endereco() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        for(int indice = TAMANHO_LISTA_ENDERECO ; indice != 0 ; indice--) {
            Endereco endereco = new Endereco("04136020", indice, "ap 05");
            enderecos.add(endereco);
        }
        funcionario.setEnderecos(enderecos);
        assertEquals(enderecos, funcionario.getEnderecos());
    }

    @Test
    void nao_deve_aceitar_endereco_nulo() {
        funcionario.setEnderecos(null);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_ENDERECO_NULL);
        assertEquals(MENSAGEM_ERRO_ENDERECO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_vazio() {
        Set<Endereco> enderecoVazio = new HashSet<Endereco>();
        funcionario.setEnderecos(enderecoVazio);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_ENDERECO_VAZIO);
        assertEquals(MENSAGEM_ERRO_ENDERECO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_excedendo_tamanho() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        for(int indice = TAMANHO_LISTA_ENDERECO + 2 ; indice != 0 ; indice--) {
            Endereco endereco = new Endereco("04136030", indice, "ap 05");
            enderecos.add(endereco);
        }
        funcionario.setEnderecos(enderecos);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_ENDERECO_TAMANHO);
        assertEquals(MENSAGEM_ERRO_ENDERECO_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_lista_email() {
        Set<Email> emails = new HashSet<Email>();
        int numero = 0;
        for(int indice = TAMANHO_MINIMO_LISTA ; indice != 0 ; indice--) {
            Email email = new Email(("abc@abc.com" + numero++));
            emails.add(email);
        }
        funcionario.setEmails(emails);
        assertEquals(emails, funcionario.getEmails());
    }

    @Test
    void nao_deve_aceitar_lista_email_nulo() {
        funcionario.setEmails(null);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_EMAIL_NULL);
        assertEquals(MENSAGEM_ERRO_EMAIL_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_email_vazio() {
        Set<Email> emails = new HashSet<Email>();
        funcionario.setEmails(emails);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_EMAIL_VAZIO);
        assertEquals(MENSAGEM_ERRO_EMAIL_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_email_excedendo_maximo() {
        Set<Email> emails = new HashSet<Email>();
        int numero = 0;
        for(int indice = TAMANHO_LISTA_EMAIL + 2 ; indice != 0 ; indice--) {
            Email email = new Email("teste@teste" + numero++);
            emails.add(email);
        }
        funcionario.setEmails(emails);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_EMAIL_TAMANHO);
        assertEquals(MENSAGEM_ERRO_EMAIL_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_lista_telefone() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone telefone = new Telefone("55", "11", "948623933");
        Telefone telefone2 = new Telefone("55", "11", "948623932");
        telefones.add(telefone);
        telefones.add(telefone2);
        funcionario.setTelefones(telefones);
        assertEquals(telefones, funcionario.getTelefones());
    }

    @Test
    void nao_deve_aceitar_lista_telefone_nulo() {
        funcionario.setTelefones(null);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_TELEFONE_NULL);
        assertEquals(MENSAGEM_ERRO_TELEFONE_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_telefone_vazio() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        funcionario.setTelefones(telefones);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_TELEFONE_VAZIO);
        assertEquals(MENSAGEM_ERRO_TELEFONE_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_telefone_excedendo_maximo() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        for(Integer indice = TAMANHO_LISTA_TELEFONE + 2 ; indice != 0 ; indice--) {
            String ddd = indice.toString().length() == 1 ? "0" + indice.toString() : indice.toString();
            Telefone telefone = new Telefone("55", ddd, "948623932");
            telefones.add(telefone);
        }
        funcionario.setTelefones(telefones);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_TELEFONE_TAMANHO);
        assertEquals(MENSAGEM_ERRO_TELEFONE_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_setor_valido() {
        Setor setor = new Setor("Adm");
        funcionario.setSetor(setor);
        assertEquals(setor, funcionario.getSetor());
    }

    @Test
    void nao_deve_aceitar_setor_nulo() {
        funcionario.setSetor(null);
        String errorMessage = getErrorMessage(funcionario, MENSAGEM_ERRO_SETOR_NULL);
        assertEquals(MENSAGEM_ERRO_SETOR_NULL, errorMessage);
    }
    
    @Test
    void deve_aceitar_status_null() {
        funcionario.setStatus(null);
        assertEquals(null, funcionario.getStatus());
    }

    @Test
    void deve_aceitar_status_valido() {
        funcionario.setStatus(true);
        assertEquals(true, funcionario.getStatus());
    }

    @Test
    void deve_comparar_hash_code() {
        Funcionario funcionario2 = new Funcionario("41659541875");
        funcionario.setCpf("41659541875");
        assertEquals(funcionario.hashCode(), funcionario2.hashCode());
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesmo_objeto() {
        assertEquals(funcionario, funcionario);
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesma_instancia() {
        funcionario.setCpf("41659541875");
        Funcionario funcionario2 = new Funcionario("41659541875");
        assertEquals(funcionario, funcionario2);
    }

    @Test
    void deve_retornar_falso_equals_nulo() {
        assertNotEquals(funcionario, (null));
    }

    @Test
    void deve_retornar_falso_equals_classes_diferentes() {
        assertNotEquals(funcionario, new Object());
    }

    @Test
    void deve_retornar_cpf_to_string() {
        funcionario.setCpf("41659541875");
        assertThat(funcionario.toString(), containsString("41659541875"));
    }

    @Test
    void deve_retornar_nome_to_string() {
        funcionario.setNome("Gui");
        assertThat(funcionario.toString(), containsString("Gui"));
    }

    @Test
    void deve_retornar_data_nascimento_to_string() {
        funcionario.setDataNascimento(new LocalDate(2002, 04, 21));
        assertThat(funcionario.toString(), containsString("2002-04-21"));
    }

    @Test
    void deve_retornar_endereco_to_string() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        Endereco endereco = new Endereco("04136030", 772, "casa");
        enderecos.add(endereco);
        funcionario.setEnderecos(enderecos);
        assertThat(funcionario.toString(), containsString("04136030"));
    }

    @Test
    void deve_retornar_email_to_string() {
        Set<Email> emails = new HashSet<Email>();
        Email email = new Email("teste@teste.com");
        Email email2 = new Email("testeee@teste.com");
        emails.add(email);
        emails.add(email2);
        funcionario.setEmails(emails);
        assertThat(funcionario.toString(), containsString("teste@teste.com"));
        assertThat(funcionario.toString(), containsString("testeee@teste.com"));
    }

    @Test
    void deve_retornar_telefone_to_string() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone telefone = new Telefone("55", "11", "912345678");
        Telefone telefone2 = new Telefone("55", "11", "912345444");
        telefones.add(telefone);
        telefones.add(telefone2);
        funcionario.setTelefones(telefones);
        assertThat(funcionario.toString(), containsString("912345678"));
        assertThat(funcionario.toString(), containsString("912345444"));
    }

    @Test
    void deve_retornar_setor_to_string() {
        Setor setor = new Setor("Adm");
        funcionario.setSetor(setor);
        assertThat(funcionario.toString(), containsString("Adm"));
    }
    
    @Test
    void equals_test() {
        simple().forClass(Funcionario.class)
            .withPrefabValues(Funcionario.class, new Funcionario("1"), new Funcionario("2"))
            .suppress(ALL_FIELDS_SHOULD_BE_USED)
            .verify();
    }
}
