package br.com.contmatic.prova01.model.email;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_TIPO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TIPO_REGEX;
import static java.util.Objects.hash;

import java.util.Objects;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Email extends Auditoria {

	private String tipo;

	private String endereco;

	public Email(String endereco) {
		this.setEndereco(endereco);
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		verificaValorNulo(tipo, MENSAGEM_ERRO_TIPO_NULL);
		verificaVazio(tipo, MENSAGEM_ERRO_TIPO_VAZIO);
		verificaTamanhoMinimo(tipo, TAMANHO_MINIMO, MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO);
		verificaTamanhoMaximo(tipo, TAMANHO_TIPO, MENSAGEM_ERRO_TIPO_TAMANHO);
		verificaRegex(tipo, TIPO_REGEX, MENSAGEM_ERRO_TIPO_REGEX);
		this.tipo = tipo;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		verificaValorNulo(endereco, MENSAGEM_ERRO_EMAIL_NULL);
		verificaVazio(endereco, MENSAGEM_ERRO_EMAIL_VAZIO);
		verificaTamanhoMaximo(endereco, TAMANHO_EMAIL, MENSAGEM_ERRO_EMAIL_TAMANHO);
		verificaTamanhoMinimo(endereco, TAMANHO_MINIMO, MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO);
		verificaRegex(endereco, EMAIL_REGEX, MENSAGEM_ERRO_EMAIL_REGEX);
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return hash(endereco);
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
		Email other = (Email) obj;
		return Objects.equals(endereco, other.endereco);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [tipo=");
		builder.append(tipo);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
