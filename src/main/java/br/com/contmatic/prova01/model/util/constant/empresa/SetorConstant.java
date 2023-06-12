package br.com.contmatic.prova01.model.util.constant.empresa;

/**
 * The Class SetorConstant.
 *
 * @author guilherme.martins
 */
public final class SetorConstant {

    /**
     * Instantiates a new setor constant.
     */
    private SetorConstant() {
    }

    /** The Constant TAMANHO_NOME. */
    public static final int TAMANHO_NOME = 40;

    /** The Constant TAMANHO_MINIMO. */
    public static final int TAMANHO_MINIMO = 1;

    /** The Constant TAMANHO_MINIMO_NOME. */
    public static final int TAMANHO_MINIMO_NOME = 3;

    /** The Constant TAMANHO_LISTA_FUNCIONARIO. */
    public static final int TAMANHO_LISTA_FUNCIONARIO = 30;

    /** The Constant MENSAGEM_ERRO_NOME_NULL. */
    public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome do setor é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NOME_VAZIO. */
    public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome do setor com espaço em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_NOME_TAMANHO. */
    public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome do setor excedeu o limite de caracteres";

    /** The Constant MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL. */
    public static final String MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL = "O campo funcionarios do setor é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO. */
    public static final String MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO = "O campo funcionarios do setor é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO. */
    public static final String MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO = "A lista de funcionários do setor excedeu o limite de cadastro";

    /** The Constant MENSAGEM_ERRO_RESPONSAVEL_NULL. */
    public static final String MENSAGEM_ERRO_RESPONSAVEL_NULL = "O campo responsável do setor é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_NOME. */
    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NOME = "O campo nome do setor com menos de dois caracteres é inválido.";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO. */
    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO = "A lista de funcionários do setor com menos de um item é inválido.";
}
