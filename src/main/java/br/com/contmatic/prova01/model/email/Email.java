package br.com.contmatic.prova01.model.email;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_MINIMO;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.util.enums.TipoEmail;

public class Email extends Auditoria {

    private TipoEmail tipo;

    private String endereco;

    public Email(String endereco) {
        this.setEndereco(endereco);
    }

    public TipoEmail getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmail tipo) {
        verificarValorNulo(tipo, MENSAGEM_ERRO_TIPO_NULL);
        this.tipo = tipo;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        verificarValorNulo(endereco, MENSAGEM_ERRO_EMAIL_NULL);
        verificarVazio(endereco, MENSAGEM_ERRO_EMAIL_VAZIO);
        verificarTamanhoMaximo(endereco, TAMANHO_EMAIL, MENSAGEM_ERRO_EMAIL_TAMANHO);
        verificarTamanhoMinimo(endereco, TAMANHO_MINIMO, MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO);
        verificarRegex(endereco, EMAIL_REGEX, MENSAGEM_ERRO_EMAIL_REGEX);
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, this.endereco);
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, this.endereco);
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
