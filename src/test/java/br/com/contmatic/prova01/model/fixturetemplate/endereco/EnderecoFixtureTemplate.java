package br.com.contmatic.prova01.model.fixturetemplate.endereco;

import br.com.contmatic.prova01.model.endereco.Cidade;
import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Endereco.class).addTemplate("Endereco valido", new Rule() {
            {
                add("cep", "04136030");
                add("logradouro", "Rua guararema");
                add("numero", Integer.valueOf(772));
                add("complemento", "casa");
                add("cidade", one(Cidade.class, "Cidade valida"));
            }
        });
    }
}
