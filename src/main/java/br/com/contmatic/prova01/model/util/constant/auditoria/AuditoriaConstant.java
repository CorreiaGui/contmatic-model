package br.com.contmatic.prova01.model.util.constant.auditoria;

public final class AuditoriaConstant {

	private AuditoriaConstant() {
	}

	public static final int TAMANHO_NOME_MINIMO = 3;
	public static final int TAMANHO_NOME_MAXIMO = 50;
	public static final String REGEX_LETRAS = "[A-zà-ú\\s]+";
	public static final String MENSAGEM_ERRO_NOME_CRIADOR_VAZIO = "O campo 'nome do criador' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_CRIADOR_NULL = "O campo 'nome do criador' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO = "O campo nome do criador excedeu o limite de caracteres válidos.";
	public static final String MENSAGEM_ERRO_NOME_CRIADOR_TAMANHO_MINIMO = "O campo nome do criador contém caracteres insuficientes.";
	public static final String MENSAGEM_ERRO_NOME_CRIADOR_REGEX = "Números e caracteres especiais no campo 'nome do criador' é inválido";
	public static final String MENSAGEM_ERRO_NOME_EDITOR_TAMANHO_MINIMO = "O campo nome do editor contém caracteres insuficientes.";
	public static final String MENSAGEM_ERRO_NOME_EDITOR_VAZIO = "O campo 'nome do editor' é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_NOME_EDITOR_NULL = "O campo 'nome do editor' é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_NOME_EDITOR_TAMANHO = "O campo 'nome do editor' excedeu o limite de caracteres válidos.";
	public static final String MENSAGEM_ERRO_NOME_EDITOR_REGEX = "Números e caracteres especiais no campo 'nome do editor' é inválido";
	public static final String MENSAGEM_ERRO_DATA_EDICAO_NULL = "O campo 'data de edição' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_DATA_EDICAO = "A data de edição inserida é inválida.";
	public static final String MENSAGEM_ERRO_DATA_CRIACAO_NULL = "O campo 'data de criação' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_DATA_CRIACAO = "A data de criação inserida é inválida.";
}
