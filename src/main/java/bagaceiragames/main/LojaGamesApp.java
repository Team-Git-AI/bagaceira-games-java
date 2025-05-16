package bagaceiragames.main;

import bagaceiragames.controller.LoginController;
import bagaceiragames.dao.UsuarioDAO;
import bagaceiragames.view.LoginPanel;
import bagaceiragames.view.LojaPanel;
import bagaceiragames.view.MainWindow;
import javax.swing.SwingUtilities;

public class LojaGamesApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 1. Janela Principal
                MainWindow mainWindow = new MainWindow();

                // 2. DAOs (apenas o UsuarioDAO para o LoginController)
                UsuarioDAO usuarioDAO = new UsuarioDAO();

                // 3. Painéis da View
                LoginPanel loginPanel = new LoginPanel();
                LojaPanel lojaPanel = new LojaPanel(); // Criado aqui para ser passado ao LoginController

                // 4. Painéis ao MainWindow
                mainWindow.addPanel(loginPanel, MainWindow.LOGIN_PANEL);
                mainWindow.addPanel(lojaPanel, MainWindow.LOJA_PANEL); // Adiciona, mas não mostra inicialmente

                new LoginController(mainWindow, loginPanel, lojaPanel, usuarioDAO);

                // 6. Mostrar o painel inicial
                mainWindow.showPanel(MainWindow.LOGIN_PANEL);
                mainWindow.setVisible(true);
            }
        });
    }
}