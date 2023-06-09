
package br.com.contmatic.prova01.model.fixturefactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.empresa.Funcionario;
import br.com.contmatic.prova01.model.empresa.Setor;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

class FixtureFuncionarioTest {

    @BeforeEach
    public void set_up() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate");
    }

    @Test
    void testeFuncionario() {
        Funcionario funcionario = Fixture.from(Funcionario.class).gimme("Funcionario valido");
        Setor setor = Fixture.from(Setor.class).gimme("Setor valido");
        funcionario.setSetor(setor);
        
    }
}
