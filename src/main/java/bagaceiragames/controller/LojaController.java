package bagaceiragames.controller;

// DAO (Data Access Objects)
import bagaceiragames.dao.EstoqueDAO;
import bagaceiragames.dao.ProdutoDAO;
import bagaceiragames.dao.TransacaoDAO;
import bagaceiragames.model.Usuario;

// View (Componentes da Interface Gráfica)
import bagaceiragames.view.LojaPanel;
import bagaceiragames.view.MainWindow;

public class LojaController {

    private MainWindow mainWindow; // Janela principal
    private LojaPanel lojaPanel;   // O painel da interface da loja
    private Usuario usuarioLogado; // Informações do usuário logado

    private EstoqueDAO estoqueDAO;
    private TransacaoDAO transacaoDAO;
    // private CategoriaDAO categoriaDAO;   // Opcional: DAO para gerenciar categorias
    // private PlataformaDAO plataformaDAO; // Opcional: DAO para gerenciar plataformas

    // Estruturas de dados para gerenciar o estado da loja
    // private List<Produto> cacheProdutosExibidos; // Lista de produtos atualmente mostrados na UI
    // private List<ItemCarrinho> carrinhoDeCompras; // Itens no carrinho do usuário

    /**
     * Construtor do LojaController.
     * Inicializa as referências aos componentes da view, DAOs e o usuário logado.
     */
    public LojaController(MainWindow mainWindow, LojaPanel lojaPanel, Usuario usuarioLogado,
                          ProdutoDAO produtoDAO, EstoqueDAO estoqueDAO, TransacaoDAO transacaoDAO) {
        this.mainWindow = mainWindow;
        this.lojaPanel = lojaPanel;
        this.usuarioLogado = usuarioLogado;
        // DAOs para interagir com o banco de dados
        this.estoqueDAO = estoqueDAO;
        this.transacaoDAO = transacaoDAO;

        // Inicializa listas internas (serão mais usadas nos Sprints 2 e 3)
        // this.cacheProdutosExibidos = new ArrayList<>();
        // this.carrinhoDeCompras = new ArrayList<>();

        System.out.println("LojaController instanciado para o usuário: " +
                (this.usuarioLogado != null ? this.usuarioLogado.getNome() : "N/A"));

        // Configura os listeners para os eventos da UI do LojaPanel
        // Esta chamada pode ser movida para um método que é invocado quando o LojaPanel se torna ativo
        // initListeners(); // Descomente quando o LojaPanel tiver os botões e campos
    }

    public LojaController(MainWindow mainWindow, LojaPanel lojaPanel, ProdutoDAO produtoDAO, EstoqueDAO estoqueDAO, TransacaoDAO transacaoDAO) {
    }

    /**
     * Método chamado quando o LojaPanel é exibido.
     * Responsável por carregar dados iniciais como categorias para filtros,
     * plataformas para filtros e a lista inicial de produtos.
     */
    public void prepararInterfaceLoja() {
        System.out.println("LojaController: Preparando interface da loja...");
        if (usuarioLogado != null) {
            // lojaPanel.setMensagemBoasVindas("Bem-vindo(a), " + usuarioLogado.getNome() + "!"); // Exemplo
        }

        // Lógica do Sprint 2:
        // carregarFiltros();
        // carregarProdutosIniciais();

        // Configurar listeners agora que o painel está prestes a ser exibido
        initListeners(); // Ou chame de um método da MainWindow quando o painel é mostrado
    }

