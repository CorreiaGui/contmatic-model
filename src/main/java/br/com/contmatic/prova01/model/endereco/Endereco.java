package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
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

import java.util.Objects;

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
		verificaValorNulo(cep, MENSAGEM_ERRO_CEP_NULL);
		verificaVazio(cep, MENSAGEM_ERRO_CEP_VAZIO);
		verificaRegex(cep, REGEX_NUMERO, MENSAGEM_ERRO_CEP_REGEX);
		verificaTamanho(cep, TAMANHO_CEP, MENSAGEM_ERRO_CEP_TAMANHO);
		this.cep = cep;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		verificaValorNulo(logradouro, MENSAGEM_ERRO_LOGRADOURO_NULL);
		verificaVazio(logradouro, MENSAGEM_ERRO_LOGRADOURO_VAZIO);
		verificaTamanhoMinimo(logradouro, TAMANHO_MINIMO_LOGRADOURO, MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO);
		verificaTamanhoMaximo(logradouro, TAMANHO_LOGRADOURO, MENSAGEM_ERRO_LOGRADOURO_TAMANHO);
		verificaRegex(logradouro, REGEX_LETRA, MENSAGEM_ERRO_LOGRADOURO_REGEX);
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		verificaValorNulo(numero, MENSAGEM_ERRO_NUMERO_NULL);
		verificaValorMinimo(numero, TAMANHO_MINIMO_NUMERO, MENSAGEM_ERRO_NUMERO_MINIMO);
		verificaValorMaximo(numero, TAMANHO_MAXIMO_NUMERO, MENSAGEM_ERRO_NUMERO_MAXIMO);
		this.numero = numero;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		verificaValorNulo(complemento, MENSAGEM_ERRO_COMPLEMENTO_NULL);
		verificaVazio(complemento, MENSAGEM_ERRO_COMPLEMENTO_VAZIO);
		verificaTamanhoMinimo(complemento, TAMANHO_MINIMO_COMPLEMENTO, MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO);
		verificaTamanhoMaximo(complemento, TAMANHO_COMPLEMENTO, MENSAGEM_ERRO_COMPLEMENTO_TAMANHO);
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		verificaValorNulo(cidade, MENSAGEM_ERRO_CIDADE_NULL);
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
		StringBuilder builder = new StringBuilder();
		builder.append("Endereco [cep=");
		builder.append(cep);
		builder.append(", logradouro=");
		builder.append(logradouro);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", complemento=");
		builder.append(complemento);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}