package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.CnpjUtil.isCnpj;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaDataLimite;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaDataMinima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_LIMITE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NATUREZA_JURIDICA_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_RAZAO_SOCIAL_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SITUACAO_CADASTRAL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SITUACAO_CADASTRAL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_CNPJ;
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
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.REGEX_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.REGEX_SITUACAO_CADASTRAL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_SETOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_STRING;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_NUMERO_INSCRICAO;
import static java.util.Objects.hash;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;

public class Empresa extends Auditoria {

	private String cnpj;

	private String numeroInscricao;

	private String razaoSocial;

	private String nomeFantasia;

	private String naturezaJuridica;

	private String situacaoCadastral;

	private LocalDate dataAbertura;

	private Set<Endereco> enderecos;

	private List<Funcionario> funcionarios;

	private Set<Produto> produtos;

	private Set<Email> emails;

	private Set<Telefone> telefones;

	private Set<Setor> setores;

	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		verificaValorNulo(cnpj, MENSAGEM_ERRO_CNPJ_NULL);
		verificaVazio(cnpj, MENSAGEM_ERRO_CNPJ_VAZIO);
		verificaRegex(cnpj, REGEX_NUMERO, MENSAGEM_ERRO_REGEX_CNPJ);
		verificaTamanho(cnpj, TAMANHO_CNPJ, MENSAGEM_ERRO_TAMANHO_CNPJ);
		isCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getNumeroInscricao() {
		return this.numeroInscricao;
	}

	public void setNumeroInscricao(String numeroInscricao) {
		verificaValorNulo(numeroInscricao, MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL);
		verificaVazio(numeroInscricao, MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO);
		verificaRegex(numeroInscricao, REGEX_NUMERO, MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO);
		verificaTamanho(numeroInscricao, TAMANHO_NUMERO_INSCRICAO, MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO);
		this.numeroInscricao = numeroInscricao;
	}

