package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_ESTADO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.endereco.CidadeConstant.TAMANHO_NOME;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cidade extends Auditoria {

    @NotBlank(message = MENSAGEM_ERRO_NOME_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NOME_NULL)
    @Pattern(regexp = REGEX_LETRA, message = MENSAGEM_ERRO_NOME_REGEX)
    @Size(min = TAMANHO_MINIMO_NOME, message = MENSAGEM_ERRO_NOME_TAMANHO_MINIMO)
    @Size(max = TAMANHO_NOME, message = MENSAGEM_ERRO_NOME_TAMANHO)
    private String nome;

    @Valid
    @NotNull(message = MENSAGEM_ERRO_ESTADO_NULL)
    private Estado estado;

    public Cidade(String nome, Estado estado) {
        this.setNome(nome);
        this.setEstado(estado);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nome).append(estado).toHashCode();
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
        Cidade other = (Cidade) obj;
        return new EqualsBuilder().append(this.nome, other.nome).append(this.estado, other.estado).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
