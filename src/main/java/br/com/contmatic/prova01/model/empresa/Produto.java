package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_CODIGO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_CODIGO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_VALOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_VALOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.REGEX_LETRAS;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.TAMANHO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.VALOR_CODIGO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.VALOR_CODIGO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.VALOR_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.VALOR_MINIMO;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.math.BigDecimal;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Produto extends Auditoria {

    private Integer codigo;

    private String nome;

    private BigDecimal valor;

    public Produto(String nome, Integer codigo) {
        this.setNome(nome);
        this.setCodigo(codigo);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        verificarValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
        verificarVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
        verificarRegex(nome, REGEX_LETRAS, MENSAGEM_ERRO_NOME_REGEX);
        verificarTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_NOME_TAMANHO_MINIMO);
        verificarTamanhoMaximo(nome, TAMANHO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        verificarValorNulo(valor, MENSAGEM_ERRO_VALOR_NULL);
        verificarValorMinimo(valor, VALOR_MINIMO, MENSAGEM_ERRO_VALOR);
        verificarValorMaximo(valor, VALOR_MAXIMO, MENSAGEM_ERRO_VALOR);
        this.valor = valor;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        verificarValorNulo(codigo, MENSAGEM_ERRO_CODIGO_NULL);
        verificarValorMinimo(codigo, VALOR_CODIGO_MINIMO, MENSAGEM_ERRO_CODIGO);
        verificarValorMaximo(codigo, VALOR_CODIGO_MAXIMO, MENSAGEM_ERRO_CODIGO);
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, "valor");
    }
    
    @Override
    public int hashCode() {
        return reflectionHashCode(this, "valor");
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
