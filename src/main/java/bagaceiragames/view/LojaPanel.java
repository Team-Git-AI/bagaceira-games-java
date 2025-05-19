package bagaceiragames.view;

import bagaceiragames.model.Produto;
import javax.swing.*;
import javax.swing.border.EmptyBorder; // Para espaçamento
import javax.swing.table.DefaultTableModel; // Para JTable
import java.awt.*;
import java.util.List;
import java.util.Vector; // Para JTable com DefaultTableModel

public class LojaPanel extends JPanel {

    // --- Filtros ---
    private JComboBox<String> comboCategorias;
    private JComboBox<String> comboPlataformas;
    private JTextField txtBuscaNome;
    private JButton btnAplicarFiltros; // Ou a busca pode ser automática ao mudar combos/texto

    // --- Listagem de Produtos (usando JTable) ---
    private JTable tabelaProdutos;
    private DefaultTableModel modeloTabelaProdutos;
    private JScrollPane scrollPaneTabelaProdutos;

    // --- Botão de Logout ---
    private JButton btnLogout;

    // --- Placeholder para Carrinho (pode ser um painel separado à direita) ---
    // private JPanel painelCarrinho;
    // private JList<String> listaItensCarrinho;
    // private JLabel lblTotalCarrinho;
    // private JButton btnFinalizarCompra;


