package br.com.contmatic.prova01.model.email;

import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_REGEX;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.MENSAGEM_ERRO_TIPO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.email.EmailConstant.TAMANHO_MINIMO_EMAIL;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.util.enums.TipoEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email extends Auditoria {

    @NotNull(message = MENSAGEM_ERRO_TIPO_EMAIL_NULL)
    private TipoEmail tipo;

    @NotNull(message = MENSAGEM_ERRO_EMAIL_NULL)
    @NotBlank(message = MENSAGEM_ERRO_EMAIL_VAZIO)
    @Size(max = TAMANHO_MAXIMO_EMAIL, message = MENSAGEM_ERRO_EMAIL_TAMANHO_MAXIMO)
    @Size(min = TAMANHO_MINIMO_EMAIL, message = MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO)
    @Pattern(regexp = EMAIL_REGEX, message = MENSAGEM_ERRO_EMAIL_REGEX)
    private String endereco;

    public Email(String endereco) {
        this.setEndereco(endereco);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(endereco).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Email other = (Email) obj;
        return new EqualsBuilder().append(this.endereco, other.endereco).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
