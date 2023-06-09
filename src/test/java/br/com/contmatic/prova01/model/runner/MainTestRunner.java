package br.com.contmatic.prova01.model.runner;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({ "br.com.contmatic.prova01.model.auditoria", "br.com.contmatic.prova01.model.email", "br.com.contmatic.prova01.model.empresa", "br.com.contmatic.prova01.model.endereco",
    "br.com.contmatic.prova01.model.telefone", "br.com.contmatic.prova01.model.fixturefactory"})
class MainTestRunner {
}
