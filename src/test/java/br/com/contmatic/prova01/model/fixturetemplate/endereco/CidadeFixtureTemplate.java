package br.com.contmatic.prova01.model.fixturetemplate.endereco;

import br.com.contmatic.prova01.model.endereco.Cidade;
import br.com.contmatic.prova01.model.endereco.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CidadeFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Cidade.class).addTemplate("Cidade valida", new Rule() {
            {
                add("nome", random("São Paulo", "São Bernardo"));
                add("estado", one(Estado.class, "Estado valido"));
            }
        });
    }

}
