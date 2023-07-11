package br.uepg.deinfo;

public class VisualizarDespesas 
{
    public static void Visualizar(Window janela)
    {
        Tela nova = new TelaVisualizarDespesas(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);
        nova.mostraTela();
    }
}
