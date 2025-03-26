package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;
    private static String URL_BASE = "file:///C:/Curso%20QA%20Testes%20Automatizados/controle-de-produtos/sistema/login.html";
    private static String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v13406998.exe";

    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
