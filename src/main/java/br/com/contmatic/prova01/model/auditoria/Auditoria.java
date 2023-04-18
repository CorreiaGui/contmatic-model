package br.com.contmatic.prova01.model.auditoria;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaDataMaxima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaDataMinima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_REGEX;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_REGEX;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.REGEX_LETRAS;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.TAMANHO_NOME_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.TAMANHO_NOME_MINIMO;

import java.time.ZonedDateTime;

public class Auditoria {

	private String nomeCriador;

	private ZonedDateTime dataCriacao;

	private String nomeEditor;

	private ZonedDateTime dataEdicao;

	public String getNomeCriador() {
		return this.nomeCriador;
	}

	public void setNomeCriador(String nomeCriador) {
		verificaValorNulo(nomeCriador, MENSAGEM_ERRO_NOME_CRIADOR_NULL);
		verificaVazio(nomeCriador, MENSAGEM_ERRO_NOME_CRIADOR_VAZIO);
		verificaRegex(nomeCriador, REGEX_LETRAS, MENSAGEM_ERRO_NOME_CRIADOR_REGEX);
		verificaTamanhoMinimo(nomeCriador, TAMANHO_NOME_MINIMO, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO);
		verificaTamanhoMaximo(nomeCriador, TAMANHO_NOME_MAXIMO, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO);
		this.nomeCriador = nomeCriador;
	}

	public ZonedDateTime getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(ZonedDateTime dataCriacao) {
		verificaValorNulo(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO_NULL);
		verificaDataMinima(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO);
		verificaDataMaxima(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO);
		this.dataCriacao = dataCriacao;
	}

	public String getNomeEditor() {
		return this.nomeEditor;
	}

	public void setNomeEditor(String nomeEditor) {
		verificaValorNulo(nomeEditor, MENSAGEM_ERRO_NOME_EDITOR_NULL);
		verificaVazio(nomeEditor, MENSAGEM_ERRO_NOME_EDITOR_VAZIO);
		verificaRegex(nomeEditor, REGEX_LETRAS, MENSAGEM_ERRO_NOME_EDITOR_REGEX);
		verificaTamanhoMinimo(nomeEditor, TAMANHO_NOME_MINIMO, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO);
		verificaTamanhoMaximo(nomeEditor, TAMANHO_NOME_MAXIMO, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO);
		this.nomeEditor = nomeEditor;
	}

	public ZonedDateTime getDataEdicao() {
		return this.dataEdicao;
	}

	public void setDataEdicao(ZonedDateTime dataEdicao) {
		verificaValorNulo(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO_NULL);
		verificaDataMinima(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO);
		verificaDataMaxima(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO);
		this.dataEdicao = dataEdicao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auditoria [nomeCriador=");
		builder.append(nomeCriador);
		builder.append(", dataCriacao=");
		builder.append(dataCriacao);
		builder.append(", nomeEditor=");
		builder.append(nomeEditor);
		builder.append(", dataEdicao=");
		builder.append(dataEdicao);
		builder.append("]");
		return builder.toString();
	}
}
