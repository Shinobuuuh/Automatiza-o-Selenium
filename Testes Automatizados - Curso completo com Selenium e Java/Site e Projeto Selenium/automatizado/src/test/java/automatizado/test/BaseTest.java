package automatizado.test;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 */
public abstract class BaseTest {

    protected static WebDriver driver;

    /**
     * só para caso vá utilizar uma URL fixa como por exemplo Google.com ai neste
     * caso precisa alterar a linha 49 para driver.get(URL_BASE);
     * 
     * @return * só para caso vá utilizar uma URL fixa como por exemplo Google.com
     *         ai neste caso precisa alterar a linha 49 para driver.get(URL_BASE);
     */
    // private static String URL_BASE = "C:/Curso QA Testes
    // Automatizados/Automatiza-o-Selenium/Testes Automatizados - Curso completo com
    // Selenium e Java/Site e Projeto Selenium/sistema/login.html";

    public static String obterCaminhoExecutavel() {
        return System.getProperty("user.dir");
    }

    /**
     * Está pegando a URL base para utilizarmos, neste caso pegamos o caminho fixo
     * do sistema até o caminho onde estamos abrindo o projeto,
     * e apontamos para onde está nosso site
     * 
     * @return
     */
    public static String getUrlBase() {
        // Obtém o caminho do diretório onde o programa está sendo executado
        String caminhoExecutavel = obterCaminhoExecutavel();

        // Obtém o caminho sem a última pasta (remove "automatizado" do final)
        Path caminhoSemUltimaPasta = Paths.get(caminhoExecutavel).getParent();

        // Se o caminho sem a última pasta não for nulo, usa ele; senão, mantém o
        // caminho original
        String caminhoFinal = (caminhoSemUltimaPasta != null) ? caminhoSemUltimaPasta.toString() : caminhoExecutavel;

        // Exibe os caminhos no console para depuração
        System.out.println("Caminho do executável: " + caminhoExecutavel);
        System.out.println("Caminho sem 'automatizado': " + caminhoFinal + "/sistema/login.html");

        // Retorna o caminho base ajustado, concatenado com "sistema/login.html"
        return caminhoFinal + "/sistema/login.html";
    }

    // Caminho relativo do driver ao projeto referente ao path
    private static String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v13406998.exe";

    /**
     * Método para iniciar o driver no navegador antes de qualquer classe de teste
     */
    @BeforeClass
    public static void iniciar() {

        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrlBase());
    }

    /**
     * Método para finalizar o driver no navegador antes de qualquer classe de teste
     */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
