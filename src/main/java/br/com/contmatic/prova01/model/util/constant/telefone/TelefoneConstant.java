package br.com.contmatic.prova01.model.util.constant.telefone;

/**
 * The Class TelefoneConstant.
 *
 * @author guilherme.martins
 */
public final class TelefoneConstant {

    /**
     * Instantiates a new telefone constant.
     */
    private TelefoneConstant() {
    }

    /** The Constant TAMANHO_MINIMO. */
    public static final int TAMANHO_MINIMO = 1;

    /** The Constant TAMANHO_MINIMO_NUMERO. */
    public static final int TAMANHO_MINIMO_NUMERO = 8;

    /** The Constant TAMANHO_DDI. */
    public static final int TAMANHO_DDI = 4;

    /** The Constant TAMANHO_DDD. */
    public static final int TAMANHO_DDD = 2;

    /** The Constant TAMANHO_NUMERO. */
    public static final int TAMANHO_NUMERO = 9;

    /** The Constant REGEX_DDI. */
    public static final String REGEX_DDI = "[+]?\\d{2,3}";

    /** The Constant REGEX_DDD. */
    public static final String REGEX_DDD = "\\d{2}";

    /** The Constant REGEX_NUMERO. */
    public static final String REGEX_NUMERO = "[0-9]*";

    /** The Constant MENSAGEM_ERRO_DDI_NULL. */
    public static final String MENSAGEM_ERRO_DDI_NULL = "O campo DDI é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_DDI_VAZIO. */
    public static final String MENSAGEM_ERRO_DDI_VAZIO = "O campo DDI com espaço em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_DDI_REGEX. */
    public static final String MENSAGEM_ERRO_DDI_REGEX = "O campo DDI diferente de número é inválido.";

    /** The Constant MENSAGEM_ERRO_DDI_TAMANHO. */
    public static final String MENSAGEM_ERRO_DDI_TAMANHO = "O campo DDI excedeu o limite de caracteres.";

    /** The Constant MENSAGEM_ERRO_DDD_NULL. */
    public static final String MENSAGEM_ERRO_DDD_NULL = "O campo DDD é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_DDD_VAZIO. */
    public static final String MENSAGEM_ERRO_DDD_VAZIO = "O campo DDD com espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_DDD_REGEX. */
    public static final String MENSAGEM_ERRO_DDD_REGEX = "O campo DDD diferente de número é inválido. Exemplo: DDD 11";

    /** The Constant MENSAGEM_ERRO_DDD_TAMANHO. */
    public static final String MENSAGEM_ERRO_DDD_TAMANHO = "O DDD diferente de dois digitos é inválido.";

    /** The Constant MENSAGEM_ERRO_NUMERO_NULL. */
    public static final String MENSAGEM_ERRO_NUMERO_NULL = "O campo Numero é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NUMERO_VAZIO. */
    public static final String MENSAGEM_ERRO_NUMERO_VAZIO = "O campo número com espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_NUMERO_REGEX. */
    public static final String MENSAGEM_ERRO_NUMERO_REGEX = "O campo Número não permite caracteres especiais e letras.";

    /** The Constant MENSAGEM_ERRO_NUMERO_TAMANHO. */
    public static final String MENSAGEM_ERRO_NUMERO_TAMANHO = "O campo número excedeu o limite de caracteres";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_DDI. */
    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_DDI = "O campo DDI necessita de pelo menos um caractere.";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO. */
    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO = "O campo número necessita de pelo menos oito caractere.";

}
