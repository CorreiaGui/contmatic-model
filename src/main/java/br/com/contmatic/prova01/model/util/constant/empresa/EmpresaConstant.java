package br.com.contmatic.prova01.model.util.constant.empresa;

public final class EmpresaConstant {

    private EmpresaConstant() {
    }

    public static final String MENSAGEM_ERRO_CNPJ = "cnpj inválido.";

    public static final String MESSAGEM_ERRO_CPF = "cpf inválido.";

    public static final String REGEX_NUMERO = "[0-9]*";

    public static final String REGEX_ALFANUMERICO = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$";

    public static final int TAMANHO_NUMERO_INSCRICAO = 9;

    public static final int TAMANHO_MAXIMO_LISTA_PRODUTO = 50;

    public static final int TAMANHO_MAXIMO_LISTA_FUNCIONARIO = 50;

    public static final int TAMANHO_MAXIMO_LISTA_ENDERECO = 3;

    public static final int TAMANHO_MAXIMO_LISTA_TELEFONE = 3;

    public static final int TAMANHO_MAXIMO_LISTA_EMAIL = 5;

    public static final int TAMANHO_MAXIMO_LISTA_SETOR = 10;

    public static final int TAMANHO_MINIMO_LISTA_ENDERECO = 1;

    public static final int TAMANHO_MINIMO_LISTA = 2;

    public static final int TAMANHO_MINIMO = 3;

    public static final int TAMANHO_MAXIMO_STRING = 80;

    public static final int TAMANHO_CNPJ = 14;

    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO = "O campo contém caracteres insuficientes.";

    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_LISTA = "O campo contém quantidade insuficiente para cadastro.";

    public static final String MENSAGEM_ERRO_SETOR_NULL = "O campo 'Setor' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_SETOR_VAZIO = "O campo lista de 'setores' vazio é inválido.";

    public static final String MENSAGEM_ERRO_REGEX = "O campo não aceita caracteres especiais.";

    public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO = "O tamanho máximo de caracteres foi excedido.";

    public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_TAMANHO = "O campo 'número de inscrição' deve conter 9 digitos.";

    public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_VAZIO = "O campo 'número de inscrição' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_NUMERO_INSCRICAO_NULL = "O campo 'número de inscrição' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_REGEX_NUMERO_INSCRICAO = "O campo 'Número de Inscrição' aceita apenas números.";

    public static final String MENSAGEM_ERRO_DATA = "A data inserida para o campo 'Data de abertura' está inválida";

    public static final String MENSAGEM_ERRO_DATA_NULA = "O campo 'Data de abertura' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_DATA_LIMITE = "A 'data de abertura' da empresa está inválida";

    public static final String MENSAGEM_ERRO_DATA_REUNIAO = "A data inseria no campo 'data de reunião' está inválida.";

    public static final String MENSAGEM_ERRO_RAZAO_SOCIAL_NULA = "O campo 'razão social' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_RAZAO_SOCIAL_ESPACO_BRANCO = "O campo 'razão social' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_NOME_FANTASIA_NULA = "O campo 'nome fantasia' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_NOME_FANTASIA_VAZIO = "O campo 'nome fantasia' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_PORTE_NULL = "O campo 'Porte da empresa' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_PORTE_VAZIO = "O campo 'Porte da empresa' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_NULL = "O campo 'Atividade Principal da empresa' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_ATIVIDADE_PRINCIPAL_VAZIO = "O campo 'Atividade Principal da empresa' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_NULL = "O campo 'Atividade Secundária da empresa' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_ATIVIDADE_SECUNDARIA_VAZIO = "O campo 'Atividade Secundária da empresa' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_ATIVIDADE_NATUREZA_JURIDICA_NULL = "O campo 'Natureza Jurídica' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_NATUREZA_JURIDICA_VAZIO = "O campo 'Natureza Jurídica' é de preenchimento obrigatório";

    public static final String MENSAGEM_ERRO_FUNCIONARIO_VAZIO = "O campo 'Funcionarios da empresa' sem um funcionario inserido é inválido.";

    public static final String MENSAGEM_ERRO_FUNCIONARIO_NULL = "O campo 'funcionarios da empresa' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_TAMANHO_FUNCIONARIO = "A quantidade de Funcionarios cadastrados foi excedido.";

    public static final String MENSAGEM_ERRO_TAMANHO_ENDERECO = "O campo 'endereços da empresa' excedeu o limite de preenchimento.";

    public static final String MENSAGEM_ERRO_ENDERECO_NULL = "O campo 'endereço' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_ENDERECO_VAZIO = "O campo 'endereço' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_PRODUTO_NULL = "O campo 'Produtos da empresa' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_PRODUTO_VAZIO = "O campo 'Produtos da empresa' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_TAMANHO_PRODUTO = "A quantidade de produtos cadastrados foi excedido.";

    public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_NULL = "O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_SITUACAO_CADASTRAL_VAZIO = "O campo 'Situação Cadastral' da empresa é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_CNPJ_VAZIO = "O campo 'CNPJ' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_CNPJ_NULL = "O campo 'CNPJ' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_REGEX_CNPJ = "O campo 'CNPJ' aceita apenas números.";

    public static final String MENSAGEM_ERRO_TAMANHO_CNPJ = "O campo 'CNPJ da empresa' diferente de 14 digitos é inválido.";

    public static final String MENSAGEM_ERRO_TELEFONE_NULL = "O campo 'telefone' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_TELEFONE_VAZIO = "O campo 'telefone' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO_MIN = "O campo não contém quantidade mínima 2 telefones.";

    public static final String MENSAGEM_ERRO_TELEFONE_TAMANHO_MAXIMO = "O campo 'lista de telefone', excedeu a quantidade máxima permitida.";

    public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MINIMO = "O campo 'setores da empresa' não contém a quantidade mínima de dois setores cadastrados.";

    public static final String MENSAGEM_ERRO_SETOR_TAMANHO_MAXIMO = "O campo 'Setor' excedeu a quantidade maxima de cadastros.";

    public static final String MENSAGEM_ERRO_EMAIL_NULL = "O campo 'e-mail' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_EMAIL_VAZIO = "O campo 'e-mail' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_DOMINIO_VAZIO = "O campo 'dominio da empresa' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_DOMINIO_ESPACO_BRANCO = "O campo 'dominio da empresa' não permite espaços em branco";
    
    public static final String MENSAGEM_ERRO_DOMINIO = "O 'dominio da empresa' inserido está inválido.";

    public static final String MENSAGEM_ERRO_DOMINIO_TAMANHO = "O campo 'dominio da empresa' nessecita de pelo menos 3 digitos.";

    public static final String MENSAGEM_ERRO_TAMANHO_MAXIMO_EMAIL = "O campo 'Email da empresa' excedeu a quantidade de e-mails para cadastro.";

    public static final String NOME_EXCEDEBDI_LIMITE_CARACTERES = "TESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTETESTE";
}