    /**
     * Inicializa os listeners para os componentes da interface do LojaPanel.
     * (Botões de filtro, adicionar ao carrinho, finalizar compra, logout, etc.)
     */
    private void initListeners() {
        System.out.println("LojaController: Inicializando listeners (a implementar)...");
        // Exemplo para um botão de logout (você precisará criar este botão no LojaPanel)
        // JButton btnLogout = lojaPanel.getBtnLogout(); // Supondo que LojaPanel tenha getBtnLogout()
        // if (btnLogout != null) {
        //     // Remove listeners antigos para evitar múltiplas execuções se initListeners for chamado mais de uma vez
        //     for (ActionListener al : btnLogout.getActionListeners()) {
        //         btnLogout.removeActionListener(al);
        //     }
        //     btnLogout.addActionListener(e -> fazerLogout());
        // }

        // TODO SPRINT 2: Adicionar listeners para filtros de categoria, plataforma e busca por nome
        // lojaPanel.getComboCategorias().addActionListener(e -> aplicarFiltrosEAtualizarProdutos());
        // lojaPanel.getComboPlataformas().addActionListener(e -> aplicarFiltrosEAtualizarProdutos());
        // lojaPanel.getTxtBuscaNome().addActionListener(e -> aplicarFiltrosEAtualizarProdutos()); // ou DocumentListener

        // TODO SPRINT 2/3: Adicionar listener para o botão "Adicionar ao Carrinho"
        // lojaPanel.getBtnAdicionarAoCarrinho().addActionListener(e -> adicionarItemAoCarrinho());

        // TODO SPRINT 3: Adicionar listeners para "Remover Item", "Esvaziar Carrinho", "Finalizar Compra"
        // lojaPanel.getBtnRemoverDoCarrinho().addActionListener(e -> removerItemDoCarrinho());
        // lojaPanel.getBtnEsvaziarCarrinho().addActionListener(e -> esvaziarCarrinho());
        // lojaPanel.getBtnFinalizarCompra().addActionListener(e -> finalizarCompra());
    }


    // --- MÉTODOS DE LÓGICA (A SEREM DESENVOLVIDOS NOS PRÓXIMOS SPRINTS) ---

    private void carregarFiltros() {
        System.out.println("LojaController: Carregando opções para filtros (categorias, plataformas)...");
        // Lógica do Sprint 2:
        // 1. Usar CategoriaDAO e PlataformaDAO (ou ProdutoDAO com métodos específicos)
        //    para buscar todas as categorias e plataformas distintas.
        // List<String> categorias = ...; // categoriaDAO.listarNomes();
        // List<String> plataformas = ...; // plataformaDAO.listarNomes();
        // 2. Popular os JComboBoxes no LojaPanel.
        // lojaPanel.popularFiltroCategorias(categorias);
        // lojaPanel.popularFiltroPlataformas(plataformas);
    }

    private void carregarProdutosIniciais() {
        System.out.println("LojaController: Carregando lista inicial de produtos...");
        // Lógica do Sprint 2:
        // 1. Usar ProdutoDAO para buscar todos os produtos ou um conjunto inicial.
        // this.cacheProdutosExibidos = produtoDAO.listarTodosComEstoqueVisivel(); // Método exemplo
        // 2. Atualizar a JList/JTable no LojaPanel.
        // lojaPanel.atualizarListaDeProdutos(this.cacheProdutosExibidos);
    }

    private void aplicarFiltrosEAtualizarProdutos() {
        System.out.println("LojaController: Aplicando filtros e atualizando produtos...");
        // Lógica do Sprint 2:
        // 1. Obter os valores dos JComboBoxes e campo de texto de busca do LojaPanel.
        // String categoriaFiltro = lojaPanel.getCategoriaSelecionada();
        // String plataformaFiltro = lojaPanel.getPlataformaSelecionada();
        // String nomeFiltro = lojaPanel.getTextoBuscaNome();
        // 2. Chamar um método no ProdutoDAO para buscar produtos com base nesses filtros.
        // this.cacheProdutosExibidos = produtoDAO.buscarPorFiltros(categoriaFiltro, plataformaFiltro, nomeFiltro);
        // 3. Atualizar a JList/JTable no LojaPanel.
        // lojaPanel.atualizarListaDeProdutos(this.cacheProdutosExibidos);
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
        // lojaPanel.atualizarExibicaoCarrinho(this.carrinhoDeCompras); // Método no LojaPanel
        // lojaPanel.atualizarTotalCarrinho(0.0); // Método no LojaPanel
    }

    private void finalizarCompra() {
        System.out.println("LojaController: Finalizando compra (a implementar)...");
        // Lógica do Sprint 3
    }

    /**
     * Realiza o logout do usuário, limpando o estado da loja e
     * retornando para o painel de login.
     */
    public void fazerLogout() {
        System.out.println("LojaController: Usuário " + (usuarioLogado != null ? usuarioLogado.getNome() : "N/A") + " fazendo logout.");
        // Limpar estado da loja se necessário (carrinho, filtros, etc.)
        // esvaziarCarrinho(); // Exemplo
        // this.usuarioLogado = null; // Limpa o usuário logado no controller

        // Se LojaPanel tiver um método para resetar sua UI:
        // lojaPanel.resetarPainel();

        // Informa a MainWindow para mostrar o painel de login
        if (mainWindow != null) {
            mainWindow.showPanel(MainWindow.LOGIN_PANEL);
        }
    }
}