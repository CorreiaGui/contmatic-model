package br.com.contmatic.prova01.model.fixturetemplate.telefone;

import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Telefone.class).addTemplate("Telefone valido", new Rule() {
            {
                add("ddi", random("12", "55"));
                add("ddd", random("85", "11"));
                add("numero", random("12345678", "948623933"));
            }
        });
    }
}
