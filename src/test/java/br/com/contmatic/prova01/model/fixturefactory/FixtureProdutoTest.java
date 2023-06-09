package br.com.contmatic.prova01.model.fixturefactory;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.empresa.Produto;
import br.com.six2six.fixturefactory.Fixture;

class FixtureProdutoTest {
    
    @BeforeEach
    public void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate.empresa");
    }
    
    @Test
    void testeProduto() {
        Produto produto = Fixture.from(Produto.class).gimme("Produto valido");
        assertEquals("camisa", produto.getNome());
    }
}
