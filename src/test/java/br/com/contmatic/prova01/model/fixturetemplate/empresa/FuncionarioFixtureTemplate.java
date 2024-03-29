package br.com.contmatic.prova01.model.fixturetemplate.empresa;

import org.joda.time.LocalDate;

import br.com.contmatic.prova01.model.email.Email;
import br.com.contmatic.prova01.model.empresa.Funcionario;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class FuncionarioFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Funcionario.class).addTemplate("Funcionario valido", new Rule() {
            {
                add("cpf", random("15308679835", "41659541875"));
                add("nome", random("Correia", "Guilherme Correia"));
                add("dataNascimento", new LocalDate(2002, 04, 21));
                add("enderecos", has(1).of(Endereco.class, "Endereco valido"));
                add("emails", has(1).of(Email.class, "Email valido"));
                add("telefones", has(1).of(Telefone.class, "Telefone valido"));
            }
        });
    }
}
