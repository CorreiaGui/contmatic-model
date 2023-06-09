package br.com.contmatic.prova01.model.fixturefactory;

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FixtureSetorTest {
    
    @BeforeEach
    public void set_up() {
        loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }
    
    @Test
    void adasd() {
    }
}
