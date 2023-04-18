package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
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
import static java.util.Objects.hash;

import java.math.BigDecimal;
import java.util.Objects;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Produto extends Auditoria {

	private String nome;

	private BigDecimal valor;

	private Integer codigo;

	public Produto(String nome, Integer codigo) {
		this.setNome(nome);
		this.setCodigo(codigo);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		verificaValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
		verificaVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
		verificaRegex(nome, REGEX_LETRAS, MENSAGEM_ERRO_NOME_REGEX);
		verificaTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_NOME_TAMANHO_MINIMO);
		verificaTamanhoMaximo(nome, TAMANHO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		verificaValorNulo(valor, MENSAGEM_ERRO_VALOR_NULL);
		verificaValorMinimo(valor, VALOR_MINIMO, MENSAGEM_ERRO_VALOR);
		verificaValorMaximo(valor, VALOR_MAXIMO, MENSAGEM_ERRO_VALOR);
		this.valor = valor;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		verificaValorNulo(codigo, MENSAGEM_ERRO_CODIGO_NULL);
		verificaValorMinimo(codigo, VALOR_CODIGO_MINIMO, MENSAGEM_ERRO_CODIGO);
		verificaValorMaximo(codigo, VALOR_CODIGO_MAXIMO, MENSAGEM_ERRO_CODIGO);
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return hash(codigo);
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
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [nome=");
		builder.append(nome);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
