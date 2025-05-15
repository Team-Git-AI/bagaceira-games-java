package bagaceiragames.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    // --> Configurações da Conexão com o Banco de Dados
    // URL de conexão JDBC para o MySQL
    // Formato: jdbc:mysql://[host]:[porta]/[nome_do_banco_de_dados]
    private static final String URL = "jdbc:mysql://localhost:3306/loja_games_db";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // O padrão é vazio
    private static final String PARAMS = "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    /**
     * Estabelece e retorna uma conexão com o banco MySQL.
     *
     * @return Um objeto Connection representando a conexão estabelecida.
     * @throws SQLException Se ocorrer um erro ao tentar conectar ao banco de dados.
     */
    public static Connection conectar() throws SQLException {
        try { // Tenta estabelecer a conexão
            Connection conexao = DriverManager.getConnection(URL + PARAMS, USUARIO, SENHA);
            return conexao;

        } catch (SQLException e) {
            // Em caso de erro de SQL (ex: banco não encontrado, usuário/senha inválidos)
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace(); // Imprime o stack trace do erro para debug
            throw e; // Re-lança a exceção para que a classe chamadora possa tratá-la
        }
    }
    /**
     * Método principal (main) testa a conexão com o banco
     * Verifica se as configurações de conexão estão corretas.
     */
    public static void main(String[] args) {
        Connection conn = null;
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            conn = conectar(); // Chama o método de conexão

            if (conn != null) {
                System.out.println("Conexão com o banco de dados '" + conn.getCatalog() + "' estabelecida com sucesso!");
                System.out.println("URL: " + conn.getMetaData().getURL());
                System.out.println("Usuário: " + conn.getMetaData().getUserName());
            } else {
                System.err.println("Falha ao obter a conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            // A mensagem de erro já foi impressa dentro do método conectar()
            System.err.println("Não foi possível conectar ao banco. Verifique as configurações e o console para mais detalhes.");
        } finally {
            // É uma boa prática fechar a conexão após o uso.
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexão com o banco de dados fechada.");
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    } // Fim do método main
} // Fim da ConexaoBD