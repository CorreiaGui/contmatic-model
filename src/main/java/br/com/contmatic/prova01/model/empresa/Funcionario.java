/*
 * 
 */
package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_MENOR_IDADE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MESSAGEM_ERRO_CPF;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_MINIMA;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_EMAIL_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_ENDERECO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_ENDERECO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_ENDERECO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_SETOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_TELEFONE_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.REGEX_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.REGEX_NUMEROS;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMAMNHO_CPF;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_LISTA_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MAXIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.TAMANHO_MINIMO_NOME;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.br.CPF;
import org.joda.time.LocalDate;

import br.com.contmatic.prova01.model.annotation.FullAge;
import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funcionario extends Auditoria {

    @NotBlank(message = MENSAGEM_ERRO_CPF_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_CPF_NULL)
    @Pattern(regexp = REGEX_NUMEROS, message = MENSAGEM_ERRO_CPF_REGEX)
    @Size(min = TAMAMNHO_CPF, max = TAMAMNHO_CPF, message = MENSAGEM_ERRO_CPF_TAMANHO)
    @CPF(message = MESSAGEM_ERRO_CPF)
    private String cpf;

    @NotBlank(message = MENSAGEM_ERRO_NOME_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NOME_NULL)
    @Size(min = TAMANHO_MINIMO_NOME, message = MENSAGEM_ERRO_TAMANHO_MINIMO_NOME)
    @Size(max = TAMANHO_MAXIMO_NOME, message = MENSAGEM_ERRO_NOME_TAMANHO)
    @Pattern(regexp = REGEX_NOME, message = MENSAGEM_ERRO_NOME_REGEX)
    private String nome;

    @NotNull(message = MENSAGEM_ERRO_DATA_NULL)
    @Past(message = MENSAGEM_ERRO_DATA_MINIMA)
    @FullAge(message = MENSAGEM_ERRO_MENOR_IDADE)
    private LocalDate dataNascimento;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_ENDERECO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_ENDERECO_NULL)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO_ENDERECO)
    @Size(max = TAMANHO_LISTA_ENDERECO, message = MENSAGEM_ERRO_ENDERECO_TAMANHO)
    private Set<Endereco> enderecos;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_EMAIL_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_EMAIL_NULL)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE)
    @Size(max = TAMANHO_LISTA_EMAIL, message = MENSAGEM_ERRO_EMAIL_TAMANHO)
    private Set<Email> emails;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_TELEFONE_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_TELEFONE_NULL)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE)
    @Size(max = TAMANHO_LISTA_TELEFONE, message = MENSAGEM_ERRO_TELEFONE_TAMANHO)
    private Set<Telefone> telefones;

    @Valid
    @NotNull(message = MENSAGEM_ERRO_SETOR_NULL)
    private Setor setor;

    @Null
    private Boolean status = true;

    public Funcionario(String cpf) {
        this.setCpf(cpf);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cpf).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Funcionario other = (Funcionario) obj;
        return new EqualsBuilder().append(this.cpf, other.cpf).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }

}
