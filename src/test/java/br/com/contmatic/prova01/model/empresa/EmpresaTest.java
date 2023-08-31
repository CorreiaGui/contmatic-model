/*
 * 
 */
package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_LIMITE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_REUNIAO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DOMINIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DOMINIO_ESPACO_BRANCO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_RAZAO_SOCIAL_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.NOME_EXCEDEBDI_LIMITE_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_SETOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_NUMERO_INSCRICAO;
import static br.com.contmatic.prova01.model.util.enums.NaturezaJuridica.LTDA;
import static br.com.contmatic.prova01.model.util.enums.SituacaoCadastral.ATIVO;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.contmatic.prova01.model.util.enums.SituacaoCadastral;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

class EmpresaTest {

    private Empresa empresa;

    @BeforeEach
    void set_up() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        empresa = Fixture.from(Empresa.class).gimme("Empresa valida");
    }

    @Test
    void deve_aceitar_cnpj_valido() {
        assertEquals("95324764000149", empresa.getCnpj());
    }

    @Test
    void nao_deve_aceitar_cnpj_digito_verificador_invalido() {
        Empresa empresaInvalida = Fixture.from(Empresa.class).gimme("empresa cnpj invalido");
        assertEquals(MENSAGEM_ERRO_CNPJ, getErrorMessage(empresaInvalida, MENSAGEM_ERRO_CNPJ));
    }
    
    @Test
    void nao_deve_aceitar_cnpj_com_espaco_braco() {
        empresa.setCnpj("");
        assertEquals(MENSAGEM_ERRO_CNPJ_NULL, getErrorMessage(empresa, MENSAGEM_ERRO_CNPJ_NULL));
    }

    @Test
    void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCnpj(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_CNPJ_NULL);
        assertEquals(MENSAGEM_ERRO_CNPJ_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCnpj("");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_CNPJ_VAZIO);
        assertEquals(MENSAGEM_ERRO_CNPJ_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cnpj_letras() {
        empresa.setCnpj("abc");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_CNPJ);
        assertEquals(MENSAGEM_ERRO_CNPJ, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cnpj_caracteres_insuficientes() {
        empresa.setCnpj("12");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_CNPJ);
        assertEquals(MENSAGEM_ERRO_CNPJ, errorMessage);
    }

    @Test
    void deve_aceitar_numero_inscricao() {
        assertEquals(TAMANHO_NUMERO_INSCRICAO, empresa.getNumeroInscricao().length());
    }

    @Test
    void nao_deve_aceitar_numero_inscricao_vazio() {
        empresa.setNumeroInscricao("");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO);
        assertEquals(MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO, errorMessage);
    }
    
    @Test
    void nao_deve_aceitar_numero_inscricao_espaco_branco() {
        empresa.setNumeroInscricao("    ");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO);
        assertEquals(MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_numero_inscricao_letras() {
        empresa.setNumeroInscricao("a");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO);
        assertEquals(MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_numero_inscricao_tamanho_diferente() {
        empresa.setNumeroInscricao("123");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_numero_inscricao_nulo() {
        empresa.setNumeroInscricao(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL);
        assertEquals(MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL, errorMessage);
    }

    @Test
    void deve_aceitar_data_abertura_valida() {
        LocalDate dataAbertura = new LocalDate(2021, 04, 21);
        empresa.setDataAbertura(dataAbertura);
        assertEquals(dataAbertura, empresa.getDataAbertura());
    }

    @Test
    void nao_deve_aceitar_data_abertura_nulo() {
        empresa.setDataAbertura(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_DATA_NULA);
        assertEquals(MENSAGEM_ERRO_DATA_NULA, errorMessage);
    }

    @Test
    void nao_deve_aceitar_data_maior_maximo() {
        LocalDate dataErrada = new LocalDate(2500, 05, 13);
        empresa.setDataAbertura(dataErrada);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_DATA_LIMITE);
        assertEquals(MENSAGEM_ERRO_DATA_LIMITE, errorMessage);
    }
    
    @Test
    void deve_aceitar_data_reuniao_valida() {
        LocalDateTime data = new LocalDateTime(2023, 9, 21, 10, 00, 00);
        empresa.setDataReuniaoGeral(data);
        assertEquals(data, empresa.getDataReuniaoGeral());
    }
    
    @Test
    void nao_deve_aceitar_data_reuniao_passado() {
        empresa.setDataReuniaoGeral(new LocalDateTime(2020, 9, 21, 10, 00, 00));
        assertEquals(MENSAGEM_ERRO_DATA_REUNIAO ,getErrorMessage(empresa, MENSAGEM_ERRO_DATA_REUNIAO));
    }
    
    @Test
    void deve_aceitar_razao_social() {
        empresa.setRazaoSocial("Empresa Teste LDTA");
        assertEquals("Empresa Teste LDTA", empresa.getRazaoSocial());
    }
    
    @Test
    void deve_aceitar_razao_social_regex_errada() {
        empresa.setRazaoSocial("!@#!@#!");
        assertEquals(MENSAGEM_ERRO_REGEX, getErrorMessage(empresa, MENSAGEM_ERRO_REGEX));
    }

    @Test
    void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_RAZAO_SOCIAL_NULA);
        assertEquals(MENSAGEM_ERRO_RAZAO_SOCIAL_NULA, errorMessage);
    }

    @Test
    void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_RAZAO_SOCIAL_NULA);
        assertEquals(MENSAGEM_ERRO_RAZAO_SOCIAL_NULA, errorMessage);
    }

    @Test
    void nao_deve_aceitar_razao_social_caracteres_insuficientes() {
        empresa.setRazaoSocial("a");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_razao_social_caracteres_maximo() {
        empresa.setRazaoSocial(NOME_EXCEDEBDI_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MAXIMO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MAXIMO, errorMessage);
    }

    @Test
    void deve_aceitar_nome_fantasia() {
        empresa.setNomeFantasia("Guilherme Tech");
        assertEquals("Guilherme Tech", empresa.getNomeFantasia());
    }
    
    @Test
    void deve_aceitar_nome_fantasia_regex_errada() {
        empresa.setNomeFantasia("!@#!@#!");
        assertEquals(MENSAGEM_ERRO_REGEX, getErrorMessage(empresa, MENSAGEM_ERRO_REGEX));
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_NOME_FANTASIA_NULA);
        assertEquals(MENSAGEM_ERRO_NOME_FANTASIA_NULA, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_NOME_FANTASIA_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_FANTASIA_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_caracteres_insuficientes() {
        empresa.setNomeFantasia("a");
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_fantasia_caracteres_maximo() {
        empresa.setNomeFantasia(NOME_EXCEDEBDI_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MAXIMO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MAXIMO, errorMessage);
    }

    @Test
    void deve_aceitar_natureza_juridica() {
        empresa.setNaturezaJuridica(LTDA);
        assertEquals(LTDA, empresa.getNaturezaJuridica());
    }

    @Test
    void nao_deve_aceitar_nome_natureza_juridica_nulo() {
        empresa.setNaturezaJuridica(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL);
        assertEquals(MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL, errorMessage);
    }

    @Test
    void deve_aceitar_situacao_cadastral() {
        empresa.setSituacaoCadastral(ATIVO);
        assertEquals(SituacaoCadastral.valueOf("ATIVO"), empresa.getSituacaoCadastral());
    }

    @Test
    void nao_deve_aceitar_situacao_cadastral_nulo() {
        empresa.setSituacaoCadastral(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL);
        assertEquals(MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL, errorMessage);
    }

    @Test
    void deve_aceitar_lista_endereco() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        for(int indice = TAMANHO_MAXIMO_LISTA_ENDERECO ; indice != 0 ; indice--) {
            Endereco endereco = new Endereco("04136020", indice, "ap 05");
            enderecos.add(endereco);
        }
        empresa.setEnderecos(enderecos);
        assertEquals(enderecos, empresa.getEnderecos());
    }

    @Test
    void nao_deve_aceitar_endereco_nulo() {
        empresa.setEnderecos(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_ENDERECO_NULL);
        assertEquals(MENSAGEM_ERRO_ENDERECO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_vazio() {
        Set<Endereco> enderecoVazio = new HashSet<Endereco>();
        empresa.setEnderecos(enderecoVazio);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_ENDERECO_VAZIO);
        assertEquals(MENSAGEM_ERRO_ENDERECO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_endereco_excedendo_tamanho() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        IntStream.range(TAMANHO_MINIMO_LISTA_ENDERECO, TAMANHO_MAXIMO_LISTA_ENDERECO + 2).forEach(indice -> enderecos.add(new Endereco("04136030", indice, "ap 04")));
        empresa.setEnderecos(enderecos);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_ENDERECO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_ENDERECO, errorMessage);

    }

    @Test
    void deve_aceitar_lista_funcionario() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario("41659541875");
        funcionarios.add(funcionario);
        empresa.setFuncionarios(funcionarios);
        assertEquals(funcionarios, empresa.getFuncionarios());
    }

    @Test
    void nao_deve_aceitar_lista_funcionario_nulo() {
        empresa.setFuncionarios(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_FUNCIONARIO_NULL);
        assertEquals(MENSAGEM_ERRO_FUNCIONARIO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_funcionario_vazio() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        empresa.setFuncionarios(funcionarios);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_FUNCIONARIO_VAZIO);
        assertEquals(MENSAGEM_ERRO_FUNCIONARIO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_funcionario_menor_minimo() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = new Funcionario("41659541875");
        funcionarios.add(funcionario);
        empresa.setFuncionarios(funcionarios);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA, errorMessage);
    }

    @Test
    void nao_deve_aceita_lista_funcionario_excedendo_tamanho_maximo() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        for(int indice = TAMANHO_MAXIMO_LISTA_FUNCIONARIO + 3 ; indice != 0 ; indice--) {
            funcionarios.add(null);
        }
        empresa.setFuncionarios(funcionarios);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_FUNCIONARIO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_FUNCIONARIO, errorMessage);
    }

    @Test
    void deve_aceitar_lista_produtos() {
        Set<Produto> produtos = new HashSet<Produto>();
        for(int indice = TAMANHO_MINIMO_LISTA ; indice != 0 ; indice--) {
            Produto produto = new Produto("Bola", indice + 1);
            produtos.add(produto);
        }
        empresa.setProdutos(produtos);
        assertEquals(produtos, empresa.getProdutos());
    }

    @Test
    void nao_deve_aceitar_produto_nulo() {
        empresa.setProdutos(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_PRODUTO_NULL);
        assertEquals(MENSAGEM_ERRO_PRODUTO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_produto_vazio() {
        Set<Produto> produtoVazio = new HashSet<Produto>();
        empresa.setProdutos(produtoVazio);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_PRODUTO_VAZIO);
        assertEquals(MENSAGEM_ERRO_PRODUTO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_produto_menor_minimo() {
        Set<Produto> produtos = new HashSet<Produto>();
        Produto produto = new Produto("Bola", 1);
        produtos.add(produto);
        empresa.setProdutos(produtos);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_produto_excedendo_tamanho_maximo() {
        Set<Produto> produtos = new HashSet<>();
        int numero = 1;
        for(int indice = TAMANHO_MAXIMO_LISTA_PRODUTO + 2 ; indice != 0 ; indice--) {
            Produto produto = new Produto("bola", numero++);
            produtos.add(produto);
        }
        empresa.setProdutos(produtos);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_PRODUTO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_PRODUTO, errorMessage);
    }

    @Test
    void deve_aceitar_lista_email() {
        Set<Email> emails = new HashSet<Email>();
        int numero = 0;
        for(int indice = TAMANHO_MINIMO_LISTA ; indice != 0 ; indice--) {
            Email email = new Email(("abc@abc.com" + numero++));
            emails.add(email);
        }
        empresa.setEmails(emails);
        assertEquals(emails, empresa.getEmails());
    }

    @Test
    void nao_deve_aceitar_lista_email_nulo() {
        empresa.setEmails(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_EMAIL_NULL);
        assertEquals(MENSAGEM_ERRO_EMAIL_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_email_vazio() {
        Set<Email> emails = new HashSet<>();
        empresa.setEmails(emails);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_EMAIL_VAZIO);
        assertEquals(MENSAGEM_ERRO_EMAIL_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_email_menor_minimo() {
        Set<Email> emails = new HashSet<Email>();
        Email email = new Email("teste@teste");
        emails.add(email);
        empresa.setEmails(emails);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_email_excedendo_maximo() {
        Set<Email> emails = new HashSet<Email>();
        String a = "a";
        for(int indice = TAMANHO_MAXIMO_LISTA_EMAIL + 2 ; indice != 0 ; indice--) {
            Email emailss = new Email("teste".concat(a += "a"));
            emails.add(emailss);
        }
        empresa.setEmails(emails);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL, errorMessage);
    }

    @Test
    void deve_aceitar_lista_telefone() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone telefone = new Telefone("55", "11", "948623933");
        Telefone telefone2 = new Telefone("55", "11", "948623932");
        telefones.add(telefone);
        telefones.add(telefone2);
        empresa.setTelefones(telefones);
        assertEquals(telefones, empresa.getTelefones());
    }

    @Test
    void nao_deve_aceitar_lista_telefone_nulo() {
        empresa.setTelefones(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TELEFONE_NULL);
        assertEquals(MENSAGEM_ERRO_TELEFONE_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_telefone_vazio() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        empresa.setTelefones(telefones);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TELEFONE_VAZIO);
        assertEquals(MENSAGEM_ERRO_TELEFONE_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_telefone_menor_minimo() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone telefone = new Telefone("55", "11", "948623932");
        telefones.add(telefone);
        empresa.setTelefones(telefones);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN);
        assertEquals(MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN, errorMessage);
    }

    @Test
    void nao_deve_aceitar_lista_telefone_excedendo_maximo() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        for(Integer indice = TAMANHO_MAXIMO_LISTA_TELEFONE + 2 ; indice != 0 ; indice--) {
            String ddd = indice.toString().length() == 1 ? "0" + indice.toString() : indice.toString();
            Telefone telefone = new Telefone("55", ddd, "948623932");
            telefones.add(telefone);
        }
        empresa.setTelefones(telefones);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO);
        assertEquals(MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO, errorMessage);
    }

    @Test
    void deve_aceitar_setor_valido() {
        Set<Setor> setores = new HashSet<Setor>();
        Setor setor1 = new Setor("Administrativo");
        Setor setor2 = new Setor("Comercial");
        setores.add(setor2);
        setores.add(setor1);
        empresa.setSetores(setores);
        assertEquals(setores, empresa.getSetores());
    }

    @Test
    void nao_deve_aceitar_setor_nulo() {
        empresa.setSetores(null);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_SETOR_NULL);
        assertEquals(MENSAGEM_ERRO_SETOR_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_setor_lista_vazia() {
        Set<Setor> setores = new HashSet<Setor>();
        empresa.setSetores(setores);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_SETOR_VAZIO);
        assertEquals(MENSAGEM_ERRO_SETOR_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_setor_lista_menor_minimo() {
        Set<Setor> setores = new HashSet<Setor>();
        Setor setor = new Setor("teste");
        setores.add(setor);
        empresa.setSetores(setores);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_setor_lista_excedendo_tamanho_maximo() {
        Set<Setor> setores = new HashSet<Setor>();
        String stringInicial = "Nome";
        for(int indice = TAMANHO_MAXIMO_LISTA_SETOR + 2 ; indice != 0 ; indice--) {
            Setor setor = new Setor(stringInicial += "a");
            setores.add(setor);
        }
        empresa.setSetores(setores);
        String errorMessage = getErrorMessage(empresa, MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO);
        assertEquals(MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO, errorMessage);
    }
    
    @Test
    void deve_aceitar_dominio_valido() {
        empresa.setDominio("https://empresa.com.br");
        assertEquals("https://empresa.com.br", empresa.getDominio());
    }
    
    @Test
    void nao_deve_aceitar_dominio_invalido() {
        empresa.setDominio("teste");
        assertEquals(MENSAGEM_ERRO_DOMINIO, getErrorMessage(empresa, MENSAGEM_ERRO_DOMINIO));
    }
    
    @Test
    void nao_deve_aceitar_dominio_espaco_branco() {
        empresa.setDominio("     ");
        assertEquals(MENSAGEM_ERRO_DOMINIO_ESPACO_BRANCO, getErrorMessage(empresa, MENSAGEM_ERRO_DOMINIO_ESPACO_BRANCO));
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesma_valor() {
        Empresa empresa2 = Fixture.from(Empresa.class).gimme("Empresa valida");
        assertEquals(empresa, empresa2);
    }

    @Test
    void deve_retornar_falso_para_equals_comparado_com_nulo() {
        assertNotEquals(empresa, (null));
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesmo_objeto() {
        assertEquals(empresa, empresa);
    }

    @Test
    void deve_retornar_falso_equals_diferentes_classes() {
        assertNotEquals(empresa, new Object());
    }

    @Test
    void deve_conter_mesmo_valor_hash_code() {
        Empresa empresa2 = new Empresa("95324764000149");
        assertEquals(empresa.hashCode(), empresa2.hashCode());
    }

    @Test
    void deve_retornar_cnpj_to_string() {
        assertThat(empresa.toString(), containsString("95324764000149"));
    }

    @Test
    void deve_retornar_numero_inscricao_to_string() {
        empresa.setNumeroInscricao("123456789");
        assertThat(empresa.toString(), containsString("123456789"));
    }

    @Test
    void deve_retornar_razao_social_to_string() {
        empresa.setRazaoSocial("Empresa Teste");
        assertThat(empresa.toString(), containsString("Empresa Teste"));
    }

    @Test
    void deve_retornar_nome_fantasia_to_string() {
        empresa.setRazaoSocial("Empresa Teste!!!");
        assertThat(empresa.toString(), containsString("Empresa Teste!!!"));
    }

    @Test
    void deve_retornar_natureza_juridica_to_string() {
        empresa.setRazaoSocial("LTDA");
        assertThat(empresa.toString(), containsString("LTDA"));
    }

    @Test
    void deve_retornar_situacao_cdastral_to_string() {
        empresa.setRazaoSocial("ATIVA");
        assertThat(empresa.toString(), containsString("ATIVA"));
    }

    @Test
    void deve_retornar_data_abertura_to_string() {
        LocalDate data = new LocalDate(2023, 04, 04);
        empresa.setDataAbertura(data);
        assertThat(empresa.toString(), containsString("2023-04-04"));
    }

    @Test
    void deve_retornar_endereco_to_string() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        Endereco endereco = new Endereco("04136030", 772, "casa");
        enderecos.add(endereco);
        empresa.setEnderecos(enderecos);
        assertThat(empresa.toString(), containsString("04136030"));
    }

    @Test
    void deve_retornar_funcionario_to_string() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario1 = new Funcionario("41659541875");
        Funcionario funcionario2 = new Funcionario("15308679835");
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario1);
        empresa.setFuncionarios(funcionarios);
        assertThat(empresa.toString(), containsString("41659541875"));
        assertThat(empresa.toString(), containsString("15308679835"));
    }

    @Test
    void deve_retornar_produto_to_string() {
        Set<Produto> produtos = new HashSet<Produto>();
        Produto produto = new Produto("bola", 3);
        Produto produto2 = new Produto("boné", 1);
        produtos.add(produto);
        produtos.add(produto2);
        empresa.setProdutos(produtos);
        assertThat(empresa.toString(), containsString("bola"));
        assertThat(empresa.toString(), containsString("boné"));
    }

    @Test
    void deve_retornar_email_to_string() {
        Set<Email> emails = new HashSet<Email>();
        Email email = new Email("teste@teste.com");
        Email email2 = new Email("testeee@teste.com");
        emails.add(email);
        emails.add(email2);
        empresa.setEmails(emails);
        assertThat(empresa.toString(), containsString("teste@teste.com"));
        assertThat(empresa.toString(), containsString("testeee@teste.com"));
    }

    @Test
    void deve_retornar_telefone_to_string() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone telefone = new Telefone("55", "11", "912345678");
        Telefone telefone2 = new Telefone("55", "11", "912345444");
        telefones.add(telefone);
        telefones.add(telefone2);
        empresa.setTelefones(telefones);
        assertThat(empresa.toString(), containsString("912345678"));
        assertThat(empresa.toString(), containsString("912345444"));
    }

    @Test
    void deve_retornar_setor_to_string() {
        Set<Setor> setores = new HashSet<Setor>();
        Setor setor = new Setor("adm");
        Setor setor2 = new Setor("informatica");
        setores.add(setor);
        setores.add(setor2);
        empresa.setSetores(setores);
        assertThat(empresa.toString(), containsString("adm"));
        assertThat(empresa.toString(), containsString("informatica"));
    }
    
    @Test
    void test_equals() {
        EqualsVerifier.simple().forClass(Empresa.class).withPrefabValues(Funcionario.class, 
            new Funcionario("1"), new Funcionario("2")).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
