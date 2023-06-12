package br.com.contmatic.prova01.model.telefone;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
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
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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
		verificarValorNulo(ddi, MENSAGEM_ERRO_DDI_NULL);
		verificarVazio(ddi, MENSAGEM_ERRO_DDI_VAZIO);
		verificarTamanhoMinimo(ddi, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_DDI);
		verificarTamanhoMaximo(ddi, TAMANHO_DDI, MENSAGEM_ERRO_DDI_TAMANHO);
		verificarRegex(ddi, REGEX_DDI, MENSAGEM_ERRO_DDI_REGEX);
		this.ddi = ddi;
	}

	public String getDdd() {
		return this.ddd;
	}

	public void setDdd(String ddd) {
		verificarValorNulo(ddd, MENSAGEM_ERRO_DDD_NULL);
		verificarVazio(ddd, MENSAGEM_ERRO_DDD_VAZIO);
		verificarRegex(ddd, REGEX_DDD, MENSAGEM_ERRO_DDD_REGEX);
		verificarTamanho(ddd, TAMANHO_DDD, MENSAGEM_ERRO_DDD_TAMANHO);
		this.ddd = ddd;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		verificarValorNulo(numero, MENSAGEM_ERRO_NUMERO_NULL);
		verificarVazio(numero, MENSAGEM_ERRO_NUMERO_VAZIO);
		verificarRegex(numero, REGEX_NUMERO, MENSAGEM_ERRO_NUMERO_REGEX);
		verificarTamanhoMinimo(numero, TAMANHO_MINIMO_NUMERO, MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO);
		verificarTamanhoMaximo(numero, TAMANHO_NUMERO, MENSAGEM_ERRO_NUMERO_TAMANHO);
		this.numero = numero;
	}

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj);
    }
    
    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}