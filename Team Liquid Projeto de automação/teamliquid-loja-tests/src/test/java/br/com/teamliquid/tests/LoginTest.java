package br.com.teamliquid.tests;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.teamliquid.page.LoginPO;
import br.com.teamliquid.page.PaginaInicialPO;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;
    private static PaginaInicialPO paginaInicial;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        paginaInicial = new PaginaInicialPO(driver);
        paginaInicial.buttonLoginPage.click();

        assertEquals("Conta – Team Liquid Brazil", loginPage.obterTituloPagina());

    }

    @Test
    public void TC000_naoDeveLogarNoSistemaComUsuarioESenhaBrancos() {

        loginPage.executarAcaoDeLogar("", "");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComUsuarioIncorretoESenhaEmBranco() {

        loginPage.executarAcaoDeLogar("murillo.tester29", "");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComUsuarioEmBrancoESenhaIncorreta() {

        loginPage.executarAcaoDeLogar("", "SenhaIncorreta2133!@#$");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComUsuarioESenhaIncorretos() {

        loginPage.executarAcaoDeLogar("murillo.tester29", "SenhaIncorreta2133!@#$");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComUsuarioCorretoESenhaIncorreta() {

        loginPage.executarAcaoDeLogar("murillo.tester29@gmail.com", "SenhaIncorreta2133!@#$");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC005_naoDeveLogarNoSistemaComUsuarioCorretoESenhaEmBranco() {

        loginPage.executarAcaoDeLogar("murillo.tester29@gmail.com", "");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComUsuarioIncorretoESenhaCorreta() {

        loginPage.executarAcaoDeLogar("murillo.tester29", "TestsQA123Pass");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC007_naoDeveLogarNoSistemaComUsuarioEmBrancoSenhaCorreta() {

        loginPage.executarAcaoDeLogar("", "TestsQA123Pass");

        assertEquals("Erro\nAjuste o seguinte: E-mail ou senha incorretos.", loginPage.obterMensagemErroLogin());

    }

    @Test
    public void TC008_deveLogarNoSistemaComUsuarioESenhaCorretos() {

        loginPage.executarAcaoDeLogar("murillo.tester29@gmail.com", "TestsQA123Pass");

        assertEquals("Sair", loginPage.confirmarLoginString());

        loginPage.buttonRealizarLogoff.click();

    }

    @Test
    public void TC009_deveDeslogarDoSistemaAoClicarNoBotaoSair() {

        paginaInicial.buttonLoginPage.click();
        
        loginPage.executarAcaoDeLogar("murillo.tester29@gmail.com", "TestsQA123Pass");


        loginPage.buttonRealizarLogoff.click();

        assertEquals("Fazer login", paginaInicial.buttonLoginPage.getText());

    }
    

}
