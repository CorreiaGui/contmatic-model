package br.com.contmatic.prova01.model.auditoria;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarDataMaxima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarDataMinima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO_NULL;
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
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import java.time.ZonedDateTime;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.validation.constraints.NotNull;

public class Auditoria {
    
    @NotNull(message = "error")
    private String nomeCriador;

    private ZonedDateTime dataCriacao;
    
    private String nomeEditor;

    private ZonedDateTime dataEdicao;

    public String getNomeCriador() {
        return this.nomeCriador;
    } 

    public void setNomeCriador(String nomeCriador) {
        //verificarValorNulo(nomeCriador, MENSAGEM_ERRO_NOME_CRIADOR_NULL);
        verificarVazio(nomeCriador, MENSAGEM_ERRO_NOME_CRIADOR_VAZIO);
        verificarRegex(nomeCriador, REGEX_LETRAS, MENSAGEM_ERRO_NOME_CRIADOR_REGEX);
        verificarTamanhoMinimo(nomeCriador, TAMANHO_NOME_MINIMO, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO);
        verificarTamanhoMaximo(nomeCriador, TAMANHO_NOME_MAXIMO, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO);
        this.nomeCriador = nomeCriador;
    }

    public ZonedDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(ZonedDateTime dataCriacao) {
        verificarValorNulo(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO_NULL);
        verificarDataMinima(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO);
        verificarDataMaxima(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO);
        this.dataCriacao = dataCriacao;
    }

    public String getNomeEditor() {
        return this.nomeEditor;
    }

    public void setNomeEditor(String nomeEditor) {
        verificarValorNulo(nomeEditor, MENSAGEM_ERRO_NOME_EDITOR_NULL);
        verificarVazio(nomeEditor, MENSAGEM_ERRO_NOME_EDITOR_VAZIO);
        verificarRegex(nomeEditor, REGEX_LETRAS, MENSAGEM_ERRO_NOME_EDITOR_REGEX);
        verificarTamanhoMinimo(nomeEditor, TAMANHO_NOME_MINIMO, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO);
        verificarTamanhoMaximo(nomeEditor, TAMANHO_NOME_MAXIMO, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO);
        this.nomeEditor = nomeEditor;
    }

    public ZonedDateTime getDataEdicao() {
        return this.dataEdicao;
    }

    public void setDataEdicao(ZonedDateTime dataEdicao) {
        verificarValorNulo(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO_NULL);
        verificarDataMinima(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO);
        verificarDataMaxima(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO);
        this.dataEdicao = dataEdicao;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, JSON_STYLE);
    }
}
