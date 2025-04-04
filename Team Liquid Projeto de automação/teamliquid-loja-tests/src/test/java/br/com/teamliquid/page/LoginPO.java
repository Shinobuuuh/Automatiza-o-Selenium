package br.com.teamliquid.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPO extends BasePO {

    
    @FindBy(id = "CustomerEmail")
    public WebElement inputEmail;

    @FindBy(id = "CustomerPassword")
    public WebElement inputSenha;

    @FindBy(css = "#customer_login > button")
    public WebElement buttonFazerLogin;
    
    @FindBy(css = "#customer_login > h2")
    public WebElement spanMessage1;

    @FindBy(css = "#customer_login > div.errors > ul > li")
    public WebElement spanMessage2;

    @FindBy(css = "#shopify-section-template--17222508281993__main > div > div:nth-child(1) > a")
    public WebElement buttonRealizarLogoff;



    public LoginPO(WebDriver driver){
        super(driver);
    }



    public String confirmarLoginString(){
        String mensagem = buttonRealizarLogoff.getText();
        System.out.println("Mensagem: " + mensagem);
        return mensagem;
    }

    public String obterMensagemErroLogin(){
        
        String mensagemCompleta = this.spanMessage1.getText() + " " + this.spanMessage2.getText();



        String mensagem1 = spanMessage1.getText();
        String mensagem2 = spanMessage2.getText();

        System.out.println("Mensagem 1: " + mensagem1);
        System.out.println("Mensagem 2: " + mensagem2);

        
        return mensagemCompleta;

    }


    /**
     * Método que tenta executar a ação de logar no sistema
     * 
     * @param email E-mail para a testativa de login
     * @param senha Senha para a tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha){

        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        buttonFazerLogin.click();
    }

}
