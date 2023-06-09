package br.com.contmatic.prova01.model.fixturetemplate.auditoria;

import java.time.ZonedDateTime;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AuditoriaFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Auditoria.class).addTemplate("valid", new Rule() {
            {
                add("nomeCriador", "Gui");
                add("dataCriacao", ZonedDateTime.now());
                add("nomeEditor", "Gui");
                add("dataEdicao", ZonedDateTime.now());
            }
        });

        Fixture.of(Auditoria.class).addTemplate("Auditoria null", new Rule() {
            {
                add("nomeCriador", null);
                add("dataCriacao", null);
                add("nomeEditor", null);
                add("dataEdicao", null);
            }
        });
    }
}
