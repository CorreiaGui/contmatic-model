package br.com.contmatic.prova01.model.util.constant.empresa;

public final class SetorConstant {
	
	private SetorConstant() {}
	
	public static final int TAMANHO_NOME = 40;
	public static final int TAMANHO_MINIMO = 1;
	public static final int TAMANHO_MINIMO_NOME = 3;
	public static final int TAMANHO_LISTA_FUNCIONARIO = 30;
	public static final String MENSAGEM_ERRO_NOME_NULL = "O campo nome do setor é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo nome do setor com espaço em branco é inválido.";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo nome do setor excedeu o limite de caracteres";
	public static final String MENSAGEM_ERRO_LISTA_FUNCIONARIO_NULL = "O campo funcionarios do setor é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_LSITA_FUNCIONARIO_VAZIO = "O campo funcionarios do setor é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_LISTA_FUNCIONARIO_TAMANHO = "A lista de funcionários do setor excedeu o limite de cadastro";
	public static final String MENSAGEM_ERRO_RESPONSAVEL_NULL = "O campo responsável do setor é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NOME = "O campo nome do setor com menos de dois caracteres é inválido.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_FUNCIONARIO = "A lista de funcionários do setor com menos de um item é inválido.";
}
