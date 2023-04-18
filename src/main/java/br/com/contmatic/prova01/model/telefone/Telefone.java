package br.com.contmatic.prova01.model.telefone;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificaVazio;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_NULL;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_REGEX;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDD_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_NULL;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_REGEX;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_DDI_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_NULL;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_NUMERO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_DDI;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.REGEX_DDD;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.REGEX_DDI;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.REGEX_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_DDD;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_DDI;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_MINIMO_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.telefone.TelefoneConstant.TAMANHO_NUMERO;

import java.util.Objects;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Telefone extends Auditoria {

	private String ddi;

	private String ddd;

	private String numero;

	public Telefone(String ddi, String ddd, String numero) {
		this.setDdi(ddi);
		this.setDdd(ddd);
		this.setNumero(numero);
	}

	public String getDdi() {
		return this.ddi;
	}

	public void setDdi(String ddi) {
		verificaValorNulo(ddi, MENSAGEM_ERRO_DDI_NULL);
		verificaVazio(ddi, MENSAGEM_ERRO_DDI_VAZIO);
		verificaTamanhoMinimo(ddi, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_DDI);
		verificaTamanhoMaximo(ddi, TAMANHO_DDI, MENSAGEM_ERRO_DDI_TAMANHO);
		verificaRegex(ddi, REGEX_DDI, MENSAGEM_ERRO_DDI_REGEX);
		this.ddi = ddi;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		verificaValorNulo(ddd, MENSAGEM_ERRO_DDD_NULL);
		verificaVazio(ddd, MENSAGEM_ERRO_DDD_VAZIO);
		verificaRegex(ddd, REGEX_DDD, MENSAGEM_ERRO_DDD_REGEX);
		verificaTamanho(ddd, TAMANHO_DDD, MENSAGEM_ERRO_DDD_TAMANHO);
		this.ddd = ddd;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		verificaValorNulo(numero, MENSAGEM_ERRO_NUMERO_NULL);
		verificaVazio(numero, MENSAGEM_ERRO_NUMERO_VAZIO);
		verificaRegex(numero, REGEX_NUMERO, MENSAGEM_ERRO_NUMERO_REGEX);
		verificaTamanhoMinimo(numero, TAMANHO_MINIMO_NUMERO, MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO);
		verificaTamanhoMaximo(numero, TAMANHO_NUMERO, MENSAGEM_ERRO_NUMERO_TAMANHO);
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, ddi, numero);
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
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [ddi=");
		builder.append(ddi);
		builder.append(", ddd=");
		builder.append(ddd);
		builder.append(", numero=");
		builder.append(numero);
		builder.append("]");
		return builder.toString();
	}
}