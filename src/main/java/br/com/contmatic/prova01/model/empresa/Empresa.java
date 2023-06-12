package br.com.contmatic.prova01.model.empresa;

import static br.com.contmatic.prova01.model.util.CnpjUtil.isCnpj;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarDataLimite;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarDataMinima;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarRegex;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanho;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMaximo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarTamanhoMinimo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarValorNulo;
import static br.com.contmatic.prova01.model.util.ValidacaoUtil.verificarVazio;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_CNPJ_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_LIMITE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_DATA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_EMAIL_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_ENDERECO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_FUNCIONARIO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_NULA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NOME_FANTASIA_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_NULL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_PRODUTO_VAZIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.MENSAGEM_ERRO_RAZAO_SOCIAL_NULA;
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
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.REGEX_NUMERO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_CNPJ;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_EMAIL;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_FUNCIONARIO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_PRODUTO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_SETOR;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_STRING;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MAXIMO_TELEFONE;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_ENDERECO;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_MINIMO_LISTA;
import static br.com.contmatic.prova01.model.util.constant.empresa.EmpresaConstant.TAMANHO_NUMERO_INSCRICAO;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.contmatic.prova01.model.util.enums.NaturezaJuridica;
import br.com.contmatic.prova01.model.util.enums.SituacaoCadastral;

public class Empresa extends Auditoria {

    private String cnpj;

    private String numeroInscricao;

    private String razaoSocial;

    private String nomeFantasia;

    private NaturezaJuridica naturezaJuridica;

    private SituacaoCadastral situacaoCadastral;

    private LocalDate dataAbertura;

    private Set<Endereco> enderecos;

    private List<Funcionario> funcionarios;

    private Set<Produto> produtos;

    private Set<Email> emails;

    private Set<Telefone> telefones;

    private Set<Setor> setores;

