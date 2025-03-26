package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;;

public class GooglePO extends BasePO {


    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "hdtb-tls")
    public WebElement idFerramentas;


    /**
     * Construtor para a criação da página do Google
     * @param driver
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }
    

    /**
     * Método que irá efetuar uma pesquisa no google baseando no texto informado e concluindo com enter
     * @param texto
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    
    /**
     * Método que retorna o resultado da pesquisa (no caso estamos conferindo se existe a palavra "Ferramentas" no determinado campo ID)
     * @return Retorna o resultado
     */
    public String obterResultadoDaPesquisa(){
        return idFerramentas.getText();
    }

}
