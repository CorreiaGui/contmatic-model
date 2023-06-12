package br.com.contmatic.prova01.model.util.constant.empresa;

import java.math.BigDecimal;

/**
 * The Class ProdutoConstant.
 *
 * @author guilherme.martins
 */
public final class ProdutoConstant {

    /**
     * Instantiates a new produto constant.
     */
    private ProdutoConstant() {
    }

    /** The Constant VALOR_MINIMO. */
    public static final BigDecimal VALOR_MINIMO = BigDecimal.valueOf(0.0);

    /** The Constant VALOR_MAXIMO. */
    public static final BigDecimal VALOR_MAXIMO = BigDecimal.valueOf(10000.0);

    /** The Constant VALOR_CODIGO_MAXIMO. */
    public static final Integer VALOR_CODIGO_MAXIMO = 1000;

    /** The Constant VALOR_CODIGO_MINIMO. */
    public static final Integer VALOR_CODIGO_MINIMO = 1;

    /** The Constant TAMANHO_NOME. */
    public static final int TAMANHO_NOME = 60;

    /** The Constant TAMANHO_MINIMO. */
    public static final int TAMANHO_MINIMO = 1;

    /** The Constant TAMANHO_MINIMO_NOME. */
    public static final int TAMANHO_MINIMO_NOME = 2;

    /** The Constant REGEX_LETRAS. */
    public static final String REGEX_LETRAS = "[A-zÁ-ú]*";

    /** The Constant MENSAGEM_ERRO_NOME_NULL. */
    public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome do produto é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_NOME_VAZIO. */
    public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome do produto não permite espaço em branco.";

    /** The Constant MENSAGEM_ERRO_NOME_TAMANHO_MINIMO. */
    public static final String MENSAGEM_ERRO_NOME_TAMANHO_MINIMO = "O campo nome do produto com menos de dois caractere é inválido.";

    /** The Constant MENSAGEM_ERRO_NOME_TAMANHO. */
    public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome do produto excedeu o limite de caracteres";

    /** The Constant MENSAGEM_ERRO_NOME_REGEX. */
    public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo nome do produto com números é inválido.";

    /** The Constant MENSAGEM_ERRO_VALOR_NULL. */
    public static final String MENSAGEM_ERRO_VALOR_NULL = "O campo valor do produto é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_CODIGO_NULL. */
    public static final String MENSAGEM_ERRO_CODIGO_NULL = "O campo código do produto é de preenchimento obrigatório.";

    /** The Constant MENSAGEM_ERRO_VALOR. */
    public static final String MENSAGEM_ERRO_VALOR = "O valor inserido para o produto é inválido";

    /** The Constant MENSAGEM_ERRO_CODIGO. */
    public static final String MENSAGEM_ERRO_CODIGO = "O código do produto é inválido";
}
