package br.uepg.deinfo;

import java.awt.Component;

import javax.swing.*;

public class TelaGerarRelatorio implements Tela
{
    private Window janela;
    private JPanel tela;

    TelaGerarRelatorio(Window window)
    {
        this.janela = window;
        tela = new JPanel();
        tela.setLayout(null);
        tela.setBounds(0,0,480, 720);
        tela.setVisible(true);

        GerarRelatorio.ConsultaDespesas();

        JLabel label = new JLabel("<html><span style=\"font-size: 24pt;\">Gerar Relatórios</span></html>");
        label.setBounds(20, 20, 250, 60);

        tela.add(label);


        //Filtros DESPESA
        JLabel label_despesas = new JLabel("<html><span style=\"font-size: 18pt;\">Filtrar Despesas</span></html>");
        label_despesas.setBounds(20,75,250,50);
        tela.add(label_despesas);

        JComboBox filtro_despesa  = new JComboBox();
        filtro_despesa.addItem("id");
        filtro_despesa.addItem("valor");
        
        filtro_despesa.setBounds(20, 125, 150, 25);
        tela.add(filtro_despesa);

        JLabel label2_despesa = new JLabel("<html><span style=\"font-size: 16pt;\">início \t-\t fim</span></html>");
        label2_despesa.setBounds(20, 175, 250, 30);
        tela.add(label2_despesa);

        JTextField campo_inicio_despesa  = new JTextField();
        campo_inicio_despesa.setBounds(20, 200, 150, 30);
        tela.add(campo_inicio_despesa);

        JTextField campo_fim_despesa  = new JTextField();
        campo_fim_despesa.setBounds(200, 200, 150, 30);
        tela.add(campo_fim_despesa);


        //FILTROS RECEITAS
        JLabel label_receitas = new JLabel("<html><span style=\"font-size: 18pt;\">Filtrar Receitas</span></html>");
        label_receitas.setBounds(20,250,250,50);
        tela.add(label_receitas);

        JComboBox filtro_receita  = new JComboBox();
        filtro_receita.addItem("Data");
        filtro_receita.addItem("Descrição");
        filtro_receita.addItem("Valor");
        
        filtro_receita.setBounds(20, 300, 150, 25);
        tela.add(filtro_receita);

        JLabel label2_receita = new JLabel("<html><span style=\"font-size: 16pt;\">início \t-\t fim</span></html>");
        label2_receita.setBounds(20, 350, 250, 30);
        tela.add(label2_receita);

        JTextField campo_inicio_receita  = new JTextField();
        campo_inicio_receita.setBounds(20, 375, 150, 30);
        tela.add(campo_inicio_receita);

        JTextField campo_fim_receita  = new JTextField();
        campo_fim_receita.setBounds(200, 375, 150, 30);
        tela.add(campo_fim_receita);


        //FILTROS PAGAMENTOS
        JLabel label_pagamentos = new JLabel("<html><span style=\"font-size: 18pt;\">Filtrar Pagamentos</span></html>");
        label_pagamentos.setBounds(20,425,250,50);
        tela.add(label_pagamentos);

        JComboBox filtro_pagamento  = new JComboBox();
        filtro_pagamento.addItem("Vencimento");
        filtro_pagamento.addItem("Descrição");
        filtro_pagamento.addItem("Valor");
        
        filtro_pagamento.setBounds(20, 475, 150, 25);
        tela.add(filtro_pagamento);

        JLabel label2_pagamento = new JLabel("<html><span style=\"font-size: 16pt;\">início \t-\t fim</span></html>");
        label2_pagamento.setBounds(20, 500, 250, 30);
        tela.add(label2_pagamento);

        JTextField campo_inicio_pagamento  = new JTextField();
        campo_inicio_pagamento.setBounds(20, 525, 150, 30);
        tela.add(campo_inicio_pagamento);

        JTextField campo_fim_pagamento  = new JTextField();
        campo_fim_pagamento.setBounds(200, 525, 150, 30);
        tela.add(campo_fim_pagamento);


        JButton bt_gerar = new JButton("GERAR");
        bt_gerar.setBounds(350, 600, 100, 50);
        bt_gerar.addActionListener(e -> GerarRelatorio.MostraRelatorio(janela, GerarRelatorio.ConsultaDespesas(), GerarRelatorio.ConsultaReceitas(),
        GerarRelatorio.ConsultaPagamentos()));
        tela.add(bt_gerar);

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
