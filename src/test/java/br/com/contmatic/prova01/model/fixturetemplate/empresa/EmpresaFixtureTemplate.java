package br.com.contmatic.prova01.model.fixturetemplate.empresa;

import static br.com.contmatic.prova01.model.util.enums.NaturezaJuridica.LTDA;
import static br.com.contmatic.prova01.model.util.enums.SituacaoCadastral.ATIVO;

import org.joda.time.LocalDate;

import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.empresa.Empresa;
import br.com.contmatic.prova01.model.empresa.Funcionario;
import br.com.contmatic.prova01.model.empresa.Produto;
import br.com.contmatic.prova01.model.empresa.Setor;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Empresa.class).addTemplate("Empresa valida", new Rule() {
            {
                add("cnpj", "95324764000149");
                add("numeroInscricao", "123456789");
                add("razaoSocial", "Empresa Teste");
                add("nomeFantasia", "Empresa Teste Fantasia");
                add("naturezaJuridica", LTDA);
                add("situacaoCadastral", ATIVO);
                add("dataAbertura", new LocalDate(2000, 11, 26));
                add("enderecos", has(1).of(Endereco.class, "Endereco valido"));
                add("funcionarios", has(1).of(Funcionario.class, "Funcionario valido"));
                add("produtos", has(1).of(Produto.class, "Produto valido"));
                add("emails", has(1).of(Email.class, "Email valido"));
                add("telefones", has(1).of(Telefone.class, "Telefone valido"));
                add("setores", has(1).of(Setor.class, "Setor sem funcionario"));
            }
        });
    }
}