    public LojaPanel() {
        setLayout(new BorderLayout(10, 10)); // Layout principal
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Adiciona margens ao painel

        // === PAINEL SUPERIOR: Título e Logout ===
        JPanel painelSuperior = new JPanel(new BorderLayout());
        JLabel lblTituloLoja = new JLabel("Produtos disponíveis");
        lblTituloLoja.setFont(new Font("Arial", Font.BOLD, 15));
        lblTituloLoja.setHorizontalAlignment(SwingConstants.CENTER);
        btnLogout = new JButton("Logout");

        JPanel painelLogout = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelLogout.add(btnLogout);

        painelSuperior.add(lblTituloLoja, BorderLayout.CENTER);
        painelSuperior.add(painelLogout, BorderLayout.EAST);
        add(painelSuperior, BorderLayout.NORTH);


        // === PAINEL DE FILTROS (pode ficar acima da lista de produtos) ===
        JPanel painelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5)); // Alinhado à esquerda com espaçamento
        painelFiltros.setBorder(BorderFactory.createTitledBorder("Filtros"));

        comboCategorias = new JComboBox<>();
        comboPlataformas = new JComboBox<>();
        txtBuscaNome = new JTextField(20);
        btnAplicarFiltros = new JButton("Buscar"); // Botão para aplicar os filtros

        painelFiltros.add(new JLabel("Categoria:"));
        painelFiltros.add(comboCategorias);
        painelFiltros.add(new JLabel("Plataforma:"));
        painelFiltros.add(comboPlataformas);
        painelFiltros.add(new JLabel("Nome:"));
        painelFiltros.add(txtBuscaNome);
        painelFiltros.add(btnAplicarFiltros);

        JPanel painelCentral = new JPanel(new BorderLayout(0, 10)); // Layout para filtros acima e tabela abaixo
        painelCentral.add(painelFiltros, BorderLayout.NORTH);


        // === TABELA DE PRODUTOS ===
        // Definir colunas da tabela
        String[] colunasTabela = {"ID", "Nome", "Categoria", "Plataforma", "Preço (R$)"}; // Adicione mais se precisar
        modeloTabelaProdutos = new DefaultTableModel(null, colunasTabela) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Torna a tabela não editável
            }
        };
        tabelaProdutos = new JTable(modeloTabelaProdutos);
        tabelaProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite selecionar apenas uma linha
        tabelaProdutos.getTableHeader().setReorderingAllowed(false); // Impede reordenar colunas
        // Configurar largura das colunas (opcional)
        tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
        tabelaProdutos.getColumnModel().getColumn(1).setPreferredWidth(300); // Nome
        tabelaProdutos.getColumnModel().getColumn(4).setPreferredWidth(100); // Preço

        scrollPaneTabelaProdutos = new JScrollPane(tabelaProdutos);
        painelCentral.add(scrollPaneTabelaProdutos, BorderLayout.CENTER);

        add(painelCentral, BorderLayout.CENTER);


        // === PAINEL DO CARRINHO (a implementar) ===
        // painelCarrinho = new JPanel();
        // painelCarrinho.setLayout(new BoxLayout(painelCarrinho, BoxLayout.Y_AXIS));
        // painelCarrinho.setBorder(BorderFactory.createTitledBorder("Carrinho"));
        // painelCarrinho.setPreferredSize(new Dimension(250, 0));
        // listaItensCarrinho = new JList<>();
        // lblTotalCarrinho = new JLabel("Total: R$ 0,00");
        // btnFinalizarCompra = new JButton("Finalizar Compra");
        // painelCarrinho.add(new JScrollPane(listaItensCarrinho));
        // painelCarrinho.add(lblTotalCarrinho);
        // painelCarrinho.add(btnFinalizarCompra);
        // add(painelCarrinho, BorderLayout.EAST);

        // --- Popular combos com valores iniciais (o controller fará isso com dados do BD) ---
        popularFiltroCategorias(List.of("Todas")); // Placeholder
        popularFiltroPlataformas(List.of("Todas")); // Placeholder
    }

    // --- Getters para o Controller ---
    public JButton getBtnLogout() { return btnLogout; }
    public JComboBox<String> getComboCategorias() { return comboCategorias; }
    public JComboBox<String> getComboPlataformas() { return comboPlataformas; }
    public JTextField getTxtBuscaNome() { return txtBuscaNome; }
    public JButton getBtnAplicarFiltros() { return btnAplicarFiltros; }
    public JTable getTabelaProdutos() { return tabelaProdutos; } // Para o controller obter o produto selecionado

    // --- Métodos para atualizar a UI (chamados pelo Controller) ---
    public void popularFiltroCategorias(List<String> nomesCategorias) {
        comboCategorias.removeAllItems(); // Limpa itens antigos
        if (nomesCategorias != null) {
            for (String nome : nomesCategorias) {
                comboCategorias.addItem(nome);
            }
        }
    }

    public void popularFiltroPlataformas(List<String> nomesPlataformas) {
        comboPlataformas.removeAllItems();
        if (nomesPlataformas != null) {
            for (String nome : nomesPlataformas) {
                comboPlataformas.addItem(nome);
            }
        }
    }

    public void exibirProdutos(List<Produto> produtos) {
        // Limpa a tabela antes de adicionar novos dados
        modeloTabelaProdutos.setRowCount(0);

        if (produtos == null || produtos.isEmpty()) {
            return;
        }

        for (Produto p : produtos) {
            Vector<Object> rowData = new Vector<>();
            rowData.add(p.getId());
            rowData.add(p.getNome());
            rowData.add(p.getCategoriaId()); // Idealmente, seria o nome da categoria
            rowData.add(p.getPlataformaId()); // Idealmente, seria o nome da plataforma
            rowData.add(String.format("%.2f", p.getPreco())); // Formata o preço
            modeloTabelaProdutos.addRow(rowData);
        }
    }

    public void resetarPainel() {
        modeloTabelaProdutos.setRowCount(0); // Limpa a tabela de produtos
        if (comboCategorias.getItemCount() > 0) comboCategorias.setSelectedIndex(0);
        if (comboPlataformas.getItemCount() > 0) comboPlataformas.setSelectedIndex(0);
        txtBuscaNome.setText("");
        // Limpar outros componentes do carrinho, etc., quando forem implementados
        System.out.println("LojaPanel: Painel resetado.");
    }

    // Método para obter o produto selecionado na tabela (será útil para o carrinho)
    public Produto getProdutoSelecionadoNaTabela() {
        int selectedRow = tabelaProdutos.getSelectedRow();
        if (selectedRow >= 0) {
            int produtoId = (Integer) modeloTabelaProdutos.getValueAt(selectedRow, 0);
            String nome = (String) modeloTabelaProdutos.getValueAt(selectedRow, 1);

            // Criando um objeto Produto
            Produto p = new Produto();
            p.setId(produtoId);
            p.setNome(nome);
            return p;
        }
        return null;
    }
}