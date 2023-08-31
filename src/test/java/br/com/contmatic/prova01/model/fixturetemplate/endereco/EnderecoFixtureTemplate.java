package br.com.contmatic.prova01.model.fixturetemplate.endereco;

import static java.lang.Integer.valueOf;

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
                add("cep", random("12345678", "04136030"));
                add("logradouro", random("Rua guararema", "Rua X"));
                add("numero", random(valueOf(772), valueOf(123)));
                add("complemento", random("casa 1", "casa 3"));
                add("cidade", one(Cidade.class, "Cidade valida"));
            }
        });
    }
}
