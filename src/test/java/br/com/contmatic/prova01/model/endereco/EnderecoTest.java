package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CIDADE_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant;
import br.com.contmatic.prova01.model.util.enums.SiglaEstado;
import br.com.six2six.fixturefactory.Fixture;

class EnderecoTest {

    Endereco endereco;

    @BeforeEach
    void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        endereco = Fixture.from(Endereco.class).gimme("Endereco valido");
    }

    @Test
    void deve_aceitar_cep_valido() {
        endereco.setCep("04136030");
        assertEquals("04136030", endereco.getCep());
    }

    @Test
    void nao_deve_aceitar_cep_nulo() {
        endereco.setCep(null);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_CEP_NULL);
        assertEquals(MENSAGEM_ERRO_CEP_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cep_vazio() {
        endereco.setCep("");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_CEP_VAZIO);
        assertEquals(MENSAGEM_ERRO_CEP_VAZIO, errorMessage);
    }
    
    void nao_deve_aceitar_cep_espaco_branco() {
        endereco.setCep("    ");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_CEP_VAZIO);
        assertEquals(MENSAGEM_ERRO_CEP_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cep_diferente_8_digitos() {
        endereco.setCep("123");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_CEP_TAMANHO);
        assertEquals(MENSAGEM_ERRO_CEP_TAMANHO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_cep_com_letras() {
        endereco.setCep("a");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_CEP_REGEX);
        assertEquals(MENSAGEM_ERRO_CEP_REGEX, errorMessage);
    }

    @Test
    void deve_aceitar_logradouro_valido() {
        endereco.setLogradouro("Rua Guararema");
        assertEquals("Rua Guararema", endereco.getLogradouro());
    }

    @Test
    void nao_deve_aceitar_logradouro_nulo() {
        endereco.setLogradouro(null);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_LOGRADOURO_NULL);
        assertEquals(MENSAGEM_ERRO_LOGRADOURO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_logradouro_vazio() {
        endereco.setLogradouro("");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_LOGRADOURO_VAZIO);
        assertEquals(MENSAGEM_ERRO_LOGRADOURO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_logradouro_menor_tamanho_minimo() {
        endereco.setLogradouro("a");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO);
        assertEquals(MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_logradouro_maior_tamanho_maximo() {
        endereco.setLogradouro(EnderecoConstant.NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_LOGRADOURO_TAMANHO);
        assertEquals(MENSAGEM_ERRO_LOGRADOURO_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_numero_valido() {
        endereco.setNumero(772);
        assertEquals(772, endereco.getNumero());
    }

    @Test
    void nao_deve_aceitar_numero_nulo() {
        endereco.setNumero(null);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_NUMERO_NULL);
        assertEquals(MENSAGEM_ERRO_NUMERO_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_numero_menor_tamanho_minimo() {
        endereco.setNumero(0);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_NUMERO_MINIMO);
        assertEquals(MENSAGEM_ERRO_NUMERO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_numero_maior_tamanho_maximo() {
        endereco.setNumero(10000000);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_NUMERO_MAXIMO);
        assertEquals(MENSAGEM_ERRO_NUMERO_MAXIMO, errorMessage);
    }

    @Test
    void deve_aceitar_complemento_valido() {
        endereco.setComplemento("Apto 05");
        assertEquals("Apto 05", endereco.getComplemento());
    }

    @Test
    void nao_deve_aceitar_complemento_vazio() {
        endereco.setComplemento("");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_COMPLEMENTO_VAZIO);
        assertEquals(MENSAGEM_ERRO_COMPLEMENTO_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_complemento_caracteres_menor_necessario() {
        endereco.setComplemento("a");
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_complemento_excedendo_caracteres_permitidos() {
        endereco.setComplemento(EnderecoConstant.NOME_EXCEDENDO_LIMITE_CARACTERES);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_COMPLEMENTO_TAMANHO);
        assertEquals(MENSAGEM_ERRO_COMPLEMENTO_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_cidade_valida() {
        Estado estado = new Estado(SiglaEstado.valueOf("SP"));
        Cidade cidade = new Cidade("São Paulo", estado);
        endereco.setCidade(cidade);
        assertEquals(cidade, endereco.getCidade());
    }

    @Test
    void nao_deve_aceitar_cidade_nulo() {
        endereco.setCidade(null);
        String errorMessage = getErrorMessage(endereco, MENSAGEM_ERRO_CIDADE_NULL);
        assertEquals(MENSAGEM_ERRO_CIDADE_NULL, errorMessage);
    }

    @Test
    void deve_retornar_mesmo_hash_code() {
        Endereco endereco2 = new Endereco("04136030", 772, "casa");
        Endereco endereco3 = new Endereco("04136030", 772, "casa");
        assertEquals(endereco3.hashCode(), endereco2.hashCode());
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesmo_objeto() {
        assertEquals(endereco, endereco);
    }

    @Test
    void deve_retornar_falso_equals_objeto_nulo() {
        assertNotEquals(endereco, (null));
    }

    @Test
    void deve_retornar_falso_equals_classes_diferentes() {
        assertNotEquals(endereco, new Object());
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesma_instancia() {
        Endereco endereco2 = new Endereco("04136030", 772, "casa");
        Endereco endereco3 = new Endereco("04136030", 772, "casa");
        assertEquals(endereco3, endereco2);
    }

    @Test
    void deve_retornar_falso_equals_instancias_diferentes() {
        Endereco endereco2 = new Endereco("04136030", 830, "casa");
        assertNotEquals(endereco, endereco2);
    }

    @Test
    void deve_retornar_cep_to_string() {
        Endereco endereco = new Endereco("04136030", 772, "casa");
        assertThat(endereco.toString(), containsString("04136030"));
    }

    @Test
    void deve_retornar_numero_to_string() {
        Endereco endereco = new Endereco("12345678", 772, "casa");
        assertThat(endereco.toString(), containsString("772"));
    }

    @Test
    void deve_retornar_complemento_to_string() {
        assertThat(endereco.toString(), containsString("casa"));
    }

    @Test
    void deve_retornar_logradouro_to_string() {
        endereco.setLogradouro("Rua da Mooca");
        assertThat(endereco.toString(), containsString("Rua da Mooca"));
    }

    @Test
    void deve_retornar_cidade_to_string() {
        Estado estado = new Estado(SiglaEstado.valueOf("SP"));
        Cidade cidade = new Cidade("São Paulo", estado);
        endereco.setCidade(cidade);
        assertThat(endereco.toString(), containsString("São Paulo"));
    }
    
    @Test
    void equals_test() {
        simple().forClass(Endereco.class).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
