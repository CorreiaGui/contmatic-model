package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.REGEX_SIGLA;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_SIGLA;
import static java.util.Objects.hash;

import java.util.Objects;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Estado extends Auditoria {

	private String sigla;

	private String nome;

	public Estado(String sigla) {
		this.setSigla(sigla);
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		verificarValorNulo(sigla, MENSAGEM_ERRO_SIGLA_NULL);
		verificarVazio(sigla, MENSAGEM_ERRO_SIGLA_VAZIO);
		verificarTamanho(sigla, TAMANHO_SIGLA, MENSAGEM_ERRO_SIGLA_TAMANHO);
		verificarRegex(sigla, REGEX_SIGLA, MENSAGEM_ERRO_SIGLA_REGEX);
		this.sigla = sigla;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		verificarValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
		verificarVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
		verificarTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
		verificarTamanhoMaximo(nome, TAMANHO_NOME, MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME);
		verificarRegex(nome, REGEX_LETRA, MENSAGEM_ERRO_NOME_REGEX);
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return hash(nome, sigla);
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
		Estado other = (Estado) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sigla, other.sigla);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estado [sigla=");
		builder.append(sigla);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
