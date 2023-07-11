package br.uepg.deinfo;

import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

public class TelaInicial implements Tela
{
    private JPanel tela;
    Window janela;

    public TelaInicial( Window janela)
    {
        this.janela = janela;
        tela = new JPanel();
        tela.setBackground(Color.decode("#F5E7CC"));
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);
        
        JLabel logo = new JLabel("<html><span style=\"color: #4E6424;font-family: Arial; font-size: 48pt;font-weight: 900;\">MeuJulius</span></html>");

        logo.setBounds(100, 200, 250, 40);;
        tela.add(logo);

        //Botões

        JButton bt_sim = new JButton("Login caso já possua conta");
        JButton bt_nao = new JButton("Registre-se caso não possua");

        bt_sim.setBounds(75, 500, 300, 50);

        bt_nao.setBounds(75, 550, 300, 50);

        //bt_sim.addActionListener(e -> ManterUsuario.PossuiConta(true, tela));
        bt_sim.addActionListener(e ->{ManterUsuario.PossuiConta(true, janela);});
        bt_nao.addActionListener(e -> ManterUsuario.PossuiConta(false, janela));
        
        tela.add(bt_sim);
        tela.add(bt_nao);

        

        tela.setLayout(null);
    }

    @Override
    public void mostraTela()
    {
        tela.setVisible(true);
    }

    @Override
    public Component get()
    {
        return tela;
    }


    @Override
    public void removeTela()
    {
        tela.setVisible(false);
    }
}
