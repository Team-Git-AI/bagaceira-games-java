package bagaceiragames.view;

import javax.swing.*;
import java.awt.*;

public class LojaPanel extends JPanel {

    // Sprint 2: Filtros
    private JComboBox<String> comboCategorias;
    private JComboBox<String> comboPlataformas;
    private JTextField txtBuscaNome;
    private JButton btnAplicarFiltros; // Ou os filtros aplicam automaticamente

    // Sprint 2: Listagem de Produtos
    // private JList<String> listaProdutos; // Ou JTable para mais detalhes
    // private JScrollPane scrollPaneListaProdutos;

    // Sprint 2/3: Detalhes do Produto Selecionado e Adição ao Carrinho
    // private JLabel lblNomeProdutoDetalhe;
    // private JLabel lblPrecoProdutoDetalhe;
    // private JLabel lblEstoqueProdutoDetalhe;
    // private JSpinner spinnerQuantidade;
    // private JButton btnAdicionarAoCarrinho;

    // Sprint 3: Carrinho de Compras
    // private JList<String> listaItensCarrinho; // Ou JTable
    // private JScrollPane scrollPaneCarrinho;
    // private JLabel lblTotalCarrinho;
    // private JButton btnRemoverItemCarrinho;
    // private JButton btnEsvaziarCarrinho;
    // private JButton btnFinalizarCompra;

    // Botão de Logout (Importante para navegação)
    private JButton btnLogout;


    /**
     * Construtor do LojaPanel.
     * Inicializa o painel e seus componentes.
     */
    public LojaPanel() {
        setLayout(new BorderLayout(10, 10)); // Espaçamento de 10px entre componentes

        // --- Painel de Placeholder para o Conteúdo Principal (será preenchido depois) ---
        JPanel painelConteudoPrincipal = new JPanel();
        painelConteudoPrincipal.add(new JLabel("Painel da Loja - Conteúdo Principal Virá Aqui (Produtos, Filtros, etc.)"));
        add(painelConteudoPrincipal, BorderLayout.CENTER);

        // --- Painel de Placeholder para o Carrinho (será preenchido depois) ---
        // JPanel painelCarrinhoLateral = new JPanel();
        // painelCarrinhoLateral.setPreferredSize(new Dimension(250, 0)); // Largura para o carrinho
        // painelCarrinhoLateral.setBorder(BorderFactory.createTitledBorder("Carrinho"));
        // painelCarrinhoLateral.add(new JLabel("Itens do Carrinho Aqui"));
        // add(painelCarrinhoLateral, BorderLayout.EAST);

        // --- Painel Superior (ex: para Boas-vindas e Logout) ---
        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alinha à direita
        btnLogout = new JButton("Logout");
        painelSuperior.add(btnLogout);
        add(painelSuperior, BorderLayout.NORTH);


        // --- Inicialização dos Componentes (descomente e implemente nos próximos Sprints) ---
        // // Filtros
        comboCategorias = new JComboBox<>();
        comboPlataformas = new JComboBox<>();
        txtBuscaNome = new JTextField(20);
        btnAplicarFiltros = new JButton("Filtrar");

        // Lista de Produtos
        // listaProdutos = new JList<>();
        // scrollPaneListaProdutos = new JScrollPane(listaProdutos);
        //
        // // Detalhes e Adicionar ao Carrinho
        // spinnerQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1)); // Min 1, Max 100, Step 1
        // btnAdicionarAoCarrinho = new JButton("Adicionar ao Carrinho");
        //
        // // Carrinho
        // listaItensCarrinho = new JList<>();
        // scrollPaneCarrinho = new JScrollPane(listaItensCarrinho);
        // lblTotalCarrinho = new JLabel("Total: R$ 0.00");
        // btnRemoverItemCarrinho = new JButton("Remover Item");
        // btnEsvaziarCarrinho = new JButton("Esvaziar Carrinho");
        // btnFinalizarCompra = new JButton("Finalizar Compra");
        //
        // // Adicionar componentes ao painel com layouts apropriados
    }

    // --- Getters para os componentes que o LojaController precisará acessar ---

    public JButton getBtnLogout() {
        return btnLogout;
    }

    // Exemplo de getters que você adicionará nos próximos Sprints:
    public JComboBox<String> getComboCategorias() { return comboCategorias; }
    public JComboBox<String> getComboPlataformas() { return comboPlataformas; }
    public JTextField getTxtBuscaNome() { return txtBuscaNome; }
    // public JList<String> getListaProdutos() { return listaProdutos; }
    // public JButton getBtnAdicionarAoCarrinho() { return btnAdicionarAoCarrinho; }

    // --- Métodos para atualizar a UI (serão chamados pelo LojaController) ---

    public void resetarPainel() {
        // Limpar campos, listas, seleções, etc., quando o usuário fizer logout
        // ou uma nova compra for finalizada.
        System.out.println("LojaPanel: Resetando painel (a implementar mais detalhes).");
        // Exemplo:
        // if (listaProdutos != null) listaProdutos.setModel(new DefaultListModel<>()); // Limpa lista
        // if (listaItensCarrinho != null) listaItensCarrinho.setModel(new DefaultListModel<>());
        // if (lblTotalCarrinho != null) lblTotalCarrinho.setText("Total: R$ 0.00");
        // if (txtBuscaNome != null) txtBuscaNome.setText("");
        // if (comboCategorias != null && comboCategorias.getItemCount() > 0) comboCategorias.setSelectedIndex(0);
        // if (comboPlataformas != null && comboPlataformas.getItemCount() > 0) comboPlataformas.setSelectedIndex(0);
    }

    // Exemplos de métodos de atualização que você adicionará:
    // public void popularFiltroCategorias(List<String> categorias) { /* ... */ }
    // public void popularFiltroPlataformas(List<String> plataformas) { /* ... */ }
    // public void atualizarListaDeProdutos(List<Produto> produtos) { /* ... */ }
    // public void atualizarExibicaoCarrinho(List<ItemCarrinho> itens) { /* ... */ }
    // public void atualizarTotalCarrinho(double total) { /* ... */ }

}