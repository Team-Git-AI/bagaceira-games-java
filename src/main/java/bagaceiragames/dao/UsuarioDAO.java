package bagaceiragames.dao;

import bagaceiragames.model.Usuario; // Importa a classe do modelo
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public Usuario autenticarUsuario(String login, String senha) {
        // Busca usuário pelo login e senha
        String sql = "SELECT id, nome, login, senha FROM usuarios WHERE login = ? AND senha = ?";
        Usuario usuarioAutenticado = null;

        try (Connection conexao = ConexaoBD.conectar(); // Obtém a conexão
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, login); // Define o primeiro parâmetro (?) da query SQL
            pstmt.setString(2, senha); // Define o segundo parâmetro (?) da query SQL

            try (ResultSet rs = pstmt.executeQuery()) { // Executa a query de seleção
                if (rs.next()) { // Se encontrou um usuário com o login e senha correspondentes
                    usuarioAutenticado = new Usuario();
                    usuarioAutenticado.setId(rs.getInt("id"));
                    usuarioAutenticado.setNome(rs.getString("nome"));
                    usuarioAutenticado.setLogin(rs.getString("login"));
                    usuarioAutenticado.setSenha(rs.getString("senha"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuário no DAO: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarioAutenticado;
    }

    // Método main para teste rápido do UsuarioDAO

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();
        System.out.println("\nTestando autenticação...");

        Usuario admin = dao.autenticarUsuario("root", "root");
        if (admin != null) {
            System.out.println("SUCESSO! 'Admin' autenticado >> " + admin.getNome() + " (ID: " + admin.getId() + ")");
        } else {
            System.out.println(">>FALHA<< Na autenticação de 'admin'");
        }

        Usuario juca = dao.autenticarUsuario("juca_machuca", "machucador");
        if (juca != null) {
            System.out.println("SUCESSO! 'Juca Machuca' autenticado >> " + juca.getNome() + " (ID: " + juca.getId() + ")");
        } else {
            System.out.println(">>FALHA<< na autenticação de 'Juca Machuca'");
        }
    }
}