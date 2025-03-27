package automatizado.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    private static LoginPO loginPage;
    private static ControleDeProdutoPO controlleProdutoPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");
        controlleProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controlleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarEmCriar() {
        controlleProdutoPage.buttonAdicionar.click();
        // TODO: Remover esse clique assim que o sistema for corrigido para que precise
        // clicar apenas uma vez para abrir o Modal
        controlleProdutoPage.buttonAdicionar.click();

        String titulo = controlleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);

        controlleProdutoPage.buttonSair.click();
        // TODO: Remover segundo clique assim que o sistema for corrigido, está
        // precisando de um primeiro clique no próprio botão ou outro para que funcione
        controlleProdutoPage.buttonSair.click();

    }

    @Test
    public void TC002_NaoDeveserPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {

        // Definimos a mensagem que vamos comparar com a mensagem recebida
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";

        //Abre o Modal
        controlleProdutoPage.buttonAdicionar.click();

        // Aqui cria o objeto para adicionar na tela, resumindo cria o Builder
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controlleProdutoPage);

        // Aqui realmente ele adiciona as informações na tela
        // manda criar um produto sem código
        produtoBuilder
                .adicionarNome("Marreta")
                .adicionarCodigo("")
                .adicionarValor(1.1)
                .builder();

        

        /* Capturar mensagem de erro e compara com a mensagem que definimos na String mensagem */
        assertEquals(mensagem, controlleProdutoPage.spanMensagem.getText());


    }

}
