package bagaceiragames.controller;

import bagaceiragames.dao.UsuarioDAO;
import bagaceiragames.dao.ProdutoDAO; // Importar
import bagaceiragames.dao.EstoqueDAO; // Importar
import bagaceiragames.dao.TransacaoDAO; // Importar
import bagaceiragames.model.Usuario;
import bagaceiragames.view.LoginPanel;
import bagaceiragames.view.LojaPanel;  // Importar
import bagaceiragames.view.MainWindow;
import javax.swing.JOptionPane; // Para mensagens

public class LoginController {
    private MainWindow mainWindow;
    private LoginPanel loginPanel;
    private LojaPanel lojaPanel; // Adicionado para referência ao LojaPanel
    private UsuarioDAO usuarioDAO;

    // CONSTRUTOR ATUALIZADO PARA RECEBER LojaPanel
    public LoginController(MainWindow mainWindow, LoginPanel loginPanel, LojaPanel lojaPanel, UsuarioDAO usuarioDAO) {
        this.mainWindow = mainWindow;
        this.loginPanel = loginPanel;
        this.lojaPanel = lojaPanel; // Armazena a referência
        this.usuarioDAO = usuarioDAO;

        if (this.loginPanel.getBtnEntrar() != null) {
            this.loginPanel.getBtnEntrar().addActionListener(e -> autenticar());
        } else {
            System.err.println("LoginController: Botão Entrar do LoginPanel é nulo!");
        }
    }

    private void autenticar() {
        String login = loginPanel.getLogin();
        String senha = loginPanel.getSenha();
        Usuario usuarioAutenticado = usuarioDAO.autenticarUsuario(login, senha);

        if (usuarioAutenticado != null) {
            JOptionPane.showMessageDialog(loginPanel, "Login bem-sucedido! Bem-vindo, " + usuarioAutenticado.getNome() + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            loginPanel.limparCampos();

            // Instanciar DAOs necessários para LojaController AQUI
            ProdutoDAO produtoDAO = new ProdutoDAO();
            EstoqueDAO estoqueDAO = new EstoqueDAO();
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            // Criar e configurar o LojaController
            LojaController lojaCtrl = new LojaController(mainWindow, lojaPanel, usuarioAutenticado,
                    produtoDAO, estoqueDAO, transacaoDAO);

            // Opcional: Se MainWindow precisar de uma referência ao LojaController atual
            // mainWindow.setLojaControllerAtual(lojaCtrl);

            lojaCtrl.prepararInterfaceLoja();
            mainWindow.showPanel(MainWindow.LOJA_PANEL);

        } else {
            JOptionPane.showMessageDialog(loginPanel, "Login ou senha inválidos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            loginPanel.limparCampos();
        }
    }
}