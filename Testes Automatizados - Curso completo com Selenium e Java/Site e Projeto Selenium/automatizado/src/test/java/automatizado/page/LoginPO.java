package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#region Região dos WebElements
    /** input de e-mail da tela de login */
    @FindBy(id = "email")
    public WebElement inputEmail;

    /** input de senha da tela de login */
    @FindBy(id = "senha")
    public WebElement inputSenha;

    /** button de entrar da tela de login */
    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    /** span da mensagem de erro na tela de login */
    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;
    //#endregion Região dos WebElements

    //#region Construtor
    /**
     * Construtor padrão para a criação de uma nova instância da página de login
     * 
     * @param driver Driver da página de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
    
    //#endregion Construtor

    //#region Métodos

    /**
     * Método que obtem a mensagem disparada na tela
     * 
     * @return Retorna texto da mensagem
     */
    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    /**
     * Método que tenta executar a ação de logar no sistema
     * 
     * @param email E-mail para a testativa de login
     * @param senha Senha para a tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);

        buttonEntrar.click();
    }

    //#endregion Métodos

}
