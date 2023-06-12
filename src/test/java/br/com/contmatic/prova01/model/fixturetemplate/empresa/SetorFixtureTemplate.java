package br.com.contmatic.prova01.model.fixturetemplate.empresa;

import br.com.contmatic.prova01.model.empresa.Funcionario;
import br.com.contmatic.prova01.model.empresa.Setor;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class SetorFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Setor.class).addTemplate("Setor valido", new Rule() {
            {
                add("nome", "adm");
                add("funcionarios", has(1).of(Funcionario.class, "Funcionario valido"));
                add("responsavel", one(Funcionario.class, "Funcionario valido"));
            }
        });
        Fixture.of(Setor.class).addTemplate("Setor sem funcionario", new Rule() {
            {
                add("nome", "adm");
                add("funcionarios", null);
                add("responsavel", null);
            }
        });
    }
}
