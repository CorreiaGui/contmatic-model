package br.com.contmatic.prova01.model.util.constant.empresa;

public final class EmpresaConstant {

	private EmpresaConstant() {
	}

	public static final String REGEX_NUMERO = "[0-9]*";
	public static final String REGEX_NATUREZA_JURIDICA = "^(MEI|S[/]?[.]?A|LTDA|EIRELI?|EI|SLU)$";
	public static final String REGEX_SITUACAO_CADASTRAL = "^(ATIVO|INATIVO|REGULAR|CANCELADO|EXTINTO)$";
	public static final int TAMANHO_NUMERO_INSCRICAO = 9;
	public static final int TAMANHO_MAXIMO_PRODUTO = 50;
	public static final int TAMANHO_MAXIMO_FUNCIONARIO = 50;
	public static final int TAMANHO_MAXIMO_ENDERECO = 3;
	public static final int TAMANHO_MAXIMO_TELEFONE = 3;
	public static final int TAMANHO_MAXIMO_EMAIL = 5;
	public static final int TAMANHO_MAXIMO_SETOR = 10;
	public static final int TAMANHO_MINIMO_ENDERECO = 1;
	public static final int TAMANHO_MINIMO_LISTA = 2;
	public static final int TAMANHO_MINIMO = 3;
	public static final int TAMANHO_MAXIMO_STRING = 80;
	public static final int TAMANHO_CNPJ = 14;

	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO = "O campo contém caracteres insuficientes.";
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA = "O campo contém quantidade insuficiente para cadastro.";

	public static final String MENSAGEM_ERRO_SETOR_NULL = "O campo 'Setor' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_SETOR_VAZIO = "O campo lista de 'setores' vazio é inválido.";
	public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO = "O tamanho máximo de caracteres foi excedido.";

	public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO = "O número de inscrição deve conter 9 digitos.";
	public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO = "O campo 'número de inscrição' é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL = "O campo 'número de inscrição' é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO = "O campo Número de Inscrição aceita apenas números.";

	public static final String MENSAGEM_ERRO_DATA = "A data inserida é inválida";
	public static final String MENSAGEM_ERRO_DATA_NULA = "O campo 'Data de abertura' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_DATA_LIMITE = "A data de abertura da empresa está inválida";

	public static final String MENSAGEM_ERRO_RAZAO_SOCIAL_NULA = "O campo 'razão social' é de preenchimento obrigatório.";

	public static final String MENSAGEM_ERRO_NOME_FANTASIA_NULA = "O campo 'nome fantasia' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_NOME_FANTASIA_VAZIO = "O campo 'nome fantasia' é de preenchimento obrigatório.";

	public static final String MENSAGEM_ERRO_PORTE_NULL = "O valor nulo para Porte da empresa é inválido";
	public static final String MENSAGEM_ERRO_PORTE_VAZIO = "O campo Porte é inválido";

	public static final String MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_NULL = "O valor nulo para Atividade Principal da empresa é inválido";
	public static final String MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_VAZIO = "O campo Atividade Principal da empresa vazio é inválido";
	public static final String MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_NULL = "O valor nulo para Atividade Secundária da empresa é inválido";
	public static final String MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_VAZIO = "O campo Atividade Secundária da empresa vazio é inválido";
	public static final String MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL = "O campo 'Natureza Jurídica' é de preenchimento obrigatório";

	public static final String MENSAGEM_ERRO_NATUREZA_JURIDICA_VAZIO = "O campo 'Natureza Jurídica' é de preenchimento obrigatório";
	public static final String MENSAGEM_ERRO_REGEX_NATUREZA_JURIDICA = "O campo natureza jurídica aceita apenas opções pré definidas como; LTDA, EIRELI, S/A e etc";

	public static final String MENSAGEM_ERRO_FUNCIONARIO_VAZIO = "O campo 'Funcionarios da empresa' sem um funcionario inserido é inválido.";
	public static final String MENSAGEM_ERRO_FUNCIONARIO_NULL = "O campo 'funcionarios da empresa' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TAMANHO_FUNCIONARIO = "A quantidade de Funcionarios cadastrados foi excedido.";

	public static final String MENSAGEM_ERRO_TAMANHO_ENDERECO = "O máximo de 'endereços' excedeu o limite de preenchimento.";
	public static final String MENSAGEM_ERRO_ENDERECO_NULL = "O campo 'endereço' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_ENDERECO_VAZIO = "O campo 'endereço' é de preenchimento obrigatório.";

	public static final String MENSAGEM_ERRO_PRODUTO_NULL = "O campo 'Produtos' da empresa é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_PRODUTO_VAZIO = "O campo 'Produtos' da empresa é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TAMANHO_PRODUTO = "A quantidade de produtos cadastrados foi excedido.";

	public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL = "O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_VAZIO = "O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_REGEX = "O campo situação cadastral aceita apenas valores como ATIVO, INATIVO, DESATIVADO.";

	public static final String MENSAGEM_ERRO_CNPJ_VAZIO = "O campo 'CNPJ' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_CNPJ_NULL = "O campo 'CNPJ' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_REGEX_CNPJ = "O campo CNPJ aceita apenas números.";
	public static final String MENSAGEM_ERRO_TAMANHO_CNPJ = "O campo CNPJ da empresa diferente de 14 digitos é inválido.";

	public static final String MENSAGEM_ERRO_TELEFONE_NULL = "O campo 'telefone' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TELEFONE_VAZIO = "O campo 'telefone' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN = "O campo não contém quantidade mínima 2 telefones.";
	public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO = "O campo 'lista de telefone', excedeu a quantidade máxima permitida.";
	public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO = "O campo não contém a quantidade mínima de dois setores.";
	public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO = "O campo 'Setor' excedeu a quantidade maxima.";

	public static final String MENSAGEM_ERRO_EMAIL_NULL = "O campo 'e-mail' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_EMAIL_VAZIO = "O campo 'e-mail' é de preenchimento obrigatório.";
	public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL = "O campo excedeu a quantidade de e-mails para cadastro.";
}