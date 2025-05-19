package bagaceiragames.controller;

// DAO (Data Access Objects)
import bagaceiragames.dao.EstoqueDAO;
import bagaceiragames.dao.ProdutoDAO;
import bagaceiragames.dao.TransacaoDAO;
// Se você criar DAOs para Categoria/Plataforma, importe-os aqui
import bagaceiragames.dao.CategoriaDAO;
import bagaceiragames.dao.PlataformaDAO;

// Model (Classes de Domínio)
import bagaceiragames.model.Produto;
import bagaceiragames.model.Usuario;
// import bagaceiragames.model.ItemCarrinho; // Para lógica do carrinho

// View (Componentes da Interface Gráfica)
import bagaceiragames.view.LojaPanel;
import bagaceiragames.view.MainWindow;

// Swing e AWT
import javax.swing.JButton;
import java.awt.event.ActionListener; // Para remover listeners específicos
// import java.awt.event.ActionEvent; // Não é diretamente usado se usar lambdas
import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors; // Para filtros em memória, se necessário

public class LojaController {

    private MainWindow mainWindow;
    private LojaPanel lojaPanel;
    private Usuario usuarioLogado;
    private ProdutoDAO produtoDAO;
    private EstoqueDAO estoqueDAO;
    private TransacaoDAO transacaoDAO;
    private CategoriaDAO categoriaDAO;
    private PlataformaDAO plataformaDAO;

    private List<Produto> cacheProdutosExibidos; // Para otimizar a exibição
    // private List<ItemCarrinho> carrinhoDeCompras;

    /**
     * Construtor do LojaController.
     * Inicializa as referências aos componentes da view, DAOs e o usuário logado.
     */
    public LojaController(MainWindow mainWindow, LojaPanel lojaPanel, Usuario usuarioLogado,
                          ProdutoDAO produtoDAO, EstoqueDAO estoqueDAO, TransacaoDAO transacaoDAO) {
        this.mainWindow = mainWindow;
        this.lojaPanel = lojaPanel;
        this.usuarioLogado = usuarioLogado;
        this.produtoDAO = produtoDAO;
        this.estoqueDAO = estoqueDAO;
        this.transacaoDAO = transacaoDAO;

        // this.cacheProdutosExibidos = new ArrayList<>();
        // this.carrinhoDeCompras = new ArrayList<>();

        System.out.println("LojaController instanciado para o usuário: " +
                (this.usuarioLogado != null ? this.usuarioLogado.getNome() : "N/A"));

        // Os listeners serão configurados quando a interface da loja for preparada.
    }

    // O CONSTRUTOR DUPLICADO FOI REMOVIDO.

    /**
     * Método chamado quando o LojaPanel é exibido.
     * Responsável por carregar dados iniciais e configurar listeners.
     */
    public void prepararInterfaceLoja() {
        if (this.lojaPanel == null) {
            System.err.println("LojaController (prepararInterfaceLoja): lojaPanel é null! Não é possível preparar a interface.");
            return;
        }
        System.out.println("LojaController: Preparando interface da loja...");

        // Lógica para carregar dados (Sprint 2 em diante)
        carregarFiltros(); // Preenche JComboBoxes
        carregarProdutosIniciais(); // Carrega a lista inicial de produtos

        // Configura todos os listeners da UI do LojaPanel
        initListeners();
    }

    /**
     * Inicializa os listeners para os componentes da interface do LojaPanel.
     */
    private void initListeners() {
        if (this.lojaPanel == null) {
            System.err.println("LojaController (initListeners): lojaPanel é null! Não é possível adicionar listeners.");
            return;
        }
        System.out.println("LojaController: Inicializando listeners...");

        // --- Listener para o Botão de Logout ---
        JButton btnLogout = this.lojaPanel.getBtnLogout();
        if (btnLogout != null) {
            // Remove listeners antigos para evitar duplicação se este método for chamado mais de uma vez
            for (ActionListener al : btnLogout.getActionListeners()) {
                btnLogout.removeActionListener(al);
            }
            btnLogout.addActionListener(e -> fazerLogout());
            System.out.println("LojaController: Listener de Logout adicionado.");
        } else {
            System.err.println("LojaController: Botão de logout (getBtnLogout) retornou null no LojaPanel.");
        }

        // --- Listeners para Filtros (Sprint 2) ---
        if (this.lojaPanel.getComboCategorias() != null) {
            // TODO: Remover listeners antigos de comboCategorias se necessário
            this.lojaPanel.getComboCategorias().addActionListener(e -> aplicarFiltrosEAtualizarProdutos());
        } else { System.err.println("LojaController: ComboCategorias é null."); }

        if (this.lojaPanel.getComboPlataformas() != null) {
            // TODO: Remover listeners antigos de comboPlataformas se necessário
            this.lojaPanel.getComboPlataformas().addActionListener(e -> aplicarFiltrosEAtualizarProdutos());
        } else { System.err.println("LojaController: ComboPlataformas é null."); }

        if (this.lojaPanel.getTxtBuscaNome() != null) {
            // TODO: Remover listeners antigos de txtBuscaNome se necessário
            // Para JTextField, pode ser melhor usar DocumentListener para updates em tempo real,
            // mas ActionListener (disparado com Enter) também funciona.
            this.lojaPanel.getTxtBuscaNome().addActionListener(e -> aplicarFiltrosEAtualizarProdutos());
        } else { System.err.println("LojaController: TxtBuscaNome é null."); }

        // TODO SPRINT 2/3: Adicionar listener para o botão "Adicionar ao Carrinho"
        // if (this.lojaPanel.getBtnAdicionarAoCarrinho() != null) { ... }

        // TODO SPRINT 3: Adicionar listeners para "Remover Item", "Esvaziar Carrinho", "Finalizar Compra"
    }

    // --- MÉTODOS DE LÓGICA (A SEREM DESENVOLVIDOS NOS PRÓXIMOS SPRINTS) ---

    private void carregarFiltros() {
        System.out.println("LojaController: Carregando opções para filtros (categorias, plataformas)... (Lógica a implementar)");
    }

    private void carregarProdutosIniciais() {
        if (produtoDAO == null || lojaPanel == null) {
            System.err.println("LojaController (carregarProdutosIniciais): produtoDAO ou lojaPanel é null.");
            return;
        }
        System.out.println("LojaController: Carregando lista inicial de produtos...");
        List<Produto> todosProdutos = produtoDAO.listarTodosProdutos(); // Usa o método do seu ProdutoDAO
        lojaPanel.exibirProdutos(todosProdutos); // Chama o método do seu LojaPanel
        System.out.println( (todosProdutos != null ? todosProdutos.size() : 0) + " produtos carregados e tentados exibir.");
    }

    private void aplicarFiltrosEAtualizarProdutos() {
        if (produtoDAO == null || lojaPanel == null) {
            System.err.println("LojaController (aplicarFiltrosEAtualizarProdutos): produtoDAO ou lojaPanel é null.");
            return;
        }
        System.out.println("LojaController: Aplicando filtros e atualizando produtos...");

        // Obter valores dos filtros do LojaPanel
        // String categoriaSelecionada = (String) lojaPanel.getComboCategorias().getSelectedItem();
        // String plataformaSelecionada = (String) lojaPanel.getComboPlataformas().getSelectedItem();
        // String nomeBusca = lojaPanel.getTxtBuscaNome().getText();

        // TODO: Converter nomes de categoria/plataforma para IDs se o DAO esperar IDs
        // int idCategoriaFiltro = ... ;
        // int idPlataformaFiltro = ... ;

        // List<Produto> produtosFiltrados = produtoDAO.buscarProdutosPorFiltros(idCategoriaFiltro, idPlataformaFiltro, nomeBusca);
        // lojaPanel.exibirProdutos(produtosFiltrados);
    }

    private void adicionarItemAoCarrinho() {
        System.out.println("LojaController: Adicionando item ao carrinho (a implementar)...");
        // Lógica do Sprint 3
    }

    private void removerItemDoCarrinho() {
        System.out.println("LojaController: Removendo item do carrinho (a implementar)...");
        // Lógica do Sprint 3
    }

    private void esvaziarCarrinho() {
        System.out.println("LojaController: Esvaziando carrinho (a implementar)...");
        // Lógica do Sprint 3
        // this.carrinhoDeCompras.clear();
        // lojaPanel.atualizarExibicaoCarrinho(this.carrinhoDeCompras);
        // lojaPanel.atualizarTotalCarrinho(0.0);
    }

    private void finalizarCompra() {
        System.out.println("LojaController: Finalizando compra (a implementar)...");
        // Lógica do Sprint 3
    }

    public void fazerLogout() {
        System.out.println("LojaController: MÉTODO FAZERLOGOUT() CHAMADO!");
        String nomeUsuario = (this.usuarioLogado != null ? this.usuarioLogado.getNome() : "N/A");
        System.out.println("LojaController: Usuário " + nomeUsuario + " fazendo logout.");

        esvaziarCarrinho();
        this.usuarioLogado = null; // Limpa a referência ao usuário logado

        if (this.lojaPanel != null) {
            this.lojaPanel.resetarPainel(); // Pede ao painel para limpar sua UI
        }

        if (this.mainWindow != null) {
            this.mainWindow.showPanel(MainWindow.LOGIN_PANEL);
            System.out.println("LojaController: " + nomeUsuario + " deslogado, voltando para a home.");
        } else {
            System.err.println("LojaController (fazerLogout): mainWindow é null!");
        }
    }
}