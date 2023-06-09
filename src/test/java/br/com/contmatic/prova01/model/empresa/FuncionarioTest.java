package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_TELEFONE;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;

class FuncionarioTest {

	Funcionario funcionario;

	@BeforeEach
	void set_up() {
		funcionario = new Funcionario("41659541875");
	}

	@Test
	void deve_aceitar_cpf_valido() {
		funcionario.setCpf("41659541875");
		assertEquals("41659541875", funcionario.getCpf());
	}

	@Test
	void nao_deve_aceitar_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf(""));
		assertTrue(thrown.getMessage().contains("O campo cpf do funcionário com espaço em branco é inválido"));
	}

	@Test
	void nao_deve_aceitar_letras_cpf() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setCpf("abc"));
		assertTrue(
				thrown.getMessage().contains("O campo CPF do funcionário com valor diferente de números é inválido"));
	}

	@Test
	void nao_deve_aceitar_cpf_diferente_11_digitos() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("123456789"));
		assertTrue(thrown.getMessage().contains("O campo CPF necessita de onze dígitos."));
	}

	@Test
	void nao_deve_aceitar_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("12345678911"));
		assertTrue(thrown.getMessage().contains("Cpf inválido."));
	}

	@Test
	void nao_deve_aceitar_cpf_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("11111111111"));
		assertTrue(thrown.getMessage().contains("Números repetidos no campo CPF é inválidos."));
	}

	@Test
	void deve_aceitar_nome_valido() {
		funcionario.setNome("Guilherme Correia");
		assertEquals("Guilherme Correia", funcionario.getNome());
	}

	@Test
	void nao_deve_aceitar_nome_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class, () -> funcionario.setNome(null));
		assertTrue(thrown.getMessage().contains("O campo NOME do funcionário é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome(""));
		assertTrue(thrown.getMessage().contains("O campo NOME do funcionário com espaço em branco é inválido"));
	}

	@Test
	void nao_deve_aceitar_nome_menor_tamanho_minimo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario.setNome("ab"));
		assertTrue(thrown.getMessage().contains("O campo nome com menos de três caractere é inválido."));
	}

	@Test
	void nao_deve_aceitar_nome_maior_tamanho_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> funcionario
				.setNome("testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O campo NOME do funcionário excedeu o limite de caracteres."));
	}

	@Test
	void nao_deve_aceitar_nome_com_numero() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("123"));
		assertTrue(thrown.getMessage()
				.contains("O campo NOME do funcionário diferente do padrão 'Nome Exemplo' é invalido"));
	}

	@Test
	void deve_aceitar_data_nascimento_valida() {
		funcionario.setDataNascimento(LocalDate.of(2000, 3, 1));
		LocalDate data = LocalDate.of(2000, 3, 1);
		assertEquals(data, funcionario.getDataNascimento());
	}

	@Test
	void nao_deve_aceitar_data_nascimento_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> funcionario.setDataNascimento(null));
		assertTrue(thrown.getMessage().contains("O campo data de nascimento é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_data_nascimento_menor_data_minima() {
		LocalDate data = LocalDate.of(1300, 3, 1);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setDataNascimento(data));
		assertTrue(thrown.getMessage().contains("O campo data nascimento está inválida"));
	}

	@Test
	void nao_deve_aceitar_data_nascimento_maior_data_limite() {
		LocalDate data1 = LocalDate.of(3200, 3, 1);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setDataNascimento(data1));
		assertTrue(thrown.getMessage().contains("O campo data nascimento não permite datas futuras"));
	}

	@Test
	void nao_deve_aceitar_data_nascimento_funcionario_menor_idade() {
		LocalDate data2 = LocalDate.of(2022, 3, 1);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setDataNascimento(data2));
		assertTrue(thrown.getMessage()
				.contains("Data de nascimento inválida. A data informada é de uma pessoa menor de idade."));
	}

	@Test
	void deve_aceitar_lista_endereco() {
		Set<Endereco> enderecos = new HashSet<Endereco>();
		for (int indice = TAMANHO_LISTA_ENDERECO; indice != 0; indice--) {
			Endereco endereco = new Endereco("04136020", indice, "ap 05");
			enderecos.add(endereco);
		}
		funcionario.setEndereco(enderecos);
		assertEquals(enderecos, funcionario.getEndereco());
	}

	@Test
	void nao_deve_aceitar_endereco_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> funcionario.setEndereco(null));
		assertTrue(thrown.getMessage().contains("O campo 'endereço' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_endereco_vazio() {
		Set<Endereco> enderecoVazio = new HashSet<Endereco>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEndereco(enderecoVazio));
		assertTrue(thrown.getMessage().contains("O campo 'endereço' não pode conter espaço em branco."));
	}

	@Test
	void nao_deve_aceitar_endereco_excedendo_tamanho() {
		Set<Endereco> enderecos = new HashSet<Endereco>();
		for (int indice = TAMANHO_LISTA_ENDERECO + 2; indice != 0; indice--) {
			Endereco endereco = new Endereco("04136030", indice, "ap 05");
			enderecos.add(endereco);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEndereco(enderecos));
		assertTrue(thrown.getMessage().contains("O campo 'Endereço' excedeu o limite de cadastro."));
	}

	@Test
	void deve_aceitar_lista_email() {
		Set<Email> emails = new HashSet<Email>();
		int numero = 0;
		for (int indice = TAMANHO_MINIMO_LISTA; indice != 0; indice--) {
			Email email = new Email(("abc@abc.com" + numero++));
			emails.add(email);
		} 
		funcionario.setEmail(emails);
		assertEquals(emails, funcionario.getEmail());
	}

	@Test
	void nao_deve_aceitar_lista_email_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> funcionario.setEmail(null));
		assertTrue(thrown.getMessage().contains("O campo 'e-mail' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_email_vazio() {
		Set<Email> emails = new HashSet<Email>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail(emails));
		assertTrue(thrown.getMessage().contains("O campo lista de e-mail não permite espaço em branco"));
	}

	@Test
	void nao_deve_aceitar_lista_email_excedendo_maximo() {
		Set<Email> emails = new HashSet<Email>();
		int numero = 0;
		for (int indice = TAMANHO_LISTA_EMAIL + 2; indice != 0; indice--) {
			Email email = new Email("teste@teste" + numero++);
			emails.add(email);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setEmail(emails));
		assertTrue(thrown.getMessage().contains("A lista de e-mail dos funcionário excedeu o limite de cadastro"));
	}

	@Test
	void deve_aceitar_lista_telefone() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		Telefone telefone = new Telefone("55", "11", "948623933");
		Telefone telefone2 = new Telefone("55", "11", "948623932");
		telefones.add(telefone);
		telefones.add(telefone2);
		funcionario.setTelefone(telefones);
		assertEquals(telefones, funcionario.getTelefone());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> funcionario.setTelefone(null));
		assertTrue(thrown.getMessage().contains("O campo 'telefone' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone(telefones));
		assertTrue(thrown.getMessage().contains("O campo lista de telefone não permite espaço em branco."));
	}

	@Test
	void nao_deve_aceitar_lista_telefone_excedendo_maximo() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		for (Integer indice = TAMANHO_LISTA_TELEFONE + 2; indice != 0; indice--) {
			String ddd = indice.toString().length() == 1 ? "0" + indice.toString() : indice.toString();
			Telefone telefone = new Telefone("55", ddd, "948623932");
			telefones.add(telefone);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setTelefone(telefones));
		assertTrue(
				thrown.getMessage().contains("O campo 'lista de telefone' excedeu a quantidade máxima de cadastro."));
	}

	@Test
	void deve_aceitar_setor_valido() {
		Setor setor = new Setor("Adm");
		funcionario.setSetor(setor);
		assertEquals(setor, funcionario.getSetor());
	}

	@Test
	void nao_deve_aceitar_setor_nulo() {
		NullPointerException thrown = assertThrows(NullPointerException.class,
				() -> funcionario.setSetor(null));
		assertTrue(thrown.getMessage().contains("O campo setor do funcionário é de preenchimento obrigatório."));
	}

	@Test
	void deve_comparar_hash_code() {
		Funcionario funcionario2 = new Funcionario("41659541875");
		assertEquals(funcionario.hashCode(), funcionario2.hashCode());
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesmo_objeto() {
		assertEquals(funcionario, funcionario);
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesma_instancia() {
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
		assertThat(funcionario.toString(), containsString("41659541875"));
	}

	@Test
	void deve_retornar_nome_to_string() {
		funcionario.setNome("Gui");
		assertThat(funcionario.toString(), containsString("Gui"));
	}

	@Test
	void deve_retornar_data_nascimento_to_string() {
		funcionario.setDataNascimento(LocalDate.of(2002, 04, 21));
		assertThat(funcionario.toString(), containsString("2002-04-21"));
	}

	@Test
	void deve_retornar_endereco_to_string() {
		Set<Endereco> enderecos = new HashSet<Endereco>();
		Endereco endereco = new Endereco("04136030", 772, "casa");
		enderecos.add(endereco);
		funcionario.setEndereco(enderecos);
		assertThat(funcionario.toString(), containsString("04136030"));
	}

	@Test
	void deve_retornar_email_to_string() {
		Set<Email> emails = new HashSet<Email>();
		Email email = new Email("teste@teste.com");
		Email email2 = new Email("testeee@teste.com");
		emails.add(email);
		emails.add(email2);
		funcionario.setEmail(emails);
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
		funcionario.setTelefone(telefones);
		assertThat(funcionario.toString(), containsString("912345678"));
		assertThat(funcionario.toString(), containsString("912345444"));
	}

	@Test
	void deve_retornar_setor_to_string() {
		Setor setor = new Setor("Adm");
		funcionario.setSetor(setor);
		assertThat(funcionario.toString(), containsString("Adm"));
	}
}
