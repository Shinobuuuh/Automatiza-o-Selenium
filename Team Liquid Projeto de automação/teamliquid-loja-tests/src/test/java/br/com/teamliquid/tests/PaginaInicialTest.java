package br.com.teamliquid.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import br.com.teamliquid.page.PaginaInicialPO;

public class PaginaInicialTest extends BaseTest{

    private static PaginaInicialPO paginaInicial;
    

    @BeforeClass
    public static void prepararTestes(){
        paginaInicial = new PaginaInicialPO(driver);
    }    

}


