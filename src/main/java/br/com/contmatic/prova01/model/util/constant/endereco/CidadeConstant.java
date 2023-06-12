package br.com.contmatic.prova01.model.util.constant.endereco;

/**
 * The Class CidadeConstant.
 *
 * @author guilherme.martins
 */
public final class CidadeConstant {

    /**
     * Instantiates a new cidade constant.
     */
    private CidadeConstant() {
    }

    /** The Constant TAMANHO_SIGLA. */
    public static final int TAMANHO_SIGLA = 2;

    /** The Constant TAMANHO_MINIMO. */
    public static final int TAMANHO_MINIMO = 1;

    /** The Constant TAMANHO_MINIMO_NOME. */
    public static final int TAMANHO_MINIMO_NOME = 3;

    /** The Constant TAMANHO_NOME. */
    public static final int TAMANHO_NOME = 20;

    /** The Constant REGEX_LETRA. */
    public static final String REGEX_LETRA = "[A-zà-ú\\s]+";

    /** The Constant MENSAGEM_ERRO_SIGLA_NULL. */
    public static final String MENSAGEM_ERRO_SIGLA_NULL = "O campo sigla da cidade é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_SIGLA_VAZIO. */
    public static final String MENSAGEM_ERRO_SIGLA_VAZIO = "O campo sigla com espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_SIGLA_TAMANHO. */
    public static final String MENSAGEM_ERRO_SIGLA_TAMANHO = "O campo sigla diferente de dois caracteres é inválido.";

    /** The Constant MENSAGEM_ERRO_SIGLA_REGEX. */
    public static final String MENSAGEM_ERRO_SIGLA_REGEX = "O campo sigla da cidade com números ou caracteres especiais é inválido.";

    /** The Constant MENSAGEM_ERRO_NOME_NULL. */
    public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome da cidade é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NOME_VAZIO. */
    public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome com espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_NOME_TAMANHO. */
    public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome da cidade excedeu a quantidade de caracteres.";

    /** The Constant MENSAGEM_ERRO_NOME_REGEX. */
    public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo nome com números ou caracteres especiais é inválido.";

    /** The Constant MENSAGEM_ERRO_ESTADO_NULL. */
    public static final String MENSAGEM_ERRO_ESTADO_NULL = "O campo estado é de preenchimento obrigatório";

    /** The Constant MENSAGEM_ERRO_NOME_TAMANHO_MINIMO. */
    public static final String MENSAGEM_ERRO_NOME_TAMANHO_MINIMO = "O campo nome da cidade com menos de três caractere é inválido.";
}
