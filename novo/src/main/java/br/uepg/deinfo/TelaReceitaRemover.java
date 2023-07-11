package br.uepg.deinfo;

import java.awt.Component;
import java.util.HashMap;
import java.util.Stack;

import javax.swing.*;

public class TelaReceitaRemover implements Tela
{

    private Window janela;
    private JPanel tela;

    TelaReceitaRemover(Window janela)
    {
        this.janela = janela;
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);

        Stack<HashMap<String, String>> dados = new Stack<HashMap<String, String>>();

        Driver driver = new Driver("banco.bg");
        String[] val = {"id", "data", "descricao", "valor"};
        dados = driver.ObterDados("SELECT * FROM Receitas;", val);
        
        Object[][] temp = new String[dados.size()][4];
        
        int i=0;
        for (HashMap<String, String> a: dados) 
        {
            String[] temp1 = {a.get("id"), a.get("data"), a.get("descricao"), a.get("valor")};
            temp[i] = temp1;
            i++;
        }

        JTable tabela = new JTable(temp, val);
        tabela.setVisible(true);
        JScrollPane barraRolagem = new JScrollPane(tabela);
        barraRolagem.setVisible(true);
        barraRolagem.setBounds(0, 200, 480, 300);
        tela.add(barraRolagem);
    
        JLabel label = new JLabel("<html><span style=\"font-size: 19pt;\">Digite o ID a ser removido: </span></html>");
        label.setBounds(20, 50, 200, 50);
        tela.add(label);

        JTextField id_escolhido = new JTextField();
        id_escolhido.setBounds(20, 150, 100, 20);
        tela.add(id_escolhido);

        JButton bt_ok = new JButton("OK");
        bt_ok.setBounds(150, 150, 100, 20);
        bt_ok.addActionListener(e -> ManterReceitas.ExcluirReceita(Integer.parseInt(id_escolhido.getText())));
        tela.add(bt_ok);


        JButton bt_voltar = new JButton("VOLTAR");
        bt_voltar.setBounds(350, 10, 100, 50);
        bt_voltar.addActionListener(e -> Dashboard.voltaTela(janela));
        tela.add(bt_voltar);

    }

    @Override
    public void mostraTela() {
        tela.setVisible(true);
    }

    @Override
    public Component get() {
        return tela;
    }

    @Override
    public void removeTela() {
        tela.setVisible(false);
    }
    
    
}

