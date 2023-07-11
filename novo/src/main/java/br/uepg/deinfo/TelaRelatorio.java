package br.uepg.deinfo;

import java.awt.Component;

import javax.swing.*;

public class TelaRelatorio implements Tela
{
    JPanel tela;
    Window janela;
    
    TelaRelatorio(Window janela)
    {
        this.janela = janela;
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);

        JButton bt_voltar = new JButton("VOLTAR");
        bt_voltar.setBounds(350, 10, 100, 50);
        bt_voltar.addActionListener(e -> Dashboard.voltaTela(janela));
        tela.add(bt_voltar);

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
