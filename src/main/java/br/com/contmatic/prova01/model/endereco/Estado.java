package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_SIGLA_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.EstadoConstant.TAMANHO_NOME;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.util.enums.SiglaEstado;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estado extends Auditoria {

    @Valid
    @NotNull(message = MENSAGEM_ERRO_SIGLA_NULL)
    private SiglaEstado sigla;

    @NotBlank(message = MENSAGEM_ERRO_NOME_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NOME_NULL)
    @Size(min = TAMANHO_MINIMO_NOME, message = MENSAGEM_ERRO_TAMANHO_MINIMO_NOME)
    @Size(max = TAMANHO_NOME, message = MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME)
    @Pattern(regexp = REGEX_LETRA, message = MENSAGEM_ERRO_NOME_REGEX)
    private String nome;

    public Estado(SiglaEstado sigla) {
        this.setSigla(sigla);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sigla).toHashCode();
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
        Estado other = (Estado) obj;
        return new EqualsBuilder().append(this.sigla, other.sigla).isEquals();
    }
    
    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
