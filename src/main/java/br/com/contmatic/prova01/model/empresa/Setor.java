package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_RESPONSAVEL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_NOME;
import static java.util.Objects.hash;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Setor extends Auditoria {

	private String nome;

	private List<Funcionario> funcionarios;

	private Funcionario responsavel;

	public Setor(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		verificaValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
		verificaVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
		verificaTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
		verificaTamanhoMaximo(nome, TAMANHO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		verificaValorNulo(funcionarios, MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL);
		verificaVazio(funcionarios, MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO);
		verificaTamanhoMinimo(funcionarios, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO);
		verificaTamanhoMaximo(funcionarios, TAMANHO_LISTA_FUNCIONARIO, MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO);
		this.funcionarios = funcionarios;
	}

	public Funcionario getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(Funcionario responsavel) {
		verificaValorNulo(responsavel, MENSAGEM_ERRO_RESPONSAVEL_NULL);
		this.responsavel = responsavel;
	}

	@Override
	public int hashCode() {
		return hash(nome);
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
		Setor other = (Setor) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Setor [nome=");
		builder.append(nome);
		builder.append(", funcionarios=");
		builder.append(funcionarios);
		builder.append(", responsável=");
		builder.append(responsavel);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
