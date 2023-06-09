package br.com.contmatic.prova01.model.fixturefactory;

import static br.com.contmatic.prova01.model.util.enums.SiglaEstado.SP;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.endereco.Estado;
import br.com.six2six.fixturefactory.Fixture;

class FixtureEstadoTest {
    
    @BeforeEach
    public void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }
    
    @Test
    void testeEstado() {
       Estado estado = Fixture.from(Estado.class).gimme("valid");
       assertEquals(SP, estado.getSigla());
    }
}
