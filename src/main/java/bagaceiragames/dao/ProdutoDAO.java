package bagaceiragames.dao;

import bagaceiragames.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    /**
     * Lista todos os produtos cadastrados.
     * Futuramente, pode ser combinado com informações de estoque.
     * @return Uma lista de objetos Produto.
     */
    public List<Produto> listarTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        // Seu script SQL usa id_produto, nome_produto, categoria_id, plataforma_id, preco_produto
        String sql = "SELECT id_produto, nome_produto, categoria_id, plataforma_id, preco_produto FROM produtos";

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nome_produto"));
                produto.setCategoriaId(rs.getInt("categoria_id"));
                produto.setPlataformaId(rs.getInt("plataforma_id"));
                produto.setPreco(rs.getBigDecimal("preco_produto"));
                // Adicionar outros campos se existirem no modelo e na tabela
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
            e.printStackTrace();
        }
        return produtos;
    }

    /**
     * Busca produtos com base em filtros (a ser implementado no Sprint 2).
     * @param idCategoria ID da categoria (pode ser 0 ou null para "todos").
     * @param idPlataforma ID da plataforma (pode ser 0 ou null para "todos").
     * @param nomeProduto Parte do nome do produto para busca (pode ser vazio).
     * @return Lista de produtos filtrados.
     */
    public List<Produto> buscarProdutosPorFiltros(int idCategoria, int idPlataforma, String nomeProduto) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        // A lógica SQL aqui será mais complexa, construindo a query dinamicamente
        // ou usando múltiplos `AND` com `OR` para condições opcionais.
        // Exemplo muito simplificado:
        String sql = "SELECT id_produto, nome_produto, categoria_id, plataforma_id, preco_produto FROM produtos WHERE 1=1 ";

        if (idCategoria > 0) { //  0 ou valor negativo significa "sem filtro"
            sql += " AND categoria_id = ?";
        }
        if (idPlataforma > 0) { // 0 ou valor negativo significa "sem filtro de plataforma"
            sql += " AND plataforma_id = ?";
        }
        if (nomeProduto != null && !nomeProduto.trim().isEmpty()) {
            sql += " AND nome_produto LIKE ?";
        }
        sql += " ORDER BY nome_produto"; // Opcional: ordenar

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            int paramIndex = 1;
            if (idCategoria > 0) {
                pstmt.setInt(paramIndex++, idCategoria);
            }
            if (idPlataforma > 0) {
                pstmt.setInt(paramIndex++, idPlataforma);
            }
            if (nomeProduto != null && !nomeProduto.trim().isEmpty()) {
                pstmt.setString(paramIndex++, "%" + nomeProduto + "%");
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id_produto"));
                    produto.setNome(rs.getString("nome_produto"));
                    produto.setCategoriaId(rs.getInt("categoria_id"));
                    produto.setPlataformaId(rs.getInt("plataforma_id"));
                    produto.setPreco(rs.getBigDecimal("preco_produto"));
                    produtosFiltrados.add(produto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produtos por filtros: " + e.getMessage());
            e.printStackTrace();
        }
        return produtosFiltrados;
    }
}