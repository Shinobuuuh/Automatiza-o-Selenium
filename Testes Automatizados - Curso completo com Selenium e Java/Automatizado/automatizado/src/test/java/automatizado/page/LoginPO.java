package automatizado.page;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPO extends BasePO {



    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;



    /**
     * Construtor padrão para a criação de uma nova instância da página de login
     * @param driver Driver da página de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }


    public void escrever(WebElement input, String texto){
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }


    public String obterMensagem(){
        return this.spanMensagem.getText();
    }


    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email E-mail para a testativa de login
     * @param senha Senha para a tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail, email);
        escrever(inputSenha, senha);

        buttonEntrar.click();
    }

    public String obterTituloPagina(){
        return driver.getTitle();
    }

    
}
