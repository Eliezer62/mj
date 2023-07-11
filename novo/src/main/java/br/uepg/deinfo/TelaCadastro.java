package br.uepg.deinfo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public class TelaCadastro implements Tela
{
    Window janela;
    private JPanel tela;

    private JTextField email, nome,salario, nascimento;
    private JPasswordField senha, confirmar_senha;

    TelaCadastro(Window janela)
    {
        this.janela = janela;
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);

        JLabel label = new JLabel("<html><span style=\"font-size: 48pt;\">Cadastro</span></html>");
        label.setBounds(20, 20, 250, 50);
        tela.add(label);

        JLabel label_email = new JLabel("<html><span style=\"font-size: 14pt;\">E-MAIL</span></html>");
        label_email.setBounds(20, 95, 250, 60);
        tela.add(label_email);
        email = new JTextField();
        email.setBounds(20, 150, 400, 30);
        tela.add(email);

        JLabel label_senha = new JLabel("<html><span style=\"font-size: 14pt;\">SENHA</span></html>");
        label_senha.setBounds(20, 175, 250, 60);
        tela.add(label_senha);
        senha = new JPasswordField();
        senha.setBounds(20, 230, 400, 30);
        tela.add(senha);

        JLabel label_nome = new JLabel("<html><span style=\"font-size: 14pt;\">NOME</span></html>");
        label_nome.setBounds(20, 255, 250, 60);
        tela.add(label_nome);
        nome = new JTextField();
        nome.setBounds(20, 310, 400, 30);
        tela.add(nome);

        JLabel label_nasc = new JLabel("<html><span style=\"font-size: 14pt;\">NASCIMENTO</span></html>");
        label_nasc.setBounds(20, 345, 250, 60);
        tela.add(label_nasc);
        nascimento = new JTextField();
        nascimento.setBounds(20, 400, 400, 30);
        tela.add(nascimento);

        JLabel label_sal = new JLabel("<html><span style=\"font-size: 14pt;\">SALÁRIO</span></html>");
        label_sal.setBounds(20, 425, 250, 60);
        tela.add(label_sal);
        salario = new JTextField();
        salario.setBounds(20, 480, 400, 30);
        tela.add(salario);

        JButton bt_cadastrar = new JButton("CADASTRAR");
        bt_cadastrar.setBounds(100, 550, 250, 50);
        bt_cadastrar.addActionListener(e -> cadastrar());
        tela.add(bt_cadastrar);

    }


    private void cadastrar()
    {
        String email = this.email.getText();
        String senha = this.senha.getText();
        String nome = this.nome.getText();
        String nascimento = this.nascimento.getText();
        String salario = this.salario.getText();

        System.out.println(nome.length());

        if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
        {
            JOptionPane.showMessageDialog(null, "E-MAIL INVÁLIDO");
        }

        else if(senha.length()<8)
        {
            JOptionPane.showMessageDialog(null, "SENHA INVÁLIDA - tamanho mínimo 8 caracteres");
        }

        else if(nome.length()==0)
        {
            JOptionPane.showMessageDialog(null, "NOME INVÁLIDO");
        }

        else if(nascimento.length()==0) JOptionPane.showMessageDialog(null, "DATA NASCIMENTO INVÁLIDA");

        else if(salario.length()==0) JOptionPane.showMessageDialog(null, "SALÁRIO INVÁLIDO");

        else
        {
            Cadastro cad = new Cadastro();

            cad.setEmail(email);
            cad.setSenha(senha);
            cad.setNome(nome);
            cad.setSalario(Float.parseFloat(salario));
            cad.setNascimento(nascimento);

            ManterUsuario.SalvaDados(janela, cad);
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
