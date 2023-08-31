package br.com.contmatic.prova01.model.fixturetemplate.auditoria;

import static br.com.six2six.fixturefactory.Fixture.of;

import java.time.ZonedDateTime;

import br.com.contmatic.prova01.model.auditoria.Auditoria;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AuditoriaFixtureTemplate implements TemplateLoader {

    @Override
    public void load() {
        of(Auditoria.class).addTemplate("valid", new Rule() {
            {
                add("nomeCriador", random("Gui", "outro"));
                add("dataCriacao", ZonedDateTime.now());
                add("nomeEditor", random("Gui", "outro"));
                add("dataEdicao", ZonedDateTime.now());
            }
        }); 

        of(Auditoria.class).addTemplate("Auditoria null", new Rule() {
            {
                add("nomeCriador", null);
                add("dataCriacao", null);
                add("nomeEditor", null);
                add("dataEdicao", null);
            }
        });

        of(Auditoria.class).addTemplate("Auditoria vazio", new Rule() {
            {
                add("nomeCriador", "");
                add("dataCriacao", null);
                add("nomeEditor", "");
                add("dataEdicao", null);
            }
        });
        
        of(Auditoria.class).addTemplate("Auditoria invalida", new Rule() {
            {
                add("nomeCriador", "123123");
                add("dataCriacao", null);
                add("nomeEditor", "123123");
                add("dataEdicao", null);
            }
        });
        
        of(Auditoria.class).addTemplate("Auditoria caracteres insuficientes", new Rule() {
            {
                add("nomeCriador", "ab");
                add("dataCriacao", null);
                add("nomeEditor", "ab");
                add("dataEdicao", null);
            }
        });
        
        of(Auditoria.class).addTemplate("Auditoria caracteres excedendo tamanho maximo", new Rule() {
            {
                add("nomeCriador", "testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste");
                add("dataCriacao", null);
                add("nomeEditor", "testetestetestetestetestetestetestetestetestetestetestetestetestetestetestetesteteste");
                add("dataEdicao", null);
            }
        });
    }
}
