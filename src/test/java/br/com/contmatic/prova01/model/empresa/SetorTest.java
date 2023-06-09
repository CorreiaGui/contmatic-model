package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_LISTA_FUNCIONARIO;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetorTest {

	Setor setor;

	@BeforeEach
	void set_up() {
		setor = new Setor("Adm");
	}

	@Test
	void deve_aceitar_nome_valido() {
		assertEquals("Adm", setor.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> setor.setNome(null));
		assertTrue(thrown.getMessage().contains("O campo nome do setor é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> setor.setNome(""));
		assertTrue(thrown.getMessage().contains("O campo nome do setor com espaço em branco é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_menor_tamanho_minimo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> setor.setNome("ad"));
		assertTrue(thrown.getMessage().contains("O campo nome do setor com menos de dois caracteres é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_maior_tamanho_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> setor.setNome("testetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo nome do setor excedeu o limite de caracteres"));
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
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> setor.setFuncionarios(null));
		assertTrue(thrown.getMessage().contains("O campo funcionarios do setor é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_funcionarios_vazio() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> setor.setFuncionarios(funcionarios));
		assertTrue(thrown.getMessage().contains("O campo funcionarios do setor é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_funcionarios_excedendo_tamanho_maximo() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for (Integer indice = TAMANHO_LISTA_FUNCIONARIO + 2; indice != 0; indice--) {
			Funcionario funcionario = new Funcionario("41659541875");
			funcionarios.add(funcionario);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> setor.setFuncionarios(funcionarios));
		assertTrue(thrown.getMessage().contains("A lista de funcionários do setor excedeu o limite de cadastro"));
	}

	@Test
	void deve_aceitar_funcionario_responsavel_valido() {
		Funcionario responsavel = new Funcionario("41659541875");
		setor.setResponsavel(responsavel);
		assertEquals(responsavel, setor.getResponsavel());
	}

	@Test
	void nao_deve_aceitar_funcionario_responsavel_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> setor.setResponsavel(null));
		assertTrue(thrown.getMessage().contains("O campo responsável do setor é de preenchimento obrigatório."));
	}

	@Test
	void deve_comparar_hash_code() {
		Setor setor2 = new Setor("Adm");
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
		Setor setor2 = new Setor("Adm");
		assertEquals(setor, setor2);
	}

	@Test
	void deve_retornar_nome_to_string() {
		assertThat(setor.toString(), containsString("nome=Adm"));
	}

	@Test
	void deve_retornar_funcionario_to_string() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Funcionario funcionario = new Funcionario("41659541875");
		funcionarios.add(funcionario);
		setor.setFuncionarios(funcionarios);
		assertThat(setor.toString(), containsString("cpf=41659541875"));
	}

	@Test
	void deve_retornar_responsavel_to_string() {
		Funcionario responsavel = new Funcionario("41659541875");
		responsavel.setNome("Guilherme");
		setor.setResponsavel(responsavel);
		assertThat(setor.toString(), containsString("nome=Guilherme"));
	}
}