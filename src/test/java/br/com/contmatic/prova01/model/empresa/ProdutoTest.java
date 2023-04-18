package br.com.contmatic.prova01.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	Produto produto;

	@BeforeEach
	void set_up() {
		produto = new Produto("Camisa", 1);
	}

	@Test
	void deve_aceitar_nome_produto_valido() {
		assertEquals("Camisa", produto.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_produto_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setNome(null));
		assertTrue(thrown.getMessage().contains("O campo nome do produto é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_produto_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setNome(""));
		assertTrue(thrown.getMessage().contains("O campo nome do produto não permite espaço em branco."));
	}

	@Test
	void nao_deve_aceitar_nome_produto_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setNome("123"));
		assertTrue(thrown.getMessage().contains("O campo nome do produto com números é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_produto_menor_tamanho_minimo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setNome("a"));
		assertTrue(thrown.getMessage().contains("O campo nome do produto com menos de dois caractere é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_produto_maior_tamanho_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> produto.setNome("testetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo nome do produto excedeu o limite de caracteres"));
	}

	@Test
	void deve_aceitar_valor_valido() {
		BigDecimal valor = BigDecimal.valueOf(10.90);
		produto.setValor(valor);
		assertEquals(valor, produto.getValor());
	}

	@Test
	void nao_deve_aceitar_valor_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setValor(null));
		assertTrue(thrown.getMessage().contains("O campo valor do produto é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_valor_negativo() {
		BigDecimal valorNegativo = BigDecimal.valueOf(-1.0);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> produto.setValor(valorNegativo));
		assertTrue(thrown.getMessage().contains("O valor inserido para o produto é inválido"));
	}

	@Test
	void nao_deve_aceitar_valor_maior_maximo() {
		BigDecimal valor = BigDecimal.valueOf(10000000.0);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setValor(valor));
		assertTrue(thrown.getMessage().contains("O valor inserido para o produto é inválido"));
	}

	@Test
	void deve_aceitar_codigo_valido() {
		produto.setCodigo(2);
		assertEquals(2, produto.getCodigo());
	}

	@Test
	void nao_deve_aceitar_codigo_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setCodigo(null));
		assertTrue(thrown.getMessage().contains("O campo código do produto é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_codigo_neativo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setCodigo(-1));
		assertTrue(thrown.getMessage().contains("O código do produto é inválido"));
	}

	@Test
	void nao_deve_aceitar_codigo_maior_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> produto.setCodigo(1001));
		assertTrue(thrown.getMessage().contains("O código do produto é inválido"));
	}

	@Test
	void deve_comparar_hash_code() {
		Produto produto2 = new Produto("Camisa", 1);
		assertEquals(produto.hashCode(), produto2.hashCode());
	}

	@Test
	void deve_retornar_verdadeir_equals_mesma_instancia() {
		Produto produto2 = new Produto("Camisa", 1);
		assertEquals(produto, produto2);
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
		assertThat(produto.toString(), containsString("nome=Camisa"));
	}

	@Test
	void deve_retornar_codigo_to_string() {
		assertThat(produto.toString(), containsString("codigo=1"));
	}

	@Test
	void deve_retornar_valor_to_string() {
		produto.setValor(BigDecimal.valueOf(19.90));
		assertThat(produto.toString(), containsString("valor=19.9"));
	}
}
