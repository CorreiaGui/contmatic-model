package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.CpfUtil.isCpf;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaDataLimite;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaDataMinima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaMaiorIdade;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_LIMITE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_MINIMA;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_NASCIMENTO;
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
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.REGEX_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.REGEX_NUMEROS;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMAMNHO_CPF;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MINIMO_NOME;
import static java.util.Objects.hash;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;

public class Funcionario extends Auditoria {

	private String cpf;

	private String nome;

	private LocalDate dataNascimento;

	private Set<Endereco> enderecos;

	private Set<Email> emails;

	private Set<Telefone> telefones;

	private Setor setor;

	public Funcionario(String cpf) {
		this.setCpf(cpf);
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		verificaValorNulo(cpf, MENSAGEM_ERRO_CPF_NULL);
		verificaVazio(cpf, MENSAGEM_ERRO_CPF_VAZIO);
		verificaRegex(cpf, REGEX_NUMEROS, MENSAGEM_ERRO_CPF_REGEX);
		verificaTamanho(cpf, TAMAMNHO_CPF, MENSAGEM_ERRO_CPF_TAMANHO);
		isCpf(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		verificaValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
		verificaVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
		verificaTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
		verificaTamanhoMaximo(nome, TAMANHO_MAXIMO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
		verificaRegex(nome, REGEX_NOME, MENSAGEM_ERRO_NOME_REGEX);
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		verificaValorNulo(dataNascimento, MENSAGEM_ERRO_DATA_NULL);
		verificaDataMinima(dataNascimento, MENSAGEM_ERRO_DATA_MINIMA);
		verificaDataLimite(dataNascimento, MENSAGEM_ERRO_DATA_LIMITE);
		verificaMaiorIdade(dataNascimento, MENSAGEM_ERRO_DATA_NASCIMENTO);
		this.dataNascimento = dataNascimento;
	}

	public Set<Endereco> getEndereco() {
		return this.enderecos;
	}

	public void setEndereco(Set<Endereco> enderecos) {
		verificaValorNulo(enderecos, MENSAGEM_ERRO_ENDERECO_NULL);
		verificaVazio(enderecos, MENSAGEM_ERRO_ENDERECO_VAZIO);
		verificaTamanhoMinimo(enderecos, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_ENDERECO);
		verificaTamanhoMaximo(enderecos, TAMANHO_LISTA_ENDERECO, MENSAGEM_ERRO_ENDERECO_TAMANHO);
		this.enderecos = enderecos;
	}

	public Set<Email> getEmail() {
		return this.emails;
	}

	public void setEmail(Set<Email> emails) {
		verificaValorNulo(emails, MENSAGEM_ERRO_EMAIL_NULL);
		verificaVazio(emails, MENSAGEM_ERRO_EMAIL_VAZIO);
		verificaTamanhoMinimo(emails, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE);
		verificaTamanhoMaximo(emails, TAMANHO_LISTA_EMAIL, MENSAGEM_ERRO_EMAIL_TAMANHO);
		this.emails = emails;
	}

	public Set<Telefone> getTelefone() {
		return this.telefones;
	}

	public void setTelefone(Set<Telefone> telefones) {
		verificaValorNulo(telefones, MENSAGEM_ERRO_TELEFONE_NULL);
		verificaVazio(telefones, MENSAGEM_ERRO_TELEFONE_VAZIO);
		verificaTamanhoMinimo(telefones, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE);
		verificaTamanhoMaximo(telefones, TAMANHO_LISTA_TELEFONE, MENSAGEM_ERRO_TELEFONE_TAMANHO);
		this.telefones = telefones;
	}

	public Setor getSetor() {
		return this.setor;
	}

	public void setSetor(Setor setor) {
		verificaValorNulo(setor, MENSAGEM_ERRO_SETOR_NULL);
		this.setor = setor;
	}

	@Override
	public int hashCode() {
		return hash(cpf);
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [cpf=");
		builder.append(cpf);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", enderecos=");
		builder.append(enderecos);
		builder.append(", emails=");
		builder.append(emails);
		builder.append(", telefones=");
		builder.append(telefones);
		builder.append(", setor=");
		builder.append(setor);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
