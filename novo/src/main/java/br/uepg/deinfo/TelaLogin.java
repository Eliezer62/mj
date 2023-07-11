package br.uepg.deinfo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public class TelaLogin implements Tela
{
    private JPanel tela;

    private JTextField email;
    private JPasswordField senha;
    Window janela;

    public TelaLogin(Window janela)
    {
        this.janela =  janela;
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);

        JLabel label = new JLabel("<html><span style=\"font-size: 48pt;\">Login</span></html>");
        label.setBounds(175, 20, 250, 60);

        tela.add(label);

        JLabel label_login = new JLabel("<html><span style=\"font-size: 14pt;\">E-MAIL</span></html>");
        label_login.setBounds(20, 200, 250, 60);
        tela.add(label_login);

        email = new JTextField();   
        email.setBounds(20, 250, 425, 40);
        tela.add(email);


        JLabel label_senha = new JLabel("<html><span style=\"font-size: 14pt;\">SENHA</span></html>");
        label_senha.setBounds(20, 300, 250, 60);
        tela.add(label_senha);
        senha = new JPasswordField();
        senha.setBounds(20, 350, 425, 40);
        tela.add(senha);

        JButton bt_login = new JButton("LOGIN");
        bt_login.setBounds(100, 500, 250, 50);
        bt_login.addActionListener(e -> login());
        tela.add(bt_login);
        //JLabel()

        //email = new JTextField()



    }


    private void login()
    {
        String email = this.email.getText();
        String senha = this.senha.getText();
        if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
        {
            JOptionPane.showMessageDialog(null, "E-MAIL INVÁLIDO");
        }

        else if(senha.length()<8)
        {
            JOptionPane.showMessageDialog(null, "SENHA INVÁLIDA - tamanho mínimo 8 caracteres");
        }

        else
        {
            Cadastro cad = ManterUsuario.validarLogin(email, senha);
            if(cad==null)
            {
                JOptionPane.showMessageDialog(null, "LOGIN INVÁLIDO");
            }
            else
            {
                janela.setUsuario(cad);
                removeTela();
                Dashboard.voltaTela(janela);
            }
        }
    }


    @Override
    public Component get()
    {
        return tela;
    }

    @Override
    public void mostraTela()
    {
        tela.setVisible(true);
    }

    @Override
    public void removeTela()
    {
        tela.setVisible(false);
    }
}
