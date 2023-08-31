package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_CODIGO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_NOME_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_VALOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.MENSAGEM_ERRO_VALOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.REGEX_LETRAS;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.TAMANHO_MINIMO_NOME;
import static br.com.contmatic.prova01.model.util.constant.empresa.ProdutoConstant.TAMANHO_NOME;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto extends Auditoria {

    public static final BigDecimal VALOR_MINIMO = BigDecimal.valueOf(0.0);

    public static final BigDecimal VALOR_MAXIMO = BigDecimal.valueOf(10000.0);

    @NotBlank(message = MENSAGEM_ERRO_NOME_VAZIO)
    @NotNull(message = MENSAGEM_ERRO_NOME_NULL)
    @Pattern(regexp = REGEX_LETRAS, message = MENSAGEM_ERRO_NOME_REGEX)
    @Length(min = TAMANHO_MINIMO_NOME, message = MENSAGEM_ERRO_NOME_TAMANHO_MINIMO)
    @Length(max = TAMANHO_NOME, message = MENSAGEM_ERRO_NOME_TAMANHO)
    private String nome;

    @NotNull(message = MENSAGEM_ERRO_VALOR_NULL)
    @Range(min = 1, max = 1000, message = MENSAGEM_ERRO_CODIGO)
    private Integer codigo;

    @DecimalMin(value = "1", message = MENSAGEM_ERRO_VALOR)
    @DecimalMax(value = "10000.00", message = MENSAGEM_ERRO_VALOR)
    @NotNull(message = MENSAGEM_ERRO_VALOR_NULL)
    private BigDecimal valor;

    public Produto(String nome, Integer codigo) {
        this.setNome(nome);
        this.setCodigo(codigo);
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
        Produto other = (Produto) obj;
        return new EqualsBuilder()
                .append(this.nome, other.nome)
                .append(this.codigo, other.codigo).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(codigo).toHashCode();
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
