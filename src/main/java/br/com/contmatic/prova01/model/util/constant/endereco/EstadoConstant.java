package br.com.contmatic.prova01.model.util.constant.endereco;

public final class EstadoConstant {
	
	private EstadoConstant() {}
	
	public static final int TAMANHO_SIGLA = 2;
	public static final String REGEX_SIGLA = "(SP|RJ|PR|MA|GO|AC|AL|AP|BA|CE|ES|RS|RN|PI|PE|PR|PB|PA|MG|MS|MT|MA|RO|RR|SC|SE|TO|DF)";
	public static final String REGEX_LETRA = "[A-zà-ú\\s]+";
	public static final String MENSAGEM_ERRO_SIGLA_NULL = "O campo sigla é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_SIGLA_VAZIO = "O campo sigla com espaços em branco é invalido.";
	public static final String MENSAGEM_ERRO_SIGLA_TAMANHO = "O campo sigla permite apenas dois caracteres.";
	public static final String MENSAGEM_ERRO_SIGLA_REGEX = "Singla invalida.";
	public static final int TAMANHO_NOME = 20;
	public static final int TAMANHO_MINIMO_NOME = 3;
	public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome com espaços em branco é inválido.";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome excedeu a quantidade de caracteres.";
	public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo nome do estado com números ou caracteres especiais é inválido.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NOME = "O campo nome do estado necessita de pelo menos três caracteres.";
	public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO_NOME = "O campo nome do estado excedeu o limite de caracteres.";
}
