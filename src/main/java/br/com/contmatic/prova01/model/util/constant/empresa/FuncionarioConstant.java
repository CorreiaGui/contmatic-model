package br.com.contmatic.prova01.model.util.constant.empresa;

public final class FuncionarioConstant {
	
	private FuncionarioConstant() {}
	
	public static final int TAMAMNHO_CPF = 11;
	public static final int TAMANHO_MAXIMO_NOME = 80;
	public static final int TAMANHO_LISTA_ENDERECO = 3;
	public static final int TAMANHO_LISTA_EMAIL = 3;
	public static final int TAMANHO_MINIMO = 1;
	public static final int TAMANHO_MINIMO_NOME = 3;
	public static final int TAMANHO_LISTA_TELEFONE = 3;
	public static final String REGEX_NOME = "[A-zà-ú\\s]+";
	public static final String REGEX_NUMEROS = "[0-9]*";
	public static final String MENSAGEM_ERRO_CPF_NULL = "O campo cpf é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_CPF_VAZIO = "O campo cpf do funcionário com espaço em branco é inválido";
	public static final String MENSAGEM_ERRO_CPF_REGEX = "O campo CPF do funcionário com valor diferente de números é inválido";
	public static final String MENSAGEM_ERRO_CPF_TAMANHO = "O campo CPF necessita de onze dígitos.";
	public static final String MENSAGEM_ERRO_NOME_NULL = "O campo NOME do funcionário é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_VAZIO = "O campo NOME do funcionário com espaço em branco é inválido";
	public static final String MENSAGEM_ERRO_NOME_REGEX = "O campo NOME do funcionário diferente do padrão 'Nome Exemplo' é invalido";
	public static final String MENSAGEM_ERRO_NOME_TAMANHO = "O campo NOME do funcionário excedeu o limite de caracteres.";
	public static final String MENSAGEM_ERRO_DATA_NULL = "O campo data de nascimento é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_DATA_MINIMA = "O campo data nascimento está inválida";
	public static final String MENSAGEM_ERRO_DATA_LIMITE = "O campo data nascimento não permite datas futuras";
	public static final String MENSAGEM_ERRO_DATA_NASCIMENTO = "Data de nascimento inválida. A data informada é de uma pessoa menor de idade.";
	public static final String MENSAGEM_ERRO_ENDERECO_NULL = "O campo 'endereço' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_ENDERECO_VAZIO = "O campo 'endereço' não pode conter espaço em branco.";
	public static final String MENSAGEM_ERRO_ENDERECO_TAMANHO = "O campo 'Endereço' excedeu o limite de cadastro.";
	public static final String MENSAGEM_ERRO_EMAIL_NULL = "O campo 'e-mail' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_EMAIL_VAZIO = "O campo lista de e-mail não permite espaço em branco";
	public static final String MENSAGEM_ERRO_EMAIL_TAMANHO = "A lista de e-mail dos funcionário excedeu o limite de cadastro";
	public static final String MENSAGEM_ERRO_TELEFONE_NULL = "O campo 'telefone' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TELEFONE_VAZIO = "O campo lista de telefone não permite espaço em branco.";
	public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO = "O campo 'lista de telefone' excedeu a quantidade máxima de cadastro.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NOME = "O campo nome com menos de três caractere é inválido.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_ENDERECO = "A lista de endereços com menos de um item é inválido.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_EMAIL = "A lista de e-mail com menos de um item é inválido.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_TELEFONE = "A lista de telefone com menos de um item inválido.";
	public static final String MENSAGEM_ERRO_SETOR_NULL = "O campo setor do funcionário é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO = "O campo setor do funcionario excedeu o limite de cadastro permitido.";
}
