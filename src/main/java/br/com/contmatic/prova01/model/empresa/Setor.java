package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
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
import static br.com.contmatic.prova01.model.util.constant.empresa.SetorConstant.TAMANHO_NOME;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.List;

import br.com.contmatic.prova01.model.auditoria.Auditoria;

public class Setor extends Auditoria {

    private String nome;

    private List<Funcionario> funcionarios;

    private Funcionario responsavel;

    public Setor(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        verificarValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
        verificarVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
        verificarTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
        verificarTamanhoMaximo(nome, TAMANHO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        verificarValorNulo(funcionarios, MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL);
        verificarVazio(funcionarios, MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO);
        verificarTamanhoMinimo(funcionarios, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO);
        verificarTamanhoMaximo(funcionarios, TAMANHO_LISTA_FUNCIONARIO, MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO);
        this.funcionarios = funcionarios;
    }

    public Funcionario getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        verificarValorNulo(responsavel, MENSAGEM_ERRO_RESPONSAVEL_NULL);
        this.responsavel = responsavel;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "funcionarios", "responsavel");
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, "funcionarios", "responsavel");
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
