package br.com.contmatic.prova01.model.util.constant.endereco;

/**
 * The Class EnderecoConstant.
 *
 * @author guilherme.martins
 */
public final class EnderecoConstant {

    /**
     * Instantiates a new endereco constant.
     */
    private EnderecoConstant() {
    }

    /** The Constant TAMANHO_CEP. */
    public static final int TAMANHO_CEP = 8;

    /** The Constant TAMANHO_COMPLEMENTO. */
    public static final int TAMANHO_COMPLEMENTO = 30;

    /** The Constant TAMANHO_MINIMO_NUMERO. */
    public static final int TAMANHO_MINIMO_NUMERO = 1;

    /** The Constant TAMANHO_MINIMO_COMPLEMENTO. */
    public static final int TAMANHO_MINIMO_COMPLEMENTO = 3;

    /** The Constant TAMANHO_MINIMO_LOGRADOURO. */
    public static final int TAMANHO_MINIMO_LOGRADOURO = 3;

    /** The Constant TAMANHO_MAXIMO_NUMERO. */
    public static final int TAMANHO_MAXIMO_NUMERO = 100000;

    /** The Constant TAMANHO_LOGRADOURO. */
    public static final int TAMANHO_LOGRADOURO = 70;

    /** The Constant REGEX_LETRA. */
    public static final String REGEX_LETRA = "[A-zà-ú\\s]+";

    /** The Constant REGEX_NUMERO. */
    public static final String REGEX_NUMERO = "[0-9]*";

    /** The Constant MENSAGEM_ERRO_CEP_NULL. */
    public static final String MENSAGEM_ERRO_CEP_NULL = "O campo CEP é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_CEP_VAZIO. */
    public static final String MENSAGEM_ERRO_CEP_VAZIO = "O campo CEP com espaço em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_CEP_TAMANHO. */
    public static final String MENSAGEM_ERRO_CEP_TAMANHO = "O campo CEP diferente de oito caracteres é inválido.";

    /** The Constant MENSAGEM_ERRO_CEP_REGEX. */
    public static final String MENSAGEM_ERRO_CEP_REGEX = "O campo CEP não permite letras, apenas números.";

    /** The Constant MENSAGEM_ERRO_LOGRADOURO_NULL. */
    public static final String MENSAGEM_ERRO_LOGRADOURO_NULL = "O campo logradouro é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_LOGRADOURO_VAZIO. */
    public static final String MENSAGEM_ERRO_LOGRADOURO_VAZIO = "O campo logradouro com apenas espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_LOGRADOURO_TAMANHO. */
    public static final String MENSAGEM_ERRO_LOGRADOURO_TAMANHO = "O campo logradouro excedeu o limite de caracteres.";

    /** The Constant MENSAGEM_ERRO_LOGRADOURO_REGEX. */
    public static final String MENSAGEM_ERRO_LOGRADOURO_REGEX = "O campo nome logradouro com números é inválido";

    /** The Constant MENSAGEM_ERRO_COMPLEMENTO_NULL. */
    public static final String MENSAGEM_ERRO_COMPLEMENTO_NULL = "O campo complemento é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_COMPLEMENTO_VAZIO. */
    public static final String MENSAGEM_ERRO_COMPLEMENTO_VAZIO = "O campo com espaços em branco é inválido.";

    /** The Constant MENSAGEM_ERRO_COMPLEMENTO_TAMANHO. */
    public static final String MENSAGEM_ERRO_COMPLEMENTO_TAMANHO = "O campo complemento excedeu a quantidade de caracteres permitidos.";

    /** The Constant MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO. */
    public static final String MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO = "O campo complemento com menos de três caracteres é inválido.";

    /** The Constant MENSAGEM_ERRO_NUMERO_NULL. */
    public static final String MENSAGEM_ERRO_NUMERO_NULL = "O campo Número é de preenchimento obrigatório";

    /** The Constant MENSAGEM_ERRO_NUMERO_MINIMO. */
    public static final String MENSAGEM_ERRO_NUMERO_MINIMO = "O número do endereço menor que um é inválido";

    /** The Constant MENSAGEM_ERRO_NUMERO_MAXIMO. */
    public static final String MENSAGEM_ERRO_NUMERO_MAXIMO = "O número do endereço maior que 100000 é inválido";

    /** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO. */
    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO = "O campo logradouro necessita de pelo três um caracteres.";

    /** The Constant MENSAGEM_ERRO_CIDADE_NULL. */
    public static final String MENSAGEM_ERRO_CIDADE_NULL = "O campo cidade é de preenchimento obrigatório.";
}
