package br.com.contmatic.prova01.model.fixturefactory;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.endereco.Cidade;
import br.com.contmatic.prova01.model.endereco.Estado;
import br.com.six2six.fixturefactory.Fixture;

class FixtureCidadeTest {
    
    @BeforeEach
    public void set_up(){
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }
    
    @Test
    void testeeeee() {
        Cidade cidade = Fixture.from(Cidade.class).gimme("valid");
        assertEquals(Fixture.from(Estado.class).gimme("valid"), cidade.getEstado());
    }
}
