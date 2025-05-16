package bagaceiragames.view;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar;

    public LoginPanel() {
        setLayout(new GridBagLayout()); // Um layout flexível
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        JLabel lblLogin = new JLabel("Login:");
        txtLogin = new JTextField(20); // Largura de 20 caracteres

        JLabel lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(20);

        btnEntrar = new JButton("Entrar");

        // Adicionando componentes ao painel com GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblLogin, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtLogin, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblSenha, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnEntrar, gbc);
    }

    // Getters para os componentes que o controller precisará acessar
    public JTextField getTxtLogin() {
        return txtLogin;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public String getLogin() {
        return txtLogin.getText();
    }

    public String getSenha() {
        return new String(txtSenha.getPassword());
    }

    public void limparCampos() {
        txtLogin.setText("");
        txtSenha.setText("");
    }
}