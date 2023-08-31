package br.com.contmatic.prova01.model.auditoria;

import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_CRIACAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_DATA_EDICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_REGEX;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_CRIADOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_NULL;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_REGEX;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.MENSAGEM_ERRO_NOME_EDITOR_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.REGEX_LETRAS;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.TAMANHO_NOME_MAXIMO;
import static br.com.contmatic.prova01.model.util.constant.auditoria.AuditoriaConstant.TAMANHO_NOME_MINIMO;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.time.ZonedDateTime;

import br.com.contmatic.prova01.model.annotation.Present;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auditoria {

    @NotBlank(message = MENSAGEM_ERRO_NOME_CRIADOR_VAZIO)
    @Pattern(regexp = REGEX_LETRAS, message = MENSAGEM_ERRO_NOME_CRIADOR_REGEX)
    @NotNull(message = MENSAGEM_ERRO_NOME_CRIADOR_NULL)
    @Size(min = TAMANHO_NOME_MINIMO, max = TAMANHO_NOME_MAXIMO, message = MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO)
    private String nomeCriador;

    @NotNull(message = MENSAGEM_ERRO_DATA_CRIACAO_NULL)
    @Present(message = MENSAGEM_ERRO_DATA_CRIACAO)
    private ZonedDateTime dataCriacao;

    @NotBlank(message = MENSAGEM_ERRO_NOME_EDITOR_VAZIO)
    @Pattern(regexp = REGEX_LETRAS, message = MENSAGEM_ERRO_NOME_EDITOR_REGEX)
    @NotNull(message = MENSAGEM_ERRO_NOME_EDITOR_NULL)
    @Size(min = TAMANHO_NOME_MINIMO, max = TAMANHO_NOME_MAXIMO, message = MENSAGEM_ERRO_NOME_EDITOR_TAMANHO)
    private String nomeEditor;

    @NotNull(message = MENSAGEM_ERRO_DATA_EDICAO_NULL)
    @Present(message = MENSAGEM_ERRO_DATA_EDICAO)
    private ZonedDateTime dataEdicao;

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
