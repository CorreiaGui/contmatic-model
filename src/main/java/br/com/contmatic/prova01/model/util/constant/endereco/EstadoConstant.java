package br.com.contmatic.prova01.model.util.constant.endereco;

/**
 * The Class EstadoConstant.
 *
 * @author guilherme.martins
 */
public final class EstadoConstant {

    /**
     * Instantiates a new estado constant.
     */
    private EstadoConstant() {
    }

    /** The Constant TAMANHO_SIGLA. */
    public static final int TAMANHO_SIGLA = 2;

    /** The Constant REGEX_SIGLA. */
    public static final String REGEX_SIGLA = "(SP|RJ|PR|MA|GO|AC|AL|AP|BA|CE|ES|RS|RN|PI|PE|PR|PB|PA|MG|MS|MT|MA|RO|RR|SC|SE|TO|DF)";

    /** The Constant REGEX_LETRA. */
    public static final String REGEX_LETRA = "[A-zà-ú\\s]+";

    /** The Constant MENSAGEM_ERRO_SIGLA_NULL. */
    public static final String MENSAGEM_ERRO_SIGLA_NULL = "O campo sigla é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_SIGLA_VAZIO. */
    public static final String MENSAGEM_ERRO_SIGLA_VAZIO = "O campo sigla com espaços em branco é invalido.";

    /** The Constant MENSAGEM_ERRO_SIGLA_TAMANHO. */
    public static final String MENSAGEM_ERRO_SIGLA_TAMANHO = "O campo sigla permite apenas dois caracteres.";

    /** The Constant MENSAGEM_ERRO_SIGLA_REGEX. */
    public static final String MENSAGEM_ERRO_SIGLA_REGEX = "Singla invalida.";

    /** The Constant TAMANHO_NOME. */
    public static final int TAMANHO_NOME = 20;

    /** The Constant TAMANHO_MINIMO_NOME. */
    public static final int TAMANHO_MINIMO_NOME = 3;

    /** The Constant MENSAGEM_ERRO_NOME_NULL. */
    public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NOME_VAZIO. */
    public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome com espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_NOME_TAMANHO. */
    public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome excedeu a quantidade de caracteres.";

    /** The Constant MENSAGEM_ERRO_NOME_REGEX. */
    public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo nome do estado com números ou caracteres especiais é inválido.";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_NOME. */
    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NOME = "O campo nome do estado necessita de pelo menos três caracteres.";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME. */
    public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME = "O campo nome do estado excedeu o limite de caracteres.";
}
