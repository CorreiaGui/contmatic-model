package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_SETOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant;

class EmpresaTest {

	private Empresa empresa;

	@BeforeEach
	void set_up() {
		empresa = new Empresa("62031611000154");
	}

	@Test
	void deve_aceitar_cnpj_valido() {
		assertEquals("62031611000154", empresa.getCnpj());
	}

	@Test
	void nao_deve_aceitar_cnpj_digito_verificador_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("62031690000154"));
		assertTrue(thrown.getMessage().contains("CNPJ inválido"));
	}

	@Test
	void nao_deve_aceitar_cnpj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa(null));
		assertTrue(thrown.getMessage().contains("O campo 'CNPJ' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_cnpj_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa(""));
		assertTrue(thrown.getMessage().contains("O campo 'CNPJ' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_cnpj_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Empresa("abc"));
		assertTrue(thrown.getMessage().contains("O campo CNPJ aceita apenas números."));
	}

	@Test
	void nao_deve_aceitar_cnpj_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> new Empresa("12345678910"));
		assertTrue(thrown.getMessage().contains("O campo CNPJ da empresa diferente de 14 digitos é inválido."));
	}

	@Test
	void deve_aceitar_numero_inscricao() {
		empresa.setNumeroInscricao("123456789");
		assertEquals("123456789", empresa.getNumeroInscricao());
	}

	@Test
	void nao_deve_aceitar_numero_inscricao_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNumeroInscricao(""));
		assertTrue(thrown.getMessage().contains("O campo 'número de inscrição' é de preenchimento obrigatório"));
	}

	@Test
	void nao_deve_aceitar_numero_inscricao_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNumeroInscricao("teste"));
		assertTrue(thrown.getMessage().contains("O campo Número de Inscrição aceita apenas números."));
	}

	@Test
	void nao_deve_aceitar_numero_inscricao_tamanho_diferente() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNumeroInscricao("12345678"));
		assertTrue(thrown.getMessage().contains("O número de inscrição deve conter 9 digitos."));
	}

	@Test
	void nao_deve_aceitar_numero_inscricao_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNumeroInscricao(null));
		assertTrue(thrown.getMessage().contains("O campo 'número de inscrição' é de preenchimento obrigatório"));
	}

	@Test
	void deve_aceitar_data_abertura_valida() {
		LocalDate dataAbertura = LocalDate.of(2021, 04, 21);
		empresa.setDataAbertura(dataAbertura);
		assertEquals(dataAbertura, empresa.getDataAbertura());
	}

	@Test
	void nao_deve_aceitar_data_abertura_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataAbertura(null));
		assertTrue(thrown.getMessage().contains("O campo 'Data de abertura' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_data_menor_minimo() {
		LocalDate dataErrada = LocalDate.of(1400, 05, 13);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataAbertura(dataErrada));
		assertTrue(thrown.getMessage().contains("A data inserida é inválida"));
	}

	@Test
	void nao_deve_aceitar_data_maior_maximo() {
		LocalDate dataErrada = LocalDate.of(2500, 05, 13);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataAbertura(dataErrada));
		assertTrue(thrown.getMessage().contains("A data de abertura da empresa está inválida"));
	}

	@Test
	void deve_aceitar_razao_social() {
		empresa.setRazaoSocial("Empresa Teste LDTA");
		assertEquals("Empresa Teste LDTA", empresa.getRazaoSocial());
	}

	@Test
	void nao_deve_aceitar_razao_social_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial(null));
		assertTrue(thrown.getMessage().contains("O campo 'razão social' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_razao_social_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial(""));
		assertTrue(thrown.getMessage().contains("O campo 'razão social' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_razao_social_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("f"));
		assertTrue(thrown.getMessage().contains("O campo contém caracteres insuficientes."));
	}

	@Test
	void nao_deve_aceitar_razao_social_caracteres_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial(
				"testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O tamanho máximo de caracteres foi excedido."));
	}

	@Test
	void deve_aceitar_nome_fantasia() {
		empresa.setNomeFantasia("Guilherme Tech");
		assertEquals("Guilherme Tech", empresa.getNomeFantasia());
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia(null));
		assertTrue(thrown.getMessage().contains("O campo 'nome fantasia' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia(""));
		assertTrue(thrown.getMessage().contains("O campo 'nome fantasia' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia("f"));
		assertTrue(thrown.getMessage().contains("O campo contém caracteres insuficientes."));
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_caracteres_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia(
				"testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O tamanho máximo de caracteres foi excedido."));
	}

	@Test
	void deve_aceitar_natureza_juridica() {
		empresa.setNaturezaJuridica("LTDA");
		assertEquals("LTDA", empresa.getNaturezaJuridica());
	}

	@Test
	void nao_deve_aceitar_nome_natureza_juridica_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNaturezaJuridica(null));
		assertTrue(thrown.getMessage().contains("O campo 'Natureza Jurídica' é de preenchimento obrigatório"));
	}

	@Test
	void nao_deve_aceitar_nome_natureza_juridica_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNaturezaJuridica(""));
		assertTrue(thrown.getMessage().contains("O campo 'Natureza Jurídica' é de preenchimento obrigatório"));
	}

	@Test
	void nao_deve_aceitar_natureza_juridica_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNaturezaJuridica("f"));
		assertTrue(thrown.getMessage().contains("O campo contém caracteres insuficientes."));
	}

	@Test
	void nao_deve_aceitar_natureza_juridica_caracteres_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNaturezaJuridica(
						"testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O tamanho máximo de caracteres foi excedido."));
	}

	@Test
	void deve_aceitar_situacao_cadastral() {
		empresa.setSituacaoCadastral("ATIVO");
		assertEquals("ATIVO", empresa.getSituacaoCadastral());
	}

	@Test
	void nao_deve_aceitar_situacao_cadastral_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoCadastral(null));
		assertTrue(thrown.getMessage()
				.contains("O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_situacao_cadastral_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoCadastral(""));
		assertTrue(thrown.getMessage()
				.contains("O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_situacao_cadastral_caracteres_insuficientes() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoCadastral("f"));
		assertTrue(thrown.getMessage().contains("O campo contém caracteres insuficientes."));
	}

	@Test
	void nao_deve_aceitar_situacao_cadastral_caracteres_maximo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoCadastral(
						"testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste"));
		assertTrue(thrown.getMessage().contains("O tamanho máximo de caracteres foi excedido."));
	}

	@Test
	void nao_deve_aceitar_situacao_cadastral_diferente_padrao() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setSituacaoCadastral("TESTE"));
		assertTrue(thrown.getMessage()
				.contains("O campo situação cadastral aceita apenas valores como ATIVO, INATIVO, DESATIVADO."));
	}

	@Test
	void deve_aceitar_lista_endereco() {
		Set<Endereco> enderecos = new HashSet<Endereco>();
		for (int indice = TAMANHO_MAXIMO_ENDERECO; indice != 0; indice--) {
			Endereco endereco = new Endereco("04136020", indice, "ap 05");
			enderecos.add(endereco);
		}
		empresa.setEndereco(enderecos);
		assertEquals(enderecos, empresa.getEndereco());
	}

	@Test
	void nao_deve_aceitar_endereco_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setEndereco(null));
		assertTrue(thrown.getMessage().contains("O campo 'endereço' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_endereco_vazio() {
		Set<Endereco> enderecoVazio = new HashSet<Endereco>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setEndereco(enderecoVazio));
		assertTrue(thrown.getMessage().contains("O campo 'endereço' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_endereco_excedendo_tamanho() {
		Set<Endereco> enderecos = new HashSet<Endereco>();
		IntStream.range(TAMANHO_MINIMO_ENDERECO, TAMANHO_MAXIMO_ENDERECO + 2)
				.forEach(indice -> enderecos.add(new Endereco("04136030", indice, "ap 04")));
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setEndereco(enderecos));
		assertTrue(thrown.getMessage().contains("O máximo de 'endereços' excedeu o limite de preenchimento."));
	}

	@Test
	void deve_aceitar_lista_funcionario() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Funcionario funcionario = new Funcionario("41659541875");
		Funcionario funcionario2 = new Funcionario("12433534062");
		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);
		empresa.setFuncionario(funcionarios);
		assertEquals(funcionarios, empresa.getFuncionario());
	}

	@Test
	void nao_deve_aceitar_lista_funcionario_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionario(null));
		assertTrue(thrown.getMessage().contains("O campo 'funcionarios da empresa' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_funcionario_vazio() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionario(funcionarios));
		assertTrue(thrown.getMessage()
				.contains("O campo 'Funcionarios da empresa' sem um funcionario inserido é inválido."));
	}

	@Test
	void nao_deve_aceitar_lista_funcionario_menor_minimo() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Funcionario funcionario = new Funcionario("41659541875");
		funcionarios.add(funcionario);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionario(funcionarios));
		assertTrue(thrown.getMessage().contains("O campo contém quantidade insuficiente para cadastro."));
	}

	@Test
	void nao_deve_aceita_lista_funcionario_excedendo_tamanho_maximo() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for (int indice = TAMANHO_MAXIMO_FUNCIONARIO + 3; indice != 0; indice--) {
			funcionarios.add(null);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setFuncionario(funcionarios));
		assertTrue(thrown.getMessage().contains("A quantidade de Funcionarios cadastrados foi excedido."));
	}

	@Test
	void deve_aceitar_lista_produtos() {
		Set<Produto> produtos = new HashSet<Produto>();
		for (int indice = TAMANHO_MINIMO_LISTA; indice != 0; indice--) {
			Produto produto = new Produto("Bola", indice + 1);
			produtos.add(produto);
		}
		empresa.setProduto(produtos);
		assertEquals(produtos, empresa.getProduto());
	}

	@Test
	void nao_deve_aceitar_produto_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setProduto(null));
		assertTrue(thrown.getMessage().contains("O campo 'Produtos' da empresa é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_produto_vazio() {
		Set<Produto> produtoVazio = new HashSet<Produto>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setProduto(produtoVazio));
		assertTrue(thrown.getMessage().contains("O campo 'Produtos' da empresa é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_produto_menor_minimo() {
		Set<Produto> produtos = new HashSet<Produto>();
		Produto produto = new Produto("Bola", 1);
		produtos.add(produto);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setProduto(produtos));
		assertTrue(thrown.getMessage().contains("O campo contém quantidade insuficiente para cadastro."));
	}

	@Test
	void nao_deve_aceitar_lista_produto_excedendo_tamanho_maximo() {
		Set<Produto> produtos = new HashSet<>();
		int numero = 1;
		for (int indice = TAMANHO_MAXIMO_PRODUTO + 2; indice != 0; indice--) {
			Produto produto = new Produto("bola", numero++);
			produtos.add(produto);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setProduto(produtos));
		assertTrue(thrown.getMessage().contains("A quantidade de produtos cadastrados foi excedido."));
	}

	@Test
	void deve_aceitar_lista_email() {
		Set<Email> emails = new HashSet<Email>();
		int numero = 0;
		for (int indice = TAMANHO_MINIMO_LISTA; indice != 0; indice--) {
			Email email = new Email(("abc@abc.com" + numero++));
			emails.add(email);
		}
		empresa.setEmail(emails);
		assertEquals(emails, empresa.getEmail());
	}

	@Test
	void nao_deve_aceitar_lista_email_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setEmail(null));
		assertTrue(thrown.getMessage().contains("O campo 'e-mail' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_email_vazio() {
		Set<Email> emails = new HashSet<Email>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setEmail(emails));
		assertTrue(thrown.getMessage().contains("O campo 'e-mail' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_email_menor_minimo() {
		Set<Email> emails = new HashSet<Email>();
		Email email = new Email("teste@teste");
		emails.add(email);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setEmail(emails));
		assertTrue(thrown.getMessage().contains("O campo contém quantidade insuficiente para cadastro."));
	}

	@Test
	void nao_deve_aceitar_lista_email_excedendo_maximo() {
		Set<Email> emails = new HashSet<Email>();
		for (int indice = EmpresaConstant.TAMANHO_MAXIMO_EMAIL + 2; indice != 0; indice--) {
			Email email = new Email("teste@teste");
			emails.add(email);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setEmail(emails));
		assertTrue(thrown.getMessage().contains("O campo contém quantidade insuficiente para cadastro."));
	}

	@Test
	void deve_aceitar_lista_telefone() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		Telefone telefone = new Telefone("55", "11", "948623933");
		Telefone telefone2 = new Telefone("55", "11", "948623932");
		telefones.add(telefone);
		telefones.add(telefone2);
		empresa.setTelefone(telefones);
		assertEquals(telefones, empresa.getTelefone());
	}

	@Test
	void nao_deve_aceitar_lista_telefone_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setTelefone(null));
		assertTrue(thrown.getMessage().contains("O campo 'telefone' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_telefone_vazio() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setTelefone(telefones));
		assertTrue(thrown.getMessage().contains("O campo 'telefone' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_lista_telefone_menor_minimo() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		Telefone telefone = new Telefone("55", "11", "948623932");
		telefones.add(telefone);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setTelefone(telefones));
		assertTrue(thrown.getMessage().contains("O campo não contém quantidade mínima 2 telefones."));
	}

	@Test
	void nao_deve_aceitar_lista_telefone_excedendo_maximo() {
		Set<Telefone> telefones = new HashSet<Telefone>();
		for (Integer indice = TAMANHO_MAXIMO_TELEFONE + 2; indice != 0; indice--) {
			String ddd = indice.toString().length() == 1 ? "0" + indice.toString() : indice.toString();
			Telefone telefone = new Telefone("55", ddd, "948623932");
			telefones.add(telefone);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setTelefone(telefones));
		assertTrue(thrown.getMessage().contains("O campo 'lista de telefone', excedeu a quantidade máxima permitida."));
	}

	@Test
	void deve_aceitar_setor_valido() {
		Set<Setor> setores = new HashSet<Setor>();
		Setor setor1 = new Setor("Administrativo");
		Setor setor2 = new Setor("Comercial");
		setores.add(setor2);
		setores.add(setor1);
		empresa.setSetor(setores);
		assertEquals(setores, empresa.getSetor());
	}

	@Test
	void nao_deve_aceitar_setor_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setSetor(null));
		assertTrue(thrown.getMessage().contains("O campo 'Setor' é de preenchimento obrigatório."));
	}

	@Test
	void nao_deve_aceitar_setor_lista_vazia() {
		Set<Setor> setores = new HashSet<Setor>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setSetor(setores));
		assertTrue(thrown.getMessage().contains("O campo lista de 'setores' vazio é inválido."));
	}

	@Test
	void nao_deve_aceitar_setor_lista_menor_minimo() {
		Set<Setor> setores = new HashSet<Setor>();
		Setor setor = new Setor("teste");
		setores.add(setor);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setSetor(setores));
		assertTrue(thrown.getMessage().contains("O campo não contém a quantidade mínima de dois setores."));
	}

	@Test
	void nao_deve_aceitar_setor_lista_excedendo_tamanho_maximo() {
		Set<Setor> setores = new HashSet<Setor>();
		String stringInicial = "Nome";
		for (int indice = TAMANHO_MAXIMO_SETOR + 2; indice != 0; indice--) {
			stringInicial = stringInicial.concat("s");
			Setor setor = new Setor(stringInicial.concat(stringInicial));
			setores.add(setor);
		}
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setSetor(setores));
		assertTrue(thrown.getMessage().contains("O campo 'Setor' excedeu a quantidade maxima."));
	}

	@Test
	void deve_retornar_verdadeiro_equals_mesma_valor() {
		Empresa empresa2 = new Empresa("62031611000154");
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
		Empresa empresa2 = new Empresa("62031611000154");
		assertEquals(empresa.hashCode(), empresa2.hashCode());
	}

	@Test
	void deve_retornar_cnpj_to_string() {
		assertThat(empresa.toString(), containsString("62031611000154"));
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
		LocalDate data = LocalDate.of(2023, 04, 04);
		empresa.setDataAbertura(data);
		assertThat(empresa.toString(), containsString("2023-04-04"));
	}

	@Test
	void deve_retornar_endereco_to_string() {
		Set<Endereco> enderecos = new HashSet<Endereco>();
		Endereco endereco = new Endereco("04136030", 772, "casa");
		enderecos.add(endereco);
		empresa.setEndereco(enderecos);
		assertThat(empresa.toString(), containsString("04136030"));
	}

	@Test
	void deve_retornar_funcionario_to_string() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Funcionario funcionario1 = new Funcionario("41659541875");
		Funcionario funcionario2 = new Funcionario("15308679835");
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario1);
		empresa.setFuncionario(funcionarios);
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
		empresa.setProduto(produtos);
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
		empresa.setEmail(emails);
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
		empresa.setTelefone(telefones);
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
		empresa.setSetor(setores);
		assertThat(empresa.toString(), containsString("adm"));
		assertThat(empresa.toString(), containsString("informatica"));
	}
}