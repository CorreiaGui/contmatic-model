package br.com.contmatic.prova01.model.endereco;

import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CEP_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_CIDADE_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_COMPLEMENTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_REGEX;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_LOGRADOURO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_NUMERO_NULL;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.REGEX_LETRA;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.REGEX_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_CEP;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_COMPLEMENTO;
import static br.com.contmatic.prova01.model.util.constant.endereco.EnderecoConstant.TAMANHO_MINIMO_COMPLEMENTO;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco extends Auditoria {
    
    @NotBlank(message = MENSAGEM_ERRO_CEP_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_CEP_NULL)
    @Pattern(regexp = REGEX_NUMERO, message = MENSAGEM_ERRO_CEP_REGEX)
    @Size(min = TAMANHO_CEP, max = TAMANHO_CEP, message = MENSAGEM_ERRO_CEP_TAMANHO)
    private String cep;
    
    @NotBlank(message = MENSAGEM_ERRO_LOGRADOURO_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_LOGRADOURO_NULL)
    @Pattern(regexp = REGEX_LETRA, message = MENSAGEM_ERRO_LOGRADOURO_REGEX)
    @Size(min = TAMANHO_CEP, message = MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO)
    @Size(max = TAMANHO_CEP, message = MENSAGEM_ERRO_LOGRADOURO_TAMANHO)
    private String logradouro;
    
    @NotNull(message = MENSAGEM_ERRO_NUMERO_NULL)
    @Min(value = 1, message = MENSAGEM_ERRO_NUMERO_MINIMO)
    @Max(value = 100000, message = MENSAGEM_ERRO_NUMERO_MAXIMO)
    private Integer numero;
    
    @NotBlank(message = MENSAGEM_ERRO_COMPLEMENTO_VAZIO)
    @Size(min = TAMANHO_MINIMO_COMPLEMENTO, message = MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO)
    @Size( max = TAMANHO_COMPLEMENTO, message = MENSAGEM_ERRO_COMPLEMENTO_TAMANHO)
    private String complemento;
    
    @Valid
    @NotNull(message = MENSAGEM_ERRO_CIDADE_NULL)
    private Cidade cidade;

    public Endereco(String cep, Integer numero, String complemento) {
        this.setCep(cep);
        this.setNumero(numero);
        this.setComplemento(complemento);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(cep)
                .append(numero)
                .append(complemento).toHashCode();
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
        Endereco other = (Endereco) obj;
        return new EqualsBuilder()
                .append(this.cep, other.cep)
                .append(this.numero, other.numero)
                .append(this.complemento, other.complemento).isEquals();
    }
    
    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
