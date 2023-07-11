package br.uepg.deinfo;

import java.awt.Component;
import javax.swing.*;

public class TelaPagamento implements Tela
{

    private Window janela;
    private JPanel tela;

    TelaPagamento(Window janela)
    {
        this.janela = janela;
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);


        JLabel data = new JLabel("<html><span style=\"font-size: 18pt;\">VENCIMENTO</span></html>");
        data.setBounds(20, 150, 250, 50);
        tela.add(data);

        JTextField campo_data = new JTextField();
        campo_data.setBounds(150, 150, 250, 40);
        tela.add(campo_data);

        JLabel valor = new JLabel("<html><span style=\"font-size: 18pt;\">VALOR</span></html>");
        valor.setBounds(20, 250, 250, 50);
        tela.add(valor);

        JTextField campo_valor = new JTextField();
        campo_valor.setBounds(100, 250, 250, 40);
        tela.add(campo_valor);

        JLabel descricao = new JLabel("<html><span style=\"font-size: 18pt;\">DESCRIÇÃO</span></html>");
        descricao.setBounds(20, 350, 250, 50);
        tela.add(descricao);

        JTextField campo_descricao = new JTextField();
        campo_descricao.setBounds(20, 400, 400, 40);
        tela.add(campo_descricao);

        JButton bt_salvar = new JButton("SALVAR");
        bt_salvar.setBounds(100, 500, 250, 50);
        bt_salvar.addActionListener(e ->ManterPagamentos.SalvarPagamento(campo_data.getText(), campo_valor.getText().toString(), campo_descricao.getText()));
        tela.add(bt_salvar);


        JButton bt_voltar = new JButton("VOLTAR");
        bt_voltar.setBounds(350, 10, 100, 50);
        bt_voltar.addActionListener(e -> Dashboard.voltaTela(janela));
        tela.add(bt_voltar);
    
    }

    public static void voltaTela(Window janela)
    {
        Tela nova = new TelaDespesa(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);
        nova.mostraTela();
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
