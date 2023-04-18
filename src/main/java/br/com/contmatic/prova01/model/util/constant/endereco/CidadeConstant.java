package br.com.contmatic.prova01.model.util.constant.endereco;

public final class CidadeConstant {
	
	private CidadeConstant() {}
	
	public static final int TAMANHO_SIGLA = 2;
	public static final int TAMANHO_MINIMO = 1;
	public static final int TAMANHO_MINIMO_NOME = 3;
	public static final int TAMANHO_NOME = 20;
	public static final String REGEX_LETRA = "[A-zà-ú\\s]+";
	public static final String MENSAGEM_ERRO_SIGLA_NULL = "O campo sigla da cidade é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_SIGLA_VAZIO = "O campo sigla com espaços em branco é inválido.";
	public static final String MENSAGEM_ERRO_SIGLA_TAMANHO = "O campo sigla diferente de dois caracteres é inválido.";
	public static final String MENSAGEM_ERRO_SIGLA_REGEX = "O campo sigla da cidade com números ou caracteres especiais é inválido.";
	public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome da cidade é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome com espaços em branco é inválido.";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome da cidade excedeu a quantidade de caracteres.";
	public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo nome com números ou caracteres especiais é inválido.";
	public static final String MENSAGEM_ERRO_ESTADO_NULL = "O campo estado é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO_MINIMO = "O campo nome da cidade com menos de três caractere é inválido.";
}
