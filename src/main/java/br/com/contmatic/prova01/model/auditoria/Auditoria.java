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
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * The Class Auditoria.
 */
public class Auditoria {
    
    /** The nome criador. */
    @NotNull(message = MENSAGEM_ERRO_NOME_CRIADOR_NULL)
    @NotEmpty(message = MENSAGEM_ERRO_NOME_CRIADOR_VAZIO)
    @Pattern(regexp = REGEX_LETRAS, message = MENSAGEM_ERRO_NOME_CRIADOR_REGEX)
    private String nomeCriador;

    /** The data criacao. */
    private ZonedDateTime dataCriacao;
    
    /** The nome editor. */
    private String nomeEditor;

    /** The data edicao. */
    private ZonedDateTime dataEdicao;

    /**
     * Gets the nome criador.
     *
     * @return the nome criador
     */
    public String getNomeCriador() {
        return this.nomeCriador;
    } 

    /**
     * Sets the nome criador.
     *
     * @param nomeCriador the new nome criador
     */
    public void setNomeCriador(String nomeCriador) {
        //verificarRegex(nomeCriador, REGEX_LETRAS, MENSAGEM_ERRO_NOME_CRIADOR_REGEX);
        verificarTamanhoMinimo(nomeCriador, TAMANHO_NOME_MINIMO, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO);
        verificarTamanhoMaximo(nomeCriador, TAMANHO_NOME_MAXIMO, MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO);
        this.nomeCriador = nomeCriador;
    }

    /**
     * Gets the data criacao.
     *
     * @return the data criacao
     */
    public ZonedDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    /**
     * Sets the data criacao.
     *
     * @param dataCriacao the new data criacao
     */
    public void setDataCriacao(ZonedDateTime dataCriacao) {
        verificarValorNulo(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO_NULL);
        verificarDataMinima(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO);
        verificarDataMaxima(dataCriacao, MENSAGEM_ERRO_DATA_CRIACAO);
        this.dataCriacao = dataCriacao;
    }

    /**
     * Gets the nome editor.
     *
     * @return the nome editor
     */
    public String getNomeEditor() {
        return this.nomeEditor;
    }

    /**
     * Sets the nome editor.
     *
     * @param nomeEditor the new nome editor
     */
    public void setNomeEditor(String nomeEditor) {
        verificarValorNulo(nomeEditor, MENSAGEM_ERRO_NOME_EDITOR_NULL);
        verificarVazio(nomeEditor, MENSAGEM_ERRO_NOME_EDITOR_VAZIO);
        verificarRegex(nomeEditor, REGEX_LETRAS, MENSAGEM_ERRO_NOME_EDITOR_REGEX);
        verificarTamanhoMinimo(nomeEditor, TAMANHO_NOME_MINIMO, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO);
        verificarTamanhoMaximo(nomeEditor, TAMANHO_NOME_MAXIMO, MENSAGEM_ERRO_NOME_EDITOR_TAMANHO);
        this.nomeEditor = nomeEditor;
    }

    /**
     * Gets the data edicao.
     *
     * @return the data edicao
     */
    public ZonedDateTime getDataEdicao() {
        return this.dataEdicao;
    }

    /**
     * Sets the data edicao.
     *
     * @param dataEdicao the new data edicao
     */
    public void setDataEdicao(ZonedDateTime dataEdicao) {
        verificarValorNulo(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO_NULL);
        verificarDataMinima(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO);
        verificarDataMaxima(dataEdicao, MENSAGEM_ERRO_DATA_EDICAO);
        this.dataEdicao = dataEdicao;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
