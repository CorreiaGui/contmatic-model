package br.com.contmatic.prova01.model.util.constant.email;

/**
 * The Class EmailConstant.
 *
 * @author guilherme.martins
 */
public final class EmailConstant {

    /**
     * Instantiates a new email constant.
     */
    private EmailConstant() {
    }

    /** The Constant TAMANHO_TIPO. */
    public static final int TAMANHO_TIPO = 50;

    /** The Constant TAMANHO_EMAIL. */
    public static final int TAMANHO_EMAIL = 50;

    /** The Constant TAMANHO_MINIMO. */
    public static final int TAMANHO_MINIMO = 6;

    /** The Constant TIPO_REGEX. */
    public static final String TIPO_REGEX = "(PESSOAL|PROFISSIONAL)";

    /** The Constant EMAIL_REGEX. */
    public static final String EMAIL_REGEX = "^[A-z0-9.!#$%&'*+/=?^_`{|}~-]+@[A-z0-9](?:[A-z0-9-]{0,61}[A-z0-9])?(?:\\.[A-z0-9](?:[A-z0-9-]{0,61}[A-z0-9])?)*$";

    /** The Constant MENSAGEM_ERRO_TIPO_NULL. */
    public static final String MENSAGEM_ERRO_TIPO_NULL = "O campo 'tipo do email' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_TIPO_VAZIO. */
    public static final String MENSAGEM_ERRO_TIPO_VAZIO = "O campo 'tipo do email' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_TIPO_TAMANHO. */
    public static final String MENSAGEM_ERRO_TIPO_TAMANHO = "O campo 'tipo do email' excedeu o limite de caracteres.";

    /** The Constant MENSAGEM_ERRO_EMAIL_NULL. */
    public static final String MENSAGEM_ERRO_EMAIL_NULL = "O campo 'endereço de email' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_EMAIL_VAZIO. */
    public static final String MENSAGEM_ERRO_EMAIL_VAZIO = "O campo 'endereço de email' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_EMAIL_TAMANHO. */
    public static final String MENSAGEM_ERRO_EMAIL_TAMANHO = "O campo 'endereço de email' excedeu o limite de caracteres.";

    /** The Constant MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO. */
    public static final String MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO = "O campo contém catacteres insuficientes.";

    /** The Constant MENSAGEM_ERRO_EMAIL_REGEX. */
    public static final String MENSAGEM_ERRO_EMAIL_REGEX = "Email inválido. exemplo: emailvalido@dominio.com";

    /** The Constant MENSAGEM_ERRO_TIPO_REGEX. */
    public static final String MENSAGEM_ERRO_TIPO_REGEX = "O campo 'tipo do email' diferente de Pessoal ou Profissional é inválido";
}
