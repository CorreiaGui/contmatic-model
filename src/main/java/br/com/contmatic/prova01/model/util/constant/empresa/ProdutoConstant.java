package br.com.contmatic.prova01.model.util.constant.empresa;

import java.math.BigDecimal;

public final class ProdutoConstant {
	
	private ProdutoConstant() {}
	
	public static final BigDecimal VALOR_MINIMO = BigDecimal.valueOf(0.0);
	public static final BigDecimal VALOR_MAXIMO = BigDecimal.valueOf(10000.0);
	public static final Integer VALOR_CODIGO_MAXIMO = 1000;
	public static final Integer VALOR_CODIGO_MINIMO = 1;
	public static final int TAMANHO_NOME = 60;
	public static final int TAMANHO_MINIMO = 1;
	public static final int TAMANHO_MINIMO_NOME = 2;
	public static final String REGEX_LETRAS = "[A-zÁ-ú]*";
	public static final String MENSAGEM_ERRO_NOME_NULL =  "O campo nome do produto é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome do produto não permite espaço em branco.";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO_MINIMO = "O campo nome do produto com menos de dois caractere é inválido.";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome do produto excedeu o limite de caracteres";
	public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo nome do produto com números é inválido.";
	public static final String MENSAGEM_ERRO_VALOR_NULL =  "O campo valor do produto é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_CODIGO_NULL =  "O campo código do produto é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_VALOR = "O valor inserido para o produto é inválido";
	public static final String MENSAGEM_ERRO_CODIGO = "O código do produto é inválido";
}
