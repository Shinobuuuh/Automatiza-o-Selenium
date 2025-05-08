package br.com.teamliquid.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.teamliquid.page.LoginPO;
import br.com.teamliquid.page.PaginaInicialPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutosTest extends BaseTest {

    private static LoginPO loginPage;
    

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.buttonLoginPage.click();
        loginPage.executarAcaoDeLogar("murillo.tester29@gmail.com", "TestsQA123Pass");	

        assertEquals("Conta – Team Liquid Brazil", loginPage.obterTituloPagina());

    }
    
    @Test
    public void TC000_validarSeOBotaoDeInicioFunciona() {
        


        loginPage.buttonLogoPage.click();
        
        
        assertEquals("Team Liquid Brazil | Loja", loginPage.obterTituloPagina());
    }
    

}
