package br.com.contmatic.prova01.model.fixturefactory;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;

class FixtureTelefoneTest {
    
    @BeforeEach
    public void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }
    
    @Test
    void dasas() {
        Telefone tel = Fixture.from(Telefone.class).gimme("Telefone valido");
        assertEquals("11", tel.getDdd());
    }
}