    public Empresa(String cnpj) {
        this.setCnpj(cnpj);
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        verificarValorNulo(cnpj, MENSAGEM_ERRO_CNPJ_NULL);
        verificarVazio(cnpj, MENSAGEM_ERRO_CNPJ_VAZIO);
        verificarRegex(cnpj, REGEX_NUMERO, MENSAGEM_ERRO_REGEX_CNPJ);
        verificarTamanho(cnpj, TAMANHO_CNPJ, MENSAGEM_ERRO_TAMANHO_CNPJ);
        isCnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getNumeroInscricao() {
        return this.numeroInscricao;
    }

    public void setNumeroInscricao(String numeroInscricao) {
        verificarValorNulo(numeroInscricao, MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL);
        verificarVazio(numeroInscricao, MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO);
        verificarRegex(numeroInscricao, REGEX_NUMERO, MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO);
        verificarTamanho(numeroInscricao, TAMANHO_NUMERO_INSCRICAO, MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO);
        this.numeroInscricao = numeroInscricao;
    }

    public LocalDate getDataAbertura() {
        return this.dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        verificarValorNulo(dataAbertura, MENSAGEM_ERRO_DATA_NULA);
        verificarDataMinima(dataAbertura, MENSAGEM_ERRO_DATA);
        verificarDataLimite(dataAbertura, MENSAGEM_ERRO_DATA_LIMITE);
        this.dataAbertura = dataAbertura;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        verificarValorNulo(razaoSocial, MENSAGEM_ERRO_RAZAO_SOCIAL_NULA);
        verificarVazio(razaoSocial, MENSAGEM_ERRO_RAZAO_SOCIAL_NULA);
        verificarTamanhoMinimo(razaoSocial, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO);
        verificarTamanhoMaximo(razaoSocial, TAMANHO_MAXIMO_STRING, MENSAGEM_ERRO_TAMANHO_MAXIMO);
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        verificarValorNulo(nomeFantasia, MENSAGEM_ERRO_NOME_FANTASIA_NULA);
        verificarVazio(nomeFantasia, MENSAGEM_ERRO_NOME_FANTASIA_VAZIO);
        verificarTamanhoMinimo(nomeFantasia, TAMANHO_MINIMO, MENSAGEM_ERRO_TAMANHO_MINIMO);
        verificarTamanhoMaximo(nomeFantasia, TAMANHO_MAXIMO_STRING, MENSAGEM_ERRO_TAMANHO_MAXIMO);
        this.nomeFantasia = nomeFantasia;
    }

    public NaturezaJuridica getNaturezaJuridica() {
        return this.naturezaJuridica;
    }

    public void setNaturezaJuridica(NaturezaJuridica naturezaJuridica) {
        verificarValorNulo(naturezaJuridica, MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL);
        this.naturezaJuridica = naturezaJuridica;
    }

    public Set<Endereco> getEndereco() {
        return this.enderecos;
    }

    public void setEndereco(Set<Endereco> endereco) {
        verificarValorNulo(endereco, MENSAGEM_ERRO_ENDERECO_NULL);
        verificarVazio(endereco, MENSAGEM_ERRO_ENDERECO_VAZIO);
        verificarTamanhoMinimo(endereco, TAMANHO_MINIMO_ENDERECO, MENSAGEM_ERRO_TAMANHO_MINIMO);
        verificarTamanhoMaximo(endereco, TAMANHO_MAXIMO_ENDERECO, MENSAGEM_ERRO_TAMANHO_ENDERECO);
        this.enderecos = endereco;
    }

    public List<Funcionario> getFuncionario() {
        return this.funcionarios;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        verificarValorNulo(funcionario, MENSAGEM_ERRO_FUNCIONARIO_NULL);
        verificarVazio(funcionario, MENSAGEM_ERRO_FUNCIONARIO_VAZIO);
        verificarTamanhoMinimo(funcionario, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
        verificarTamanhoMaximo(funcionario, TAMANHO_MAXIMO_FUNCIONARIO, MENSAGEM_ERRO_TAMANHO_FUNCIONARIO);
        this.funcionarios = funcionario;
    }

    public Set<Produto> getProduto() {
        return this.produtos;
    }

    public void setProduto(Set<Produto> produto) {
        verificarValorNulo(produto, MENSAGEM_ERRO_PRODUTO_NULL);
        verificarVazio(produto, MENSAGEM_ERRO_PRODUTO_VAZIO);
        verificarTamanhoMinimo(produto, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
        verificarTamanhoMaximo(produto, TAMANHO_MAXIMO_PRODUTO, MENSAGEM_ERRO_TAMANHO_PRODUTO);
        this.produtos = produto;
    }

    public SituacaoCadastral getSituacaoCadastral() {
        return this.situacaoCadastral;
    }

    public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
        verificarValorNulo(situacaoCadastral, MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL);
        this.situacaoCadastral = situacaoCadastral;
    }

    public Set<Email> getEmail() {
        return this.emails;
    }

    public void setEmail(Set<Email> emails) {
        verificarValorNulo(emails, MENSAGEM_ERRO_EMAIL_NULL);
        verificarVazio(emails, MENSAGEM_ERRO_EMAIL_VAZIO);
        verificarTamanhoMinimo(emails, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA);
        verificarTamanhoMaximo(emails, TAMANHO_MAXIMO_EMAIL, MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL);
        this.emails = emails;
    }

    public Set<Telefone> getTelefone() {
        return this.telefones;
    }

    public void setTelefone(Set<Telefone> telefones) {
        verificarValorNulo(telefones, MENSAGEM_ERRO_TELEFONE_NULL);
        verificarVazio(telefones, MENSAGEM_ERRO_TELEFONE_VAZIO);
        verificarTamanhoMinimo(telefones, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN);
        verificarTamanhoMaximo(telefones, TAMANHO_MAXIMO_TELEFONE, MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO);
        this.telefones = telefones;
    }

    public Set<Setor> getSetor() {
        return setores;
    }

    public void setSetor(Set<Setor> setores) {
        verificarValorNulo(setores, MENSAGEM_ERRO_SETOR_NULL);
        verificarVazio(setores, MENSAGEM_ERRO_SETOR_VAZIO);
        verificarTamanhoMinimo(setores, TAMANHO_MINIMO_LISTA, MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO);
        verificarTamanhoMaximo(setores, TAMANHO_MAXIMO_SETOR, MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO);
        this.setores = setores;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "numeroInscricao", "razaoSocial", "nomeFantasia", "naturezaJuridica", "situacaoCadastral", "dataAbertura", "enderecos", "funcionarios", "produtos", "emails",
            "telefones", "setores");
    }

    @Override
    public boolean equals(Object obj) {
        return reflectionEquals(this, obj, "numeroInscricao", "razaoSocial", "nomeFantasia", "naturezaJuridica", "situacaoCadastral", "dataAbertura", "enderecos", "funcionarios", "produtos", "emails",
            "telefones", "setores");
    }

    @Override
    public String toString() {
        return reflectionToString(this, JSON_STYLE);
    }
}
