package br.com.contmatic.prova01.model.fixturetemplate.email;

import static br.com.contmatic.prova01.model.util.enums.TipoEmail.PESSOAL;

import br.com.contmatic.prova01.model.email.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmailFixtureTemplate implements TemplateLoader{

    @Override
    public void load() {
        Fixture.of(Email.class).addTemplate("Email valido", new Rule() {
            {
                add("tipo", PESSOAL);
                add("endereco", "guilherme@email.com");
            }
        });
    }

}
