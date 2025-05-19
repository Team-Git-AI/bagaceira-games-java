package bagaceiragames.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueDAO {

    /**
     * Obtém a quantidade em estoque de um produto específico.
     * @param produtoId O ID do produto.
     * @return A quantidade em estoque, ou -1 se o produto não for encontrado ou ocorrer um erro.
     */
    public int getQuantidadeEstoque(int produtoId) {
        String sql = "SELECT quantidade FROM estoque WHERE produto_id = ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, produtoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quantidade");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter quantidade do estoque para produto ID " + produtoId + ": " + e.getMessage());
            e.printStackTrace();
        }
        return -1; // Indica erro ou produto não encontrado no estoque
    }

    /**
     * Atualiza (decrementa) a quantidade em estoque de um produto.
     * Usado após uma venda.
     * @param produtoId O ID do produto.
     * @param quantidadeVendida A quantidade a ser decrementada.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean decrementarEstoque(int produtoId, int quantidadeVendida) {
        String sql = "UPDATE estoque SET quantidade = quantidade - ? WHERE produto_id = ? AND quantidade >= ?";
        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, quantidadeVendida);
            pstmt.setInt(2, produtoId);
            pstmt.setInt(3, quantidadeVendida); // Garante que há estoque suficiente para decrementar

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao decrementar estoque para produto ID " + produtoId + ": " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Adiciona ou atualiza a entrada de estoque para um produto.
     * @param produtoId O ID do produto.
     * @param quantidade A nova quantidade total em estoque (ou quantidade a ser adicionada).
     * @return true se bem-sucedido, false caso contrário.
     */
    public boolean atualizarOuInserirEstoque(int produtoId, int quantidade) {
        if (getQuantidadeEstoque(produtoId) != -1) { // Se produto já existe no estoque
            String sqlUpdate = "UPDATE estoque SET quantidade = ? WHERE produto_id = ?";
            try (Connection conexao = ConexaoBD.conectar();
                 PreparedStatement pstmt = conexao.prepareStatement(sqlUpdate)) {
                pstmt.setInt(1, quantidade);
                pstmt.setInt(2, produtoId);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else { // Produto não existe no estoque, insere
            String sqlInsert = "INSERT INTO estoque (produto_id, quantidade) VALUES (?, ?)";
            try (Connection conexao = ConexaoBD.conectar();
                 PreparedStatement pstmt = conexao.prepareStatement(sqlInsert)) {
                pstmt.setInt(1, produtoId);
                pstmt.setInt(2, quantidade);
                return pstmt.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}