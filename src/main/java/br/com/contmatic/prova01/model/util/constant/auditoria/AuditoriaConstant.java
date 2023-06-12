package br.com.contmatic.prova01.model.util.constant.auditoria;

/**
 * The Class AuditoriaConstant.
 *
 * @author guilherme.martins
 */
public final class AuditoriaConstant {

    /**
     * Instantiates a new auditoria constant.
     */
    private AuditoriaConstant() {
    }

    /** The Constant TAMANHO_NOME_MINIMO. */
    public static final int TAMANHO_NOME_MINIMO = 3;

    /** The Constant TAMANHO_NOME_MAXIMO. */
    public static final int TAMANHO_NOME_MAXIMO = 50;

    /** The Constant REGEX_LETRAS. */
    public static final String REGEX_LETRAS = "[A-zà-ú\\s]+";

    /** The Constant MENSAGEM_ERRO_NOME_CRIADOR_VAZIO. */
    public static final String MENSAGEM_ERRO_NOME_CRIADOR_VAZIO = "O campo 'nome do criador' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NOME_CRIADOR_NULL. */
    public static final String MENSAGEM_ERRO_NOME_CRIADOR_NULL = "O campo 'nome do criador' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO. */
    public static final String MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO = "O campo nome do criador excedeu o limite de caracteres válidos.";

    /** The Constant MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO. */
    public static final String MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO = "O campo nome do criador contém caracteres insuficientes.";

    /** The Constant MENSAGEM_ERRO_NOME_CRIADOR_REGEX. */
    public static final String MENSAGEM_ERRO_NOME_CRIADOR_REGEX = "Números e caracteres especiais no campo 'nome do criador' é inválido";

    /** The Constant MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO. */
    public static final String MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO = "O campo nome do editor contém caracteres insuficientes.";

    /** The Constant MENSAGEM_ERRO_NOME_EDITOR_VAZIO. */
    public static final String MENSAGEM_ERRO_NOME_EDITOR_VAZIO = "O campo 'nome do editor' é de preenchimento obrigatório";

    /** The Constant MENSAGEM_ERRO_NOME_EDITOR_NULL. */
    public static final String MENSAGEM_ERRO_NOME_EDITOR_NULL = "O campo 'nome do editor' é de preenchimento obrigatório";

    /** The Constant MENSAGEM_ERRO_NOME_EDITOR_TAMANHO. */
    public static final String MENSAGEM_ERRO_NOME_EDITOR_TAMANHO = "O campo 'nome do editor' excedeu o limite de caracteres válidos.";

    /** The Constant MENSAGEM_ERRO_NOME_EDITOR_REGEX. */
    public static final String MENSAGEM_ERRO_NOME_EDITOR_REGEX = "Números e caracteres especiais no campo 'nome do editor' é inválido";

    /** The Constant MENSAGEM_ERRO_DATA_EDICAO_NULL. */
    public static final String MENSAGEM_ERRO_DATA_EDICAO_NULL = "O campo 'data de edição' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_DATA_EDICAO. */
    public static final String MENSAGEM_ERRO_DATA_EDICAO = "A data de edição inserida é inválida.";

    /** The Constant MENSAGEM_ERRO_DATA_CRIACAO_NULL. */
    public static final String MENSAGEM_ERRO_DATA_CRIACAO_NULL = "O campo 'data de criação' é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_DATA_CRIACAO. */
    public static final String MENSAGEM_ERRO_DATA_CRIACAO = "A data de criação inserida é inválida.";
}
