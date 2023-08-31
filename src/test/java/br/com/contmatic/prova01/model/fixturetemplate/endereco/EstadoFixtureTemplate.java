package br.com.contmatic.prova01.model.fixturetemplate.endereco;

import static br.com.contmatic.prova01.model.util.enums.SiglaEstado.RJ;
import static br.com.contmatic.prova01.model.util.enums.SiglaEstado.SP;

import br.com.contmatic.prova01.model.endereco.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EstadoFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Estado.class).addTemplate("Estado valido", new Rule() {
            {
                add("nome", random("São Paulo", "Rio de Janeiro"));
                add("sigla", random(SP, RJ));
            }
        });
    }
}
