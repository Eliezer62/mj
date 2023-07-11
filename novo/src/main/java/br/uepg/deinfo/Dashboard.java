package br.uepg.deinfo;

import java.awt.Component;

import javax.swing.*;

public class Dashboard implements Tela
{
    private Window janela;
    private JPanel tela;

    Dashboard(Window janela)
    {
        this.janela = janela;
        
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);

        JButton bt_receita = new JButton("Nova Receita");
        bt_receita.setBounds(20, 100, 400, 50);
        bt_receita.addActionListener(e -> ManterReceitas.CadastrarNovaReceita(janela));
        tela.add(bt_receita);

        JButton bt_despesa = new JButton("Nova Despesa");
        bt_despesa.setBounds(20, 150, 400, 50);
        bt_despesa.addActionListener(e -> ManterDespesas.CadastrarNovaDespesa(janela));
        tela.add(bt_despesa);

        JButton bt_vis = new JButton("Visualizar Despesas");
        bt_vis.setBounds(20, 200, 400, 50);
        bt_vis.addActionListener(e -> VisualizarDespesas.Visualizar(janela));
        tela.add(bt_vis);

        JButton bt_pagamento = new JButton("Novo Pagamento");
        bt_pagamento.setBounds(20, 250, 400, 50);
        bt_pagamento.addActionListener(e -> ManterPagamentos.CadastrarNovoPagamento(janela));
        tela.add(bt_pagamento);

        JButton bt_relatorio = new JButton("Gerar Relatório");
        bt_relatorio.setBounds(20, 300, 400, 50);
        bt_relatorio.addActionListener(e -> GerarRelatorio.GerarRelatorio(janela));
        tela.add(bt_relatorio);

        
    }


    public static void voltaTela(Window janela)
    {
        Tela nova = new Dashboard(janela);
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
        // TODO Auto-generated method stub
        return tela;
    }

    @Override
    public void removeTela() {
        // TODO Auto-generated method stub
        tela.setVisible(false);
    }
    
}
