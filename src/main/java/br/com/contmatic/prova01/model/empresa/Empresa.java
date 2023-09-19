package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_LIMITE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_REUNIAO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DOMINIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DOMINIO_ESPACO_BRANCO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DOMINIO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_RAZAO_SOCIAL_ESPACO_BRANCO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_RAZAO_SOCIAL_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SETOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TAMANHO_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_TELEFONE_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.REGEX_ALFANUMERICO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.REGEX_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_SETOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_LISTA_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_STRING;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_NUMERO_INSCRICAO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.REGEX_NOME;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.contmatic.prova01.model.util.enums.NaturezaJuridica;
import br.com.contmatic.prova01.model.util.enums.SituacaoCadastral;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Empresa extends Auditoria {

    @NotBlank(message = MENSAGEM_ERRO_CNPJ_NULL)
    @NotNull(message = MENSAGEM_ERRO_CNPJ_NULL)
    @Pattern(regexp = REGEX_NUMERO, message = MENSAGEM_ERRO_REGEX_CNPJ)
    @Size(min = TAMANHO_CNPJ, max = TAMANHO_CNPJ, message = MENSAGEM_ERRO_TAMANHO_CNPJ)
    @CNPJ(message = MENSAGEM_ERRO_CNPJ)
    private String cnpj;

    @NotNull(message = MENSAGEM_ERRO_DATA_NULA)
    @Past(message = MENSAGEM_ERRO_DATA_LIMITE)
    private LocalDate dataAbertura;

    @NotBlank(message = MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL)
    @Pattern(regexp = REGEX_NUMERO, message = MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO)
    @Size(min = TAMANHO_NUMERO_INSCRICAO, max = TAMANHO_NUMERO_INSCRICAO, message = MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO)
    private String numeroInscricao;

    @Future(message = MENSAGEM_ERRO_DATA_REUNIAO)
    private LocalDateTime dataReuniaoGeral;

    @NotBlank(message = MENSAGEM_ERRO_RAZAO_SOCIAL_ESPACO_BRANCO)
    @NotNull(message = MENSAGEM_ERRO_RAZAO_SOCIAL_NULA)
    @Pattern(regexp = REGEX_NOME, message = MENSAGEM_ERRO_REGEX)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO)
    @Size(max = TAMANHO_MAXIMO_STRING, message = MENSAGEM_ERRO_TAMANHO_MAXIMO)
    private String razaoSocial;

    @NotBlank(message = MENSAGEM_ERRO_NOME_FANTASIA_VAZIO)
    @Pattern(regexp = REGEX_NOME, message = MENSAGEM_ERRO_REGEX)
    @Size(min = TAMANHO_MINIMO, message = MENSAGEM_ERRO_TAMANHO_MINIMO)
    @Size(max = TAMANHO_MAXIMO_STRING, message = MENSAGEM_ERRO_TAMANHO_MAXIMO)
    private String nomeFantasia;

    @Valid
    @NotNull(message = MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL)
    private NaturezaJuridica naturezaJuridica;

    @Valid
    @NotNull(message = MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL)
    private SituacaoCadastral situacaoCadastral;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_ENDERECO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_ENDERECO_NULL)
    @Size(min = TAMANHO_MINIMO_LISTA_ENDERECO, message = MENSAGEM_ERRO_TAMANHO_MINIMO)
    @Size(max = TAMANHO_MAXIMO_LISTA_ENDERECO, message = MENSAGEM_ERRO_TAMANHO_ENDERECO)
    private Set<Endereco> enderecos;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_FUNCIONARIO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_FUNCIONARIO_NULL)
    @Size(min = TAMANHO_MINIMO_LISTA, message = MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA)
    @Size(max = TAMANHO_MAXIMO_LISTA_FUNCIONARIO, message = MENSAGEM_ERRO_TAMANHO_FUNCIONARIO)
    private List<Funcionario> funcionarios;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_PRODUTO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_PRODUTO_NULL)
    @Size(min = TAMANHO_MINIMO_LISTA, message = MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA)
    @Size(max = TAMANHO_MAXIMO_LISTA_PRODUTO, message = MENSAGEM_ERRO_TAMANHO_PRODUTO)
    private Set<Produto> produtos;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_EMAIL_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_EMAIL_NULL)
    @Size(min = TAMANHO_MINIMO_LISTA, message = MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA)
    @Size(max = TAMANHO_MAXIMO_LISTA_EMAIL, message = MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL)
    private Set<Email> emails;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_TELEFONE_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_TELEFONE_NULL)
    @Size(min = TAMANHO_MINIMO_LISTA, message = MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN)
    @Size(max = TAMANHO_MAXIMO_LISTA_TELEFONE, message = MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO)
    private Set<Telefone> telefones;

    @Valid
    @NotEmpty(message = MENSAGEM_ERRO_SETOR_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_SETOR_NULL)
    @Size(min = TAMANHO_MINIMO_LISTA, message = MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO)
    @Size(max = TAMANHO_MAXIMO_LISTA_SETOR, message = MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO)
    private Set<Setor> setores;

    @NotBlank(message = MENSAGEM_ERRO_DOMINIO_ESPACO_BRANCO)
    @Pattern(regexp = REGEX_ALFANUMERICO)
    @Size(min = 3, message = MENSAGEM_ERRO_DOMINIO_TAMANHO)
    @URL(message = MENSAGEM_ERRO_DOMINIO)
    private String dominio;

    public Empresa(String cnpj) {
        this.setCnpj(cnpj);
    }

    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(cnpj).toHashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) obj;
        return new EqualsBuilder().append(this.cnpj, other.cnpj).isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
