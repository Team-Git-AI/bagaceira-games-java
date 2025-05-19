package bagaceiragames.dao;

import bagaceiragames.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    /**
     * Lista todas as categorias cadastradas no banco de dados.
     * @return Uma lista de objetos Categoria.
     */
    public List<Categoria> listarTodasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nome FROM categorias ORDER BY nome"; // Ordena por nome para JComboBox

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
            e.printStackTrace();
            // Considerar lançar uma exceção customizada ou retornar lista vazia com log de erro.
        }
        return categorias;
    }

    /**
     * Busca uma categoria pelo seu ID.
     * @param id O ID da categoria.
     * @return Um objeto Categoria se encontrado, null caso contrário.
     */
    public Categoria buscarCategoriaPorId(int id) {
        String sql = "SELECT id, nome FROM categorias WHERE id = ?";
        Categoria categoria = null;

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return categoria;
    }
}