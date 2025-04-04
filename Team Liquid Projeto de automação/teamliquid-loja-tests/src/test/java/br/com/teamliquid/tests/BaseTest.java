package br.com.teamliquid.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Classe base que serve de herança para todas as classes de teste
public abstract class BaseTest {

    protected static WebDriver driver;

    private static String URL_BASE = "https://loja.teamliquid.com.br";
    private static String CAMINHO_DRIVER = "src/test/java/br/com/teamliquid/resource/chromedriver-v13406998.exe";

    /**
     * Método para iniciar o driver no navegador antes de qualquer classe de teste
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Método para finalizar o driver no navegador antes de qualquer classe de teste
     */
    @AfterClass
    public static void finalizar(){ 
        driver.quit();
    }
}
