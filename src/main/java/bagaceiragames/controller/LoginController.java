package bagaceiragames.controller;

import bagaceiragames.dao.UsuarioDAO;
import bagaceiragames.dao.ProdutoDAO;
import bagaceiragames.dao.EstoqueDAO;
import bagaceiragames.dao.TransacaoDAO;
import bagaceiragames.model.Usuario;
import bagaceiragames.view.LoginPanel;
import bagaceiragames.view.LojaPanel;
import bagaceiragames.view.MainWindow;
import javax.swing.JOptionPane;

public class LoginController {
    private MainWindow mainWindow;
    private LoginPanel loginPanel;
    private LojaPanel lojaPanel; // Referência ao 'LojaPanel'
    private UsuarioDAO usuarioDAO;

    public LoginController(MainWindow mainWindow, LoginPanel loginPanel, LojaPanel lojaPanel, UsuarioDAO usuarioDAO) {
        this.mainWindow = mainWindow;
        this.loginPanel = loginPanel;
        this.lojaPanel = lojaPanel;
        this.usuarioDAO = usuarioDAO;

        if (this.loginPanel != null && this.loginPanel.getBtnEntrar() != null) {
            this.loginPanel.getBtnEntrar().addActionListener(e -> autenticar());
        } else {
            System.err.println("LoginController: LoginPanel ou seu botão de entrar é nulo.");
        }
    }

    private void autenticar() {
        // (chama login e senha)
        String login = loginPanel.getLogin();
        String senha = loginPanel.getSenha();
        Usuario usuarioAutenticado = usuarioDAO.autenticarUsuario(login, senha);

        if (usuarioAutenticado != null) {
            JOptionPane.showMessageDialog(loginPanel, "Login bem-sucedido! Bem-vindo, " + usuarioAutenticado.getNome() + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            loginPanel.limparCampos();

            // Instancia DAOs necessários pRO LojaController
            ProdutoDAO produtoDAO = new ProdutoDAO();
            EstoqueDAO estoqueDAO = new EstoqueDAO();
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            // Cria e configura o LojaController
            LojaController lojaCtrl = new LojaController(mainWindow, lojaPanel, usuarioAutenticado,
                    produtoDAO, estoqueDAO, transacaoDAO);

            lojaCtrl.prepararInterfaceLoja();
            mainWindow.showPanel(MainWindow.LOJA_PANEL);

        } else {
            JOptionPane.showMessageDialog(loginPanel, "Login ou senha inválidos.", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
            loginPanel.limparCampos();
        }
    }
}