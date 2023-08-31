package br.com.contmatic.prova01.model.telefone;

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
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telefone extends Auditoria {

    @NotBlank(message = MENSAGEM_ERRO_DDI_VAZIO)
    @Pattern(regexp = REGEX_DDI, message = MENSAGEM_ERRO_DDI_REGEX)
    @NotNull(message = MENSAGEM_ERRO_DDI_NULL)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO_DDI)
    @Size(max = TAMANHO_DDI, message = MENSAGEM_ERRO_DDI_TAMANHO)
    private String ddi;

    @NotBlank(message = MENSAGEM_ERRO_DDD_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_DDD_NULL)
    @Pattern(regexp = REGEX_DDD, message = MENSAGEM_ERRO_DDD_REGEX)
    @Size(min = TAMANHO_DDD, max = TAMANHO_DDD, message = MENSAGEM_ERRO_DDD_TAMANHO)
    private String ddd;

    @NotBlank(message = MENSAGEM_ERRO_NUMERO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NUMERO_NULL)
    @Pattern(regexp = REGEX_NUMERO, message = MENSAGEM_ERRO_NUMERO_REGEX)
    @Size(min = TAMANHO_MINIMO_NUMERO, message = MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO)
    @Size(max = TAMANHO_NUMERO, message = MENSAGEM_ERRO_NUMERO_TAMANHO)
    private String numero;

    public Telefone(String ddi, String ddd, String numero) {
        this.setDdi(ddi);
        this.setDdd(ddd);
        this.setNumero(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Telefone that = (Telefone) obj;
        return new EqualsBuilder()
            .append(this.ddd, that.ddd)
            .append(this.ddi, that.ddi)
            .append(this.numero, that.numero)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(ddi)
                .append(ddd)
                .append(numero).toHashCode();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