	public LocalDate getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		verificaValorNulo(dataAbertura, MENSAGEM_ERRO_DATA_NULA);
		verificaDataMinima(dataAbertura, MENSAGEM_ERRO_DATA);
		verificaDataLimite(dataAbertura, MENSAGEM_ERRO_DATA_LIMITE);
		this.dataAbertura = dataAbertura;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		verificaValorNulo(razaoSocial, MENSAGEM_ERRO_RAZAO_SOCIAL_NULA);
		verificaVazio(razaoSocial, MENSAGEM_ERRO_RAZAO_SOCIAL_NULA);
		verificaTamanhoMinimo(razaoSocial, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO);
		verificaTamanhoMaximo(razaoSocial, TAMANHO_MAXIMO_STRING, MENSAGEM_ERRO_TAMANHO_MAXIMO);
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		verificaValorNulo(nomeFantasia, MENSAGEM_ERRO_NOME_FANTASIA_NULA);
		verificaVazio(nomeFantasia, MENSAGEM_ERRO_NOME_FANTASIA_VAZIO);
		verificaTamanhoMinimo(nomeFantasia, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO);
		verificaTamanhoMaximo(nomeFantasia, TAMANHO_MAXIMO_STRING, MENSAGEM_ERRO_TAMANHO_MAXIMO);
		this.nomeFantasia = nomeFantasia;
	}

	public String getNaturezaJuridica() {
		return this.naturezaJuridica;
	}

	public void setNaturezaJuridica(String naturezaJuridica) {
		verificaValorNulo(naturezaJuridica, MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL);
		verificaVazio(naturezaJuridica, MENSAGEM_ERRO_NATUREZA_JURIDICA_VAZIO);
		verificaTamanhoMinimo(naturezaJuridica, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO);
		verificaTamanhoMaximo(naturezaJuridica, TAMANHO_MAXIMO_STRING, MENSAGEM_ERRO_TAMANHO_MAXIMO);
		this.naturezaJuridica = naturezaJuridica;
	}

	public Set<Endereco> getEndereco() {
		return this.enderecos;
	}

	public void setEndereco(Set<Endereco> endereco) {
		verificaValorNulo(endereco, MENSAGEM_ERRO_ENDERECO_NULL);
		verificaVazio(endereco, MENSAGEM_ERRO_ENDERECO_VAZIO);
		verificaTamanhoMinimo(endereco, TAMANHO_MINIMO_ENDERECO, MENSAGEM_ERRO_TAMANHO_MINIMO);
		verificaTamanhoMaximo(endereco, TAMANHO_MAXIMO_ENDERECO, MENSAGEM_ERRO_TAMANHO_ENDERECO);
		this.enderecos = endereco;
	}

	public List<Funcionario> getFuncionario() {
		return this.funcionarios;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		verificaValorNulo(funcionario, MENSAGEM_ERRO_FUNCIONARIO_NULL);
		verificaVazio(funcionario, MENSAGEM_ERRO_FUNCIONARIO_VAZIO);
		verificaTamanhoMinimo(funcionario, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
		verificaTamanhoMaximo(funcionario, TAMANHO_MAXIMO_FUNCIONARIO, MENSAGEM_ERRO_TAMANHO_FUNCIONARIO);
		this.funcionarios = funcionario;
	}

	public Set<Produto> getProduto() {
		return this.produtos;
	}

	public void setProduto(Set<Produto> produto) {
		verificaValorNulo(produto, MENSAGEM_ERRO_PRODUTO_NULL);
		verificaVazio(produto, MENSAGEM_ERRO_PRODUTO_VAZIO);
		verificaTamanhoMinimo(produto, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
		verificaTamanhoMaximo(produto, TAMANHO_MAXIMO_PRODUTO, MENSAGEM_ERRO_TAMANHO_PRODUTO);
		this.produtos = produto;
	}

	public String getSituacaoCadastral() {
		return this.situacaoCadastral;
	}

	public void setSituacaoCadastral(String situacaoCadastral) {
		verificaValorNulo(situacaoCadastral, MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL);
		verificaVazio(situacaoCadastral, MENSAGEM_ERRO_SITUACAO_CADASTRAL_VAZIO);
		verificaTamanhoMinimo(situacaoCadastral, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO);
		verificaTamanhoMaximo(situacaoCadastral, TAMANHO_MAXIMO_STRING, MENSAGEM_ERRO_TAMANHO_MAXIMO);
		verificaRegex(situacaoCadastral, REGEX_SITUACAO_CADASTRAL, MENSAGEM_ERRO_SITUACAO_CADASTRAL_REGEX);
		this.situacaoCadastral = situacaoCadastral;
	}

	public Set<Email> getEmail() {
		return this.emails;
	}

	public void setEmail(Set<Email> emails) {
		verificaValorNulo(emails, MENSAGEM_ERRO_EMAIL_NULL);
		verificaVazio(emails, MENSAGEM_ERRO_EMAIL_VAZIO);
		verificaTamanhoMinimo(emails, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
		verificaTamanhoMaximo(emails, TAMANHO_MAXIMO_EMAIL, MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL);
		this.emails = emails;
	}

	public Set<Telefone> getTelefone() {
		return this.telefones;
	}

	public void setTelefone(Set<Telefone> telefones) {
		verificaValorNulo(telefones, MENSAGEM_ERRO_TELEFONE_NULL);
		verificaVazio(telefones, MENSAGEM_ERRO_TELEFONE_VAZIO);
		verificaTamanhoMinimo(telefones, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN);
		verificaTamanhoMaximo(telefones, TAMANHO_MAXIMO_TELEFONE, MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO);
		this.telefones = telefones;
	}

	public Set<Setor> getSetor() {
		return setores;
	}

	public void setSetor(Set<Setor> setores) {
		verificaValorNulo(setores, MENSAGEM_ERRO_SETOR_NULL);
		verificaVazio(setores, MENSAGEM_ERRO_SETOR_VAZIO);
		verificaTamanhoMinimo(setores, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO);
		verificaTamanhoMaximo(setores, TAMANHO_MAXIMO_SETOR, MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO);
		this.setores = setores;
	}

	@Override
	public int hashCode() {
		return hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empresa [cnpj=");
		builder.append(cnpj);
		builder.append(", numeroInscricao=");
		builder.append(numeroInscricao);
		builder.append(", razaoSocial=");
		builder.append(razaoSocial);
		builder.append(", nomeFantasia=");
		builder.append(nomeFantasia);
		builder.append(", naturezaJuridica=");
		builder.append(naturezaJuridica);
		builder.append(", situacaoCadastral=");
		builder.append(situacaoCadastral);
		builder.append(", dataAbertura=");
		builder.append(dataAbertura);
		builder.append(", enderecos=");
		builder.append(enderecos);
		builder.append(", funcionarios=");
		builder.append(funcionarios);
		builder.append(", produtos=");
		builder.append(produtos);
		builder.append(", emails=");
		builder.append(emails);
		builder.append(", telefones=");
		builder.append(telefones);
		builder.append(", setores=");
		builder.append(setores);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
