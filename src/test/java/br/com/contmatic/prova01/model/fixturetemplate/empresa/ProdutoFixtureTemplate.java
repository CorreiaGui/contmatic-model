package br.com.contmatic.prova01.model.fixturetemplate.empresa;

import static java.lang.Integer.valueOf;
import static java.math.BigDecimal.valueOf;

import br.com.contmatic.prova01.model.empresa.Produto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProdutoFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Produto.class).addTemplate("Produto valido", new Rule() {
            {
                add("codigo", random(valueOf(1), valueOf(2)));
                add("nome", random("camisa", "boné", "bermuda"));
                add("valor", random(valueOf(69.99), valueOf(1000.5), valueOf(250.5)));
            }
        });
    }
}
