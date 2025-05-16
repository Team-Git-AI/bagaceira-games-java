package bagaceiragames.view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel; // O painel que usa o CardLayout

    public static final String LOGIN_PANEL = "LoginPanel";
    public static final String LOJA_PANEL = "LojaPanel"; // Você criará este depois

    public MainWindow() {
        setTitle("Loja >>Bagaceira Games<< - Não é só jogar. É pegar pra fazer desgraça!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Ajuste conforme necessário
        setLocationRelativeTo(null); // Centralizar na tela

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel); // Adiciona o painel com CardLayout ao JFrame
    }

    // Método para adicionar um painel ao CardLayout
    public void addPanel(JPanel panel, String name) {
        mainPanel.add(panel, name);
    }

    // Método para mostrar um painel específico
    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    // Getter para o CardLayout e mainPanel se necessário por controllers externos
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}