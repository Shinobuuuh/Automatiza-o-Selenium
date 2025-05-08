package br.com.teamliquid.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Classe base para a criação das novas PageObjects
// Todas as pages devem ser herdadas desta classe 
public abstract class BasePO {
    
    /** Driver base que será usado pelas pages */
    protected WebDriver driver;

    /**
     * Construtor base para a criação da fábrica de elementos (PageFactory)
     * @param driver Driver da página atual
     */
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
     * Método que retorna o título da página atual.
     */
    public String obterTituloPagina() {
        return driver.getTitle();
    }

     /**
     * Método que sabe escrever qualquer WebElement do tipo input e da um TAB ao
     * final.
     * 
     * @param input Input a qual será escrito.
     * @param texto Texto que será escrito no Input.
     */
    public void escrever (WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }



    @FindBy(css = "#shopify-section-sections--17222502350985__header > sticky-header > header > div > a.header__icon.header__icon--account.link.focus-inset.small-hide.tw-mr-2")
    public WebElement buttonLoginPage;

    @FindBy(css = "#shopify-section-sections--17222502350985__header > sticky-header > header > a")   
    public WebElement buttonLogoPage;
    
    

    

}
