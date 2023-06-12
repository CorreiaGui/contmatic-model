package br.com.contmatic.prova01.model.util.constant.empresa;

/**
 * The Class EmpresaConstant.
 *
 * @author guilherme.martins
 */
public final class EmpresaConstant {

	/**
	 * Instantiates a new empresa constant.
	 */
	private EmpresaConstant() {
	}

	/** The Constant REGEX_NUMERO. */
	public static final String REGEX_NUMERO = "[0-9]*";
	
	/** The Constant TAMANHO_NUMERO_INSCRICAO. */
	public static final int TAMANHO_NUMERO_INSCRICAO = 9;
	
	/** The Constant TAMANHO_MAXIMO_PRODUTO. */
	public static final int TAMANHO_MAXIMO_PRODUTO = 50;
	
	/** The Constant TAMANHO_MAXIMO_FUNCIONARIO. */
	public static final int TAMANHO_MAXIMO_FUNCIONARIO = 50;
	
	/** The Constant TAMANHO_MAXIMO_ENDERECO. */
	public static final int TAMANHO_MAXIMO_ENDERECO = 3;
	
	/** The Constant TAMANHO_MAXIMO_TELEFONE. */
	public static final int TAMANHO_MAXIMO_TELEFONE = 3;
	
	/** The Constant TAMANHO_MAXIMO_EMAIL. */
	public static final int TAMANHO_MAXIMO_EMAIL = 5;
	
	/** The Constant TAMANHO_MAXIMO_SETOR. */
	public static final int TAMANHO_MAXIMO_SETOR = 10;
	
	/** The Constant TAMANHO_MINIMO_ENDERECO. */
	public static final int TAMANHO_MINIMO_ENDERECO = 1;
	
	/** The Constant TAMANHO_MINIMO_LISTA. */
	public static final int TAMANHO_MINIMO_LISTA = 2;
	
	/** The Constant TAMANHO_MINIMO. */
	public static final int TAMANHO_MINIMO = 3;
	
	/** The Constant TAMANHO_MAXIMO_STRING. */
	public static final int TAMANHO_MAXIMO_STRING = 80;
	
	/** The Constant TAMANHO_CNPJ. */
	public static final int TAMANHO_CNPJ = 14;

	/** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO. */
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO = "O campo contém caracteres insuficientes.";
	
	/** The Constant MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA. */
	public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA = "O campo contém quantidade insuficiente para cadastro.";

	/** The Constant MENSAGEM_ERRO_SETOR_NULL. */
	public static final String MENSAGEM_ERRO_SETOR_NULL = "O campo 'Setor' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_SETOR_VAZIO. */
	public static final String MENSAGEM_ERRO_SETOR_VAZIO = "O campo lista de 'setores' vazio é inválido.";
	
	/** The Constant MENSAGEM_ERRO_TAMANHO_MAXIMO. */
	public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO = "O tamanho máximo de caracteres foi excedido.";

	/** The Constant MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO. */
	public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO = "O número de inscrição deve conter 9 digitos.";
	
	/** The Constant MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO. */
	public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO = "O campo 'número de inscrição' é de preenchimento obrigatório";
	
	/** The Constant MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL. */
	public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL = "O campo 'número de inscrição' é de preenchimento obrigatório";
	
	/** The Constant MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO. */
	public static final String MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO = "O campo Número de Inscrição aceita apenas números.";

	/** The Constant MENSAGEM_ERRO_DATA. */
	public static final String MENSAGEM_ERRO_DATA = "A data inserida é inválida";
	
	/** The Constant MENSAGEM_ERRO_DATA_NULA. */
	public static final String MENSAGEM_ERRO_DATA_NULA = "O campo 'Data de abertura' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_DATA_LIMITE. */
	public static final String MENSAGEM_ERRO_DATA_LIMITE = "A data de abertura da empresa está inválida";

	/** The Constant MENSAGEM_ERRO_RAZAO_SOCIAL_NULA. */
	public static final String MENSAGEM_ERRO_RAZAO_SOCIAL_NULA = "O campo 'razão social' é de preenchimento obrigatório.";

	/** The Constant MENSAGEM_ERRO_NOME_FANTASIA_NULA. */
	public static final String MENSAGEM_ERRO_NOME_FANTASIA_NULA = "O campo 'nome fantasia' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_NOME_FANTASIA_VAZIO. */
	public static final String MENSAGEM_ERRO_NOME_FANTASIA_VAZIO = "O campo 'nome fantasia' é de preenchimento obrigatório.";

	/** The Constant MENSAGEM_ERRO_PORTE_NULL. */
	public static final String MENSAGEM_ERRO_PORTE_NULL = "O valor nulo para Porte da empresa é inválido";
	
	/** The Constant MENSAGEM_ERRO_PORTE_VAZIO. */
	public static final String MENSAGEM_ERRO_PORTE_VAZIO = "O campo Porte é inválido";

	/** The Constant MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_NULL. */
	public static final String MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_NULL = "O valor nulo para Atividade Principal da empresa é inválido";
	
	/** The Constant MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_VAZIO. */
	public static final String MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_VAZIO = "O campo Atividade Principal da empresa vazio é inválido";
	
