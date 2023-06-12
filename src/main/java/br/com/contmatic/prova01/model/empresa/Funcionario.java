package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.CpfUtil.isCpf;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarDataLimite;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarDataMinima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarMaiorIdade;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_REGEX;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_CPF_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_LIMITE;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_MINIMA;
import static br.com.contmatic.prova01.model.util.constant.empresa.FuncionarioConstant.MENSAGEM_ERRO_DATA_NASCIMENTO;
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
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.Set;

import org.joda.time.LocalDate;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;

public class Funcionario extends Auditoria {

    private String cpf;

    private String nome;

    private LocalDate dataNascimento;

    private Set<Endereco> enderecos;

    private Set<Email> emails;

    private Set<Telefone> telefones;

    private Setor setor;

    public Funcionario(String cpf) {
        this.setCpf(cpf);
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        verificarValorNulo(cpf, MENSAGEM_ERRO_CPF_NULL);
        verificarVazio(cpf, MENSAGEM_ERRO_CPF_VAZIO);
        verificarRegex(cpf, REGEX_NUMEROS, MENSAGEM_ERRO_CPF_REGEX);
        verificarTamanho(cpf, TAMAMNHO_CPF, MENSAGEM_ERRO_CPF_TAMANHO);
        isCpf(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        verificarValorNulo(nome, MENSAGEM_ERRO_NOME_NULL);
        verificarVazio(nome, MENSAGEM_ERRO_NOME_VAZIO);
        verificarTamanhoMinimo(nome, TAMANHO_MINIMO_NOME, MENSAGEM_ERRO_TAMANHO_MINIMO_NOME);
        verificarTamanhoMaximo(nome, TAMANHO_MAXIMO_NOME, MENSAGEM_ERRO_NOME_TAMANHO);
        verificarRegex(nome, REGEX_NOME, MENSAGEM_ERRO_NOME_REGEX);
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        verificarValorNulo(dataNascimento, MENSAGEM_ERRO_DATA_NULL);
        verificarDataMinima(dataNascimento, MENSAGEM_ERRO_DATA_MINIMA);
        verificarDataLimite(dataNascimento, MENSAGEM_ERRO_DATA_LIMITE);
        verificarMaiorIdade(dataNascimento, MENSAGEM_ERRO_DATA_NASCIMENTO);
        this.dataNascimento = dataNascimento;
    }

    public Set<Endereco> getEndereco() {
        return this.enderecos;
    }

    public void setEndereco(Set<Endereco> enderecos) {
        verificarValorNulo(enderecos, MENSAGEM_ERRO_ENDERECO_NULL);
        verificarVazio(enderecos, MENSAGEM_ERRO_ENDERECO_VAZIO);
        verificarTamanhoMinimo(enderecos, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_ENDERECO);
        verificarTamanhoMaximo(enderecos, TAMANHO_LISTA_ENDERECO, MENSAGEM_ERRO_ENDERECO_TAMANHO);
        this.enderecos = enderecos;
    }

    public Set<Email> getEmail() {
        return this.emails;
    }

    public void setEmail(Set<Email> emails) {
        verificarValorNulo(emails, MENSAGEM_ERRO_EMAIL_NULL);
        verificarVazio(emails, MENSAGEM_ERRO_EMAIL_VAZIO);
        verificarTamanhoMinimo(emails, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE);
        verificarTamanhoMaximo(emails, TAMANHO_LISTA_EMAIL, MENSAGEM_ERRO_EMAIL_TAMANHO);
        this.emails = emails;
    }

    public Set<Telefone> getTelefone() {
        return this.telefones;
    }

    public void setTelefone(Set<Telefone> telefones) {
        verificarValorNulo(telefones, MENSAGEM_ERRO_TELEFONE_NULL);
        verificarVazio(telefones, MENSAGEM_ERRO_TELEFONE_VAZIO);
        verificarTamanhoMinimo(telefones, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE);
        verificarTamanhoMaximo(telefones, TAMANHO_LISTA_TELEFONE, MENSAGEM_ERRO_TELEFONE_TAMANHO);
        this.telefones = telefones;
    }

    public Setor getSetor() {
        return this.setor;
    }

    public void setSetor(Setor setor) {
        verificarValorNulo(setor, MENSAGEM_ERRO_SETOR_NULL);
        this.setor = setor;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "nome", "dataNascimento", "enderecos", "emails", "telefones", "setor");
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, "nome", "dataNascimento", "enderecos", "emails", "telefones", "setor");
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
