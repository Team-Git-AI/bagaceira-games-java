package bagaceiragames.dao;

import bagaceiragames.model.Plataforma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlataformaDAO {

    /**
     * Lista todas as plataformas cadastradas no banco de dados.
     * @return Uma lista de objetos Plataforma.
     */
    public List<Plataforma> listarTodasPlataformas() {
        List<Plataforma> plataformas = new ArrayList<>();
        String sql = "SELECT id, nome FROM plataformas ORDER BY nome"; // Ordena por nome

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Plataforma plataforma = new Plataforma();
                plataforma.setId(rs.getInt("id"));
                plataforma.setNome(rs.getString("nome"));
                plataformas.add(plataforma);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar plataformas: " + e.getMessage());
            e.printStackTrace();
        }
        return plataformas;
    }

    /**
     * Busca uma plataforma pelo seu ID.
     * @param id O ID da plataforma.
     * @return Um objeto Plataforma se encontrado, null caso contrário.
     */
    public Plataforma buscarPlataformaPorId(int id) {
        String sql = "SELECT id, nome FROM plataformas WHERE id = ?";
        Plataforma plataforma = null;

        try (Connection conexao = ConexaoBD.conectar();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    plataforma = new Plataforma();
                    plataforma.setId(rs.getInt("id"));
                    plataforma.setNome(rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar plataforma por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return plataforma;
    }
}