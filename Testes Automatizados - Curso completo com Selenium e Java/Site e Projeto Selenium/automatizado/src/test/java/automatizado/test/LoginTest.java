package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {

    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {

        loginPage.executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podemm ser brancos.");

    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {

        loginPage.executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC003_nãoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {

        loginPage.executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");

    }

    @Test
    public void TC004_nãoDeveLogarNoSistemaComEmailESenhaInválidos() {

        loginPage.executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC005_nãoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta() {

        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC006_nãoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta() {

        loginPage.executarAcaoDeLogar("teste", "admin@123");

        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem, "E-mail ou senha inválidos");

    }

    @Test
    public void TC007_DeveLogarNoSistemaComEmailESenhaCorretos() {

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");

    }

}
