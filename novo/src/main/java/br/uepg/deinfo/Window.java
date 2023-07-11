package br.uepg.deinfo;
import java.awt.Color;

import javax.swing.*;

public class Window 
{
    private JFrame window;
    private Tela atual;
    private Cadastro usuario;

    Window(String nome)
    {
        window = new JFrame(nome, null);

        window.setSize(480, 720);
        window.setResizable(false);
        window.setVisible(true);
        atual = new TelaInicial(this);
        atual.mostraTela();
        window.add(atual.get());

    }


    public  void setAtual(Tela nova)
    {
        atual = nova;
        window.add(atual.get());
    }

    public void setUsuario(Cadastro cad)
    {
        usuario = cad;
    }


    public Tela getAtual()
    {
        return atual;
    }
}