	/** The Constant MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_NULL. */
	public static final String MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_NULL = "O valor nulo para Atividade Secundária da empresa é inválido";
	
	/** The Constant MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_VAZIO. */
	public static final String MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_VAZIO = "O campo Atividade Secundária da empresa vazio é inválido";
	
	/** The Constant MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL. */
	public static final String MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL = "O campo 'Natureza Jurídica' é de preenchimento obrigatório";

	/** The Constant MENSAGEM_ERRO_NATUREZA_JURIDICA_VAZIO. */
	public static final String MENSAGEM_ERRO_NATUREZA_JURIDICA_VAZIO = "O campo 'Natureza Jurídica' é de preenchimento obrigatório";
	
	/** The Constant MENSAGEM_ERRO_REGEX_NATUREZA_JURIDICA. */
	public static final String MENSAGEM_ERRO_REGEX_NATUREZA_JURIDICA = "O campo natureza jurídica aceita apenas opções pré definidas como; LTDA, EIRELI, S/A e etc";

	/** The Constant MENSAGEM_ERRO_FUNCIONARIO_VAZIO. */
	public static final String MENSAGEM_ERRO_FUNCIONARIO_VAZIO = "O campo 'Funcionarios da empresa' sem um funcionario inserido é inválido.";
	
	/** The Constant MENSAGEM_ERRO_FUNCIONARIO_NULL. */
	public static final String MENSAGEM_ERRO_FUNCIONARIO_NULL = "O campo 'funcionarios da empresa' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_TAMANHO_FUNCIONARIO. */
	public static final String MENSAGEM_ERRO_TAMANHO_FUNCIONARIO = "A quantidade de Funcionarios cadastrados foi excedido.";

	/** The Constant MENSAGEM_ERRO_TAMANHO_ENDERECO. */
	public static final String MENSAGEM_ERRO_TAMANHO_ENDERECO = "O máximo de 'endereços' excedeu o limite de preenchimento.";
	
	/** The Constant MENSAGEM_ERRO_ENDERECO_NULL. */
	public static final String MENSAGEM_ERRO_ENDERECO_NULL = "O campo 'endereço' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_ENDERECO_VAZIO. */
	public static final String MENSAGEM_ERRO_ENDERECO_VAZIO = "O campo 'endereço' é de preenchimento obrigatório.";

	/** The Constant MENSAGEM_ERRO_PRODUTO_NULL. */
	public static final String MENSAGEM_ERRO_PRODUTO_NULL = "O campo 'Produtos' da empresa é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_PRODUTO_VAZIO. */
	public static final String MENSAGEM_ERRO_PRODUTO_VAZIO = "O campo 'Produtos' da empresa é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_TAMANHO_PRODUTO. */
	public static final String MENSAGEM_ERRO_TAMANHO_PRODUTO = "A quantidade de produtos cadastrados foi excedido.";

	/** The Constant MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL. */
	public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL = "O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_SITUACAO_CADASTRAL_VAZIO. */
	public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_VAZIO = "O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_SITUACAO_CADASTRAL_REGEX. */
	public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_REGEX = "O campo situação cadastral aceita apenas valores como ATIVO, INATIVO, DESATIVADO.";

	/** The Constant MENSAGEM_ERRO_CNPJ_VAZIO. */
	public static final String MENSAGEM_ERRO_CNPJ_VAZIO = "O campo 'CNPJ' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_CNPJ_NULL. */
	public static final String MENSAGEM_ERRO_CNPJ_NULL = "O campo 'CNPJ' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_REGEX_CNPJ. */
	public static final String MENSAGEM_ERRO_REGEX_CNPJ = "O campo CNPJ aceita apenas números.";
	
	/** The Constant MENSAGEM_ERRO_TAMANHO_CNPJ. */
	public static final String MENSAGEM_ERRO_TAMANHO_CNPJ = "O campo CNPJ da empresa diferente de 14 digitos é inválido.";

	/** The Constant MENSAGEM_ERRO_TELEFONE_NULL. */
	public static final String MENSAGEM_ERRO_TELEFONE_NULL = "O campo 'telefone' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_TELEFONE_VAZIO. */
	public static final String MENSAGEM_ERRO_TELEFONE_VAZIO = "O campo 'telefone' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN. */
	public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN = "O campo não contém quantidade mínima 2 telefones.";
	
	/** The Constant MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO. */
	public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO = "O campo 'lista de telefone', excedeu a quantidade máxima permitida.";
	
	/** The Constant MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO. */
	public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO = "O campo não contém a quantidade mínima de dois setores.";
	
	/** The Constant MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO. */
	public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO = "O campo 'Setor' excedeu a quantidade maxima.";

	/** The Constant MENSAGEM_ERRO_EMAIL_NULL. */
	public static final String MENSAGEM_ERRO_EMAIL_NULL = "O campo 'e-mail' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_EMAIL_VAZIO. */
	public static final String MENSAGEM_ERRO_EMAIL_VAZIO = "O campo 'e-mail' é de preenchimento obrigatório.";
	
	/** The Constant MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL. */
	public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL = "O campo excedeu a quantidade de e-mails para cadastro.";
}