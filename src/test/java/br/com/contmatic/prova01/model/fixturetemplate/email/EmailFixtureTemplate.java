package br.com.contmatic.prova01.model.fixturetemplate.email;

import static br.com.contmatic.prova01.model.util.enums.TipoEmail.PESSOAL;
import static br.com.contmatic.prova01.model.util.enums.TipoEmail.PROFISSIONAL;

import br.com.contmatic.prova01.model.email.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmailFixtureTemplate implements TemplateLoader{

    @Override
    public void load() {
        Fixture.of(Email.class).addTemplate("Email valido", new Rule() {
            {
                add("tipo", random(PESSOAL, PROFISSIONAL));
                add("endereco", random("guilherme@email.com", "outro@email.com"));
            }
        });
    }
}
