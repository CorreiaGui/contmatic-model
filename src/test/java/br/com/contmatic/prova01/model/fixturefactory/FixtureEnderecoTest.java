package br.com.contmatic.prova01.model.fixturefactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

class FixtureEnderecoTest {
    
    @BeforeEach
    public void set_up() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }
    
    @Test
    void testeEndereco() {
        Endereco endereco = Fixture.from(Endereco.class).gimme("Endereco valido");
        assertEquals("Rua guararema", endereco.getLogradouro());
    }
}
