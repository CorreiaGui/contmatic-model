package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_NOME;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.util.enums.SiglaEstado;

public class Estado extends Auditoria {

    private SiglaEstado sigla;

    private String nome;

    public Estado(SiglaEstado sigla) {
        this.setSigla(sigla);
    }

    public SiglaEstado getSigla() {
        return sigla;
    }

    public void setSigla(SiglaEstado sigla) {
        verificarValorNulo(sigla, MENSAGEM_ERRO_SIGLA_NULL);
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
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, "nome");
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "nome");
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
