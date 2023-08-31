package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.REGEX_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_RESPONSAVEL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_MAXIMO_NOME;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Setor extends Auditoria {
    
    @NotBlank(message = MENSAGEM_ERRO_NOME_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NOME_NULL)
    @Pattern(regexp = REGEX_NOME, message = MENSAGEM_ERRO_NOME_REGEX)
    @Size(min = TAMANHO_MINIMO_NOME, message = MENSAGEM_ERRO_TAMANHO_MINIMO_NOME)
    @Size(max = TAMANHO_MAXIMO_NOME, message = MENSAGEM_ERRO_NOME_TAMANHO)
    private String nome;
    
    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO)
    @Size(max = TAMANHO_LISTA_FUNCIONARIO, message = MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO)
    private List<Funcionario> funcionarios;
    
    @Valid
    @NotNull(message = MENSAGEM_ERRO_RESPONSAVEL_NULL)
    private Funcionario responsavel;

    public Setor(String nome) {
        this.setNome(nome);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nome).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Setor other = (Setor) obj;
        return new EqualsBuilder()
                .append(this.nome, other.nome).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
