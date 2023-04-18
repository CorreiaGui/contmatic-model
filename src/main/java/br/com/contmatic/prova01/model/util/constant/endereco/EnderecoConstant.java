package br.com.contmatic.prova01.model.util.constant.endereco;

public final class EnderecoConstant {
	
	private EnderecoConstant() {}
	
	public static final int TAMANHO_CEP = 8;
	public static final int TAMANHO_COMPLEMENTO = 30;
	public static final int TAMANHO_MINIMO_NUMERO = 1;
	public static final int TAMANHO_MINIMO_COMPLEMENTO = 3;
	public static final int TAMANHO_MINIMO_LOGRADOURO = 3;
	public static final int TAMANHO_MAXIMO_NUMERO = 100000;
	public static final int TAMANHO_LOGRADOURO = 70;
	public static final String REGEX_LETRA = "[A-zà-ú\\s]+";
	public static final String REGEX_NUMERO = "[0-9]*";
	public static final String MENSAGEM_ERRO_CEP_NULL = "O campo CEP é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_CEP_VAZIO = "O campo CEP com espaço em branco é inválido.";
	public static final String MENSAGEM_ERRO_CEP_TAMANHO = "O campo CEP diferente de oito caracteres é inválido.";
	public static final String MENSAGEM_ERRO_CEP_REGEX = "O campo CEP não permite letras, apenas números.";
	public static final String MENSAGEM_ERRO_LOGRADOURO_NULL = "O campo logradouro é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_LOGRADOURO_VAZIO = "O campo logradouro com apenas espaços em branco é inválido.";
	public static final String MENSAGEM_ERRO_LOGRADOURO_TAMANHO = "O campo logradouro excedeu o limite de caracteres.";
	public static final String MENSAGEM_ERRO_LOGRADOURO_REGEX = "O campo nome logradouro com números é inválido";
	public static final String MENSAGEM_ERRO_COMPLEMENTO_NULL = "O campo complemento é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_COMPLEMENTO_VAZIO = "O campo com espaços em branco é inválido.";
	public static final String MENSAGEM_ERRO_COMPLEMENTO_TAMANHO = "O campo complemento excedeu a quantidade de caracteres permitidos.";
	public static final String MENSAGEM_ERRO_COMPLEMENTO_TAMANHO_MINIMO = "O campo complemento com menos de três caracteres é inválido.";
	public static final String MENSAGEM_ERRO_NUMERO_NULL = "O campo Número é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_NUMERO_MINIMO = "O número do endereço menor que um é inválido";
	public static final String MENSAGEM_ERRO_NUMERO_MAXIMO = "O número do endereço maior que 100000 é inválido";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_LOGRADOURO = "O campo logradouro necessita de pelo três um caracteres.";
	public static final String MENSAGEM_ERRO_CIDADE_NULL  = "O campo cidade é de preenchimento obrigatório.";
}
