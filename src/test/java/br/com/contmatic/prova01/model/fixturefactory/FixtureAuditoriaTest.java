package br.com.contmatic.prova01.model.fixturefactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

class FixtureAuditoriaTest {

    @BeforeEach
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova01.model.fixturetemplate.auditoria");
    }

    @Test
    void testeFuncionaPeloAmorDeDEUS() {
        Auditoria audit = Fixture.from(Auditoria.class).gimme("valid");
        assertEquals("Gui", audit.getNomeCriador());
    }

    @Test
    void nao_deve_aceitar_valores_nuilos() {
      Auditoria auditoria = Fixture.from(Auditoria.class).gimme("Auditoria null");
        
      NullPointerException erro = assertThrows(NullPointerException.class, ()-> auditoria.setNomeCriador(null));
      System.out.println(erro.getMessage());
    }
}
