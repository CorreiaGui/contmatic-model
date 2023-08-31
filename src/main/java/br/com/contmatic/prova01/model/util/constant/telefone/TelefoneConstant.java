package br.com.contmatic.prova01.model.util.constant.telefone;

public final class TelefoneConstant {

    private TelefoneConstant() {
    }

    public static final int TAMANHO_MINIMO = 1;

    public static final int TAMANHO_MINIMO_NUMERO = 8;
   
    public static final int TAMANHO_DDI = 4;

    public static final int TAMANHO_DDD = 2;
    
    public static final int TAMANHO_NUMERO = 9;

    public static final String REGEX_DDI = "[+]?\\d{2,3}";

    public static final String REGEX_DDD = "\\d{2}";

    public static final String REGEX_NUMERO = "[0-9]*";

    public static final String MENSAGEM_ERRO_DDI_NULL = "O campo 'DDI' é de preenchimento obrigatório.";
    
    public static final String MENSAGEM_ERRO_DDI_VAZIO = "O campo 'DDI' com espaço em branco é inválido.";

    public static final String MENSAGEM_ERRO_DDI_REGEX = "O campo 'DDI' diferente de número é inválido.";

    public static final String MENSAGEM_ERRO_DDI_TAMANHO = "O campo 'DDI' excedeu o limite de caracteres.";

    public static final String MENSAGEM_ERRO_DDD_NULL = "O campo 'DDD' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_DDD_VAZIO = "O campo 'DDD' com espaços em branco é inválido.";

    public static final String MENSAGEM_ERRO_DDD_REGEX = "O campo 'DDD' diferente de número é inválido. Exemplo: DDD 11";

    public static final String MENSAGEM_ERRO_DDD_TAMANHO = "O 'DDD' diferente de dois digitos é inválido.";

    public static final String MENSAGEM_ERRO_NUMERO_NULL = "O campo 'número de telefone' é de preenchimento obrigatório.";

    public static final String MENSAGEM_ERRO_NUMERO_VAZIO = "O campo 'número de telefone' com espaços em branco é inválido.";

    public static final String MENSAGEM_ERRO_NUMERO_REGEX = "O campo 'número de telefone' não permite caracteres especiais e letras.";

    public static final String MENSAGEM_ERRO_NUMERO_TAMANHO = "O campo 'número de telefone' excedeu o limite de caracteres";

    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_DDI = "O campo 'DDI' necessita de pelo menos um caractere.";

    public static final String MENSAGEM_ERRO_TAMANHO_MINIMO_NUMERO = "O campo 'número de telefone' necessita de pelo menos oito caractere.";

}
