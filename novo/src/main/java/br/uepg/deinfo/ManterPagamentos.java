package br.uepg.deinfo;

public class ManterPagamentos 
{
    public static void CadastrarNovoPagamento(Window janela)
    {
        Tela nova = new TelaPagamento(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);    
        nova.mostraTela();
    }


    public static void SalvarPagamento(String vencimento, String valor, String descricao)
    {
        Driver driver = new Driver("banco.bg");
        
        driver.executarSQL("INSERT INTO \"Pagamentos\"(vencimento, descricao, valor) VALUES (\""+vencimento+"\",\""+descricao+"\","+valor+");");
    }


    public static void ExcluirPagamento(int id)
    {
        Driver driver = new Driver("banco.bg");
        driver.executarSQL("DELETE FROM Pagamentos WHERE id="+id);
    }
}
