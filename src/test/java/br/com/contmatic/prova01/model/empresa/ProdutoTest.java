package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.TesteUtil.getErrorMessage;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_CODIGO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_VALOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_VALOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.NOME_EXCEDENDO_CARACTERES;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.TAMANHO_NOME;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static nl.jqno.equalsverifier.EqualsVerifier.simple;
import static nl.jqno.equalsverifier.Warning.ALL_FIELDS_SHOULD_BE_USED;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.six2six.fixturefactory.Fixture;

class ProdutoTest {

    Produto produto;

    @BeforeEach
    void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
        produto = Fixture.from(Produto.class).gimme("Produto valido");
    }

    @Test
    void deve_aceitar_nome_produto_valido() {
        assertTrue(produto.getNome().length() >= TAMANHO_MINIMO_NOME && produto.getNome().length() <= TAMANHO_NOME);
    }

    @Test
    void nao_deve_aceitar_nome_produto_nulo() {
        produto.setNome(null);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_NOME_NULL);
        assertEquals(MENSAGEM_ERRO_NOME_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_produto_vazio() {
        produto.setNome("");
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_NOME_VAZIO);
        assertEquals(MENSAGEM_ERRO_NOME_VAZIO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_produto_numeros() {
        produto.setNome("1");
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_NOME_REGEX);
        assertEquals(MENSAGEM_ERRO_NOME_REGEX, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_produto_menor_tamanho_minimo() {
        produto.setNome("a");
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_NOME_TAMANHO_MINIMO);
        assertEquals(MENSAGEM_ERRO_NOME_TAMANHO_MINIMO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_nome_produto_maior_tamanho_maximo() {
        produto.setNome(NOME_EXCEDENDO_CARACTERES);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_NOME_TAMANHO);
        assertEquals(MENSAGEM_ERRO_NOME_TAMANHO, errorMessage);
    }

    @Test
    void deve_aceitar_valor_valido() {
        BigDecimal valor = BigDecimal.valueOf(10.90);
        produto.setValor(valor);
        assertEquals(valor, produto.getValor());
    }

    @Test
    void nao_deve_aceitar_valor_nulo() {
        produto.setValor(null);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_VALOR_NULL);
        assertEquals(MENSAGEM_ERRO_VALOR_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_valor_negativo() {
        produto.setValor(BigDecimal.valueOf(-1.0));
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_VALOR);
        assertEquals(MENSAGEM_ERRO_VALOR, errorMessage);
    }

    @Test
    void nao_deve_aceitar_valor_maior_maximo() {
        BigDecimal valor = BigDecimal.valueOf(10000000.0);
        produto.setValor(valor);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_VALOR);
        assertEquals(MENSAGEM_ERRO_VALOR, errorMessage);
    }

    @Test
    void deve_aceitar_codigo_valido() {
        produto.setCodigo(2);
        assertEquals(2, produto.getCodigo());
    }

    @Test
    void nao_deve_aceitar_codigo_nulo() {
        produto.setCodigo(null);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_VALOR_NULL);
        assertEquals(MENSAGEM_ERRO_VALOR_NULL, errorMessage);
    }

    @Test
    void nao_deve_aceitar_codigo_neativo() {
        produto.setCodigo(-1);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_CODIGO);
        assertEquals(MENSAGEM_ERRO_CODIGO, errorMessage);
    }

    @Test
    void nao_deve_aceitar_codigo_maior_maximo() {
        produto.setCodigo(1000000);
        String errorMessage = getErrorMessage(produto, MENSAGEM_ERRO_CODIGO);
        assertEquals(MENSAGEM_ERRO_CODIGO, errorMessage);
    }

    @Test
    void deve_comparar_hash_code() {
        Produto prod = new Produto("camisa", 1);
        Produto prod2 = new Produto("camisa", 1);
        assertEquals(prod.hashCode(), prod2.hashCode());
    }

    @Test
    void deve_retornar_verdadeir_equals_mesma_instancia() {
        Produto produto2 = new Produto("camisa", 1);
        Produto produto3 = new Produto("camisa", 1);
        assertEquals(produto3, produto2);
    }

    @Test
    void deve_retornar_falso_equals_nulo() {
        assertNotEquals(produto, (null));
    }

    @Test
    void deve_retornar_verdadeiro_equals_mesmo_objeto() {
        assertEquals(produto, produto);
    }

    @Test
    void deve_retornar_falso_equals_classes_diferentes() {
        assertNotEquals(produto, new Object());
    }

    @Test
    void deve_retornar_nome_to_string() {
        produto.setNome("camisa");
        assertThat(produto.toString(), containsString("camisa"));
    }

    @Test
    void deve_retornar_codigo_to_string() {
        produto.setCodigo(1);
        assertThat(produto.toString(), containsString("1"));
    }

    @Test
    void deve_retornar_valor_to_string() {
        produto.setValor(BigDecimal.valueOf(19.90));
        assertThat(produto.toString(), containsString("19.9"));
    }
    
    @Test
    void equals_test() {
        simple().forClass(Produto.class).suppress(ALL_FIELDS_SHOULD_BE_USED).verify();
    }
}
