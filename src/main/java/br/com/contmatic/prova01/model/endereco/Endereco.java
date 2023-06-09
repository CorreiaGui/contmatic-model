package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CIDADE_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.REGEX_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_CEP;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_COMPLEMENTO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_LOGRADOURO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_MAXIMO_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_MINIMO_COMPLEMENTO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_MINIMO_LOGRADOURO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_MINIMO_NUMERO;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import java.util.Objects;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Endereco extends Auditoria {
    
	private String cep;

	private String logradouro;
	
	private Integer numero;
	
	private String complemento;
	
	private Cidade cidade;

	public Endereco(String cep, Integer numero, String complemento) {
		this.setCep(cep);
		this.setNumero(numero);
		this.setComplemento(complemento);
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		verificarValorNulo(cep, MENSAGEM_ERRO_CEP_NULL);
		verificarVazio(cep, MENSAGEM_ERRO_CEP_VAZIO);
		verificarRegex(cep, REGEX_NUMERO, MENSAGEM_ERRO_CEP_REGEX);
		verificarTamanho(cep, TAMANHO_CEP, MENSAGEM_ERRO_CEP_TAMANHO);
		this.cep = cep;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		verificarValorNulo(logradouro, MENSAGEM_ERRO_LOGRADOURO_NULL);
		verificarVazio(logradouro, MENSAGEM_ERRO_LOGRADOURO_VAZIO);
		verificarTamanhoMinimo(logradouro, TAMANHO_MINIMO_LOGRADOURO, MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO);
		verificarTamanhoMaximo(logradouro, TAMANHO_LOGRADOURO, MENSAGEM_ERRO_LOGRADOURO_TAMANHO);
		verificarRegex(logradouro, REGEX_LETRA, MENSAGEM_ERRO_LOGRADOURO_REGEX);
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		verificarValorNulo(numero, MENSAGEM_ERRO_NUMERO_NULL);
		verificarValorMinimo(numero, TAMANHO_MINIMO_NUMERO, MENSAGEM_ERRO_NUMERO_MINIMO);
		verificarValorMaximo(numero, TAMANHO_MAXIMO_NUMERO, MENSAGEM_ERRO_NUMERO_MAXIMO);
		this.numero = numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		verificarValorNulo(complemento, MENSAGEM_ERRO_COMPLEMENTO_NULL);
		verificarVazio(complemento, MENSAGEM_ERRO_COMPLEMENTO_VAZIO);
		verificarTamanhoMinimo(complemento, TAMANHO_MINIMO_COMPLEMENTO, MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO);
		verificarTamanhoMaximo(complemento, TAMANHO_COMPLEMENTO, MENSAGEM_ERRO_COMPLEMENTO_TAMANHO);
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		verificarValorNulo(cidade, MENSAGEM_ERRO_CIDADE_NULL);
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, numero);
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
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, MULTI_LINE_STYLE);
	}
}