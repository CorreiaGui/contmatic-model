package br.com.contmatic.prova01.model.util.constant.email;

public final class EmailConstant {
	
	private EmailConstant() {}

	public static final int TAMANHO_TIPO = 50;
	public static final int TAMANHO_EMAIL = 50;
	public static final int TAMANHO_MINIMO = 6;
	public static final String TIPO_REGEX = "(PESSOAL|PROFISSIONAL)";
	public static final String EMAIL_REGEX = "^[A-z0-9.!#$%&'*+/=?^_`{|}~-]+@[A-z0-9](?:[A-z0-9-]{0,61}[A-z0-9])?(?:\\.[A-z0-9](?:[A-z0-9-]{0,61}[A-z0-9])?)*$";
	public static final String MENSAGEM_ERRO_TIPO_NULL = "O campo 'tipo do email' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TIPO_VAZIO = "O campo 'tipo do email' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TIPO_TAMANHO = "O campo 'tipo do email' excedeu o limite de caracteres.";
	public static final String MENSAGEM_ERRO_EMAIL_NULL = "O campo 'endereço de email' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_EMAIL_VAZIO = "O campo 'endereço de email' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_EMAIL_TAMANHO = "O campo 'endereço de email' excedeu o limite de caracteres.";
	public static final String MENSAGEM_ERRO_EMAIL_TAMANHO_MINIMO = "O campo contém catacteres insuficientes.";
	public static final String MENSAGEM_ERRO_EMAIL_REGEX = "Email inválido. exemplo: emailvalido@dominio.com";
	public static final String MENSAGEM_ERRO_TIPO_REGEX = "O campo 'tipo do email' diferente de Pessoal ou Profissional é inválido";
}
