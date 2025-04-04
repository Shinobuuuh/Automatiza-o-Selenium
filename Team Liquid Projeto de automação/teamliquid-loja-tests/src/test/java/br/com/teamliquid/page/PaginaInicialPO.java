package br.com.teamliquid.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaInicialPO extends BasePO{



    @FindBy(css = "#shopify-section-sections--17222502350985__header > sticky-header > header > div > a.header__icon.header__icon--account.link.focus-inset.small-hide.tw-mr-2")
    public WebElement buttonLoginPage;



    public PaginaInicialPO(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
}
