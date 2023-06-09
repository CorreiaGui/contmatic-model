package br.com.contmatic.prova01.model.fixturefactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.email.Email;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

class FixtureEmailTest {
    
    @BeforeEach
    public void set_up() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }
    
   @Test
   void adsadas() {
       Email email = Fixture.from(Email.class).gimme("Email valido");
       assertEquals("guilherme@email.com", email.getEndereco());
   }
}
