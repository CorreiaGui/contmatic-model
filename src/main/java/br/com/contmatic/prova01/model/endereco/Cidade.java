package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_ESTADO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.TAMANHO_NOME;
import static java.util.Objects.hash;

import java.util.Objects;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Cidade extends Auditoria {

	private String nome;

	private Estado estado;

	public Cidade(String nome, Estado estado) {
		this.setNome(nome);
		this.setEstado(estado);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		verificarValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
		verificarVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
		verificarTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_NOME_TAMANHO_MINIMO);
		verificarTamanhoMaximo(nome, TAMANHO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
		verificarRegex(nome, REGEX_LETRA, MENSAGEM_ERRO_NOME_REGEX);
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		verificarValorNulo(estado, MENSAGEM_ERRO_ESTADO_NULL);
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return hash(estado, nome);
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
		Cidade other = (Cidade) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(estado, other.estado);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cidade [nome=");
		builder.append(nome);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
