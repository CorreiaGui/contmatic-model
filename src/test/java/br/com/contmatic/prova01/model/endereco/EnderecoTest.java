package br.com.contmatic.prova01.model.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {

	Endereco endereco;

	@BeforeEach
	void set_up() {
		endereco = new Endereco("04136030", 772, "casa");
	}

	@Test
	void deve_aceitar_cep_valido() {
		endereco.setCep("04136030");
		assertEquals("04136030", endereco.getCep());
	}

	@Test
	void nao_deve_aceitar_cep_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco.setCep(null));
		assertTrue(thrown.getMessage().contains("O campo CEP é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_cep_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco.setCep(""));
		assertTrue(thrown.getMessage().contains("O campo CEP com espaço em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_cep_diferente_8_digitos() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("1234567"));
		assertTrue(thrown.getMessage().contains("O campo CEP diferente de oito caracteres é inválido."));
	}

	@Test
	void nao_deve_aceitar_cep_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco.setCep("1acsa"));
		assertTrue(thrown.getMessage().contains("O campo CEP não permite letras, apenas números."));
	}

	@Test
	void deve_aceitar_logradouro_valido() {
		endereco.setLogradouro("Rua Guararema");
		assertEquals("Rua Guararema", endereco.getLogradouro());
	}

	@Test
	void nao_deve_aceitar_logradouro_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(null));
		assertTrue(thrown.getMessage().contains("O campo logradouro é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_logradouro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(""));
		assertTrue(thrown.getMessage().contains("O campo logradouro com apenas espaços em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_logradouro_menor_tamanho_minimo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("as"));
		assertTrue(thrown.getMessage().contains("O campo logradouro necessita de pelo três um caracteres."));
	}

	@Test
	void nao_deve_aceitar_logradouro_maior_tamanho_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco
				.setLogradouro("testetestetestetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo logradouro excedeu o limite de caracteres."));
	}

	@Test
	void deve_aceitar_numero_valido() {
		endereco.setNumero(772);
		assertEquals(772, endereco.getNumero());
	}

	@Test
	void nao_deve_aceitar_numero_maior_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco.setNumero(null));
		assertTrue(thrown.getMessage().contains("O campo Número é de preenchimento obrigatório"));
	}

	@Test
	void nao_deve_aceitar_numero_menor_tamanho_minimo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco.setNumero(0));
		assertTrue(thrown.getMessage().contains("O número do endereço menor que um é inválido"));
	}

	@Test
	void nao_deve_aceitar_numero_maior_tamanho_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero(100001));
		assertTrue(thrown.getMessage().contains("O número do endereço maior que 100000 é inválido"));
	}

	@Test
	void deve_aceitar_complemento_valido() {
		endereco.setComplemento("Apto 05");
		assertEquals("Apto 05", endereco.getComplemento());
	}

	@Test
	void nao_deve_aceitar_complemento_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setComplemento(null));
		assertTrue(thrown.getMessage().contains("O campo complemento é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_complemento_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setComplemento("  "));
		assertTrue(thrown.getMessage().contains("O campo com espaços em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_complemento_menor_caracteres_necessarios() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setComplemento("a"));
		assertTrue(thrown.getMessage().contains("O campo complemento com menos de três caracteres é inválido."));
	}

	@Test
	void nao_deve_aceitar_complemento_excedendo_caracteres_permitidos() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setComplemento("testetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo complemento excedeu a quantidade de caracteres permitidos."));
	}

	@Test
	void deve_aceitar_cidade_valida() {
		Estado estado = new Estado("SP");
		Cidade cidade = new Cidade("São Paulo", estado);
		endereco.setCidade(cidade);
		assertEquals(cidade, endereco.getCidade());
	}

	@Test
	void nao_deve_aceitar_cidade_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> endereco.setCidade(null));
		assertTrue(thrown.getMessage().contains("O campo cidade é de preenchimento obrigatório."));
	}

	@Test
	void deve_retornar_mesmo_hash_code() {
		Endereco endereco2 = new Endereco("04136030", 772, "casa");
		assertEquals(endereco.hashCode(), endereco2.hashCode());
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
		assertEquals(endereco, endereco2);
	}

	@Test
	void deve_retornar_falso_equals_instancias_diferentes() {
		Endereco endereco2 = new Endereco("04136030", 830, "casa");
		assertNotEquals(endereco, endereco2);
	}

	@Test
	void deve_retornar_cep_to_string() {
		assertThat(endereco.toString(), containsString("cep=04136030"));
	}

	@Test
	void deve_retornar_numero_to_string() {
		assertThat(endereco.toString(), containsString("numero=772"));
	}

	@Test
	void deve_retornar_complemento_to_string() {
		assertThat(endereco.toString(), containsString("complemento=casa"));
	}

	@Test
	void deve_retornar_logradouro_to_string() {
		endereco.setLogradouro("Rua da Mooca");
		assertThat(endereco.toString(), containsString("logradouro=Rua da Mooca"));
	}

	@Test
	void deve_retornar_cidade_to_string() {
		Estado estado = new Estado("SP");
		Cidade cidade = new Cidade("São Paulo", estado);
		endereco.setCidade(cidade);
		assertThat(endereco.toString(), containsString("nome=São Paulo"));
	}
}
