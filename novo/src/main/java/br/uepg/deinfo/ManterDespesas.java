package br.uepg.deinfo;

public class ManterDespesas
{
    public static void CadastrarNovaDespesa(Window janela)
    {
        Tela nova = new TelaDespesa(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);    
        nova.mostraTela();
    }


    public static void SalvarDespesa(String valor, String descricao)
    {
        Driver driver = new Driver("banco.bg");
        
        driver.executarSQL("INSERT INTO \"Despesas\"( descricao, valor) VALUES (\""+descricao+"\","+valor+");");
    }


    public static void RemoverDespesa(Window janela)
    {
        Tela nova = new TelaDespesaRemover(janela);
        janela.setAtual(nova);
        nova.mostraTela();
    }


    public static void ExcluirDespesa(int id)
    {
        Driver driver = new Driver("banco.bg");
        driver.executarSQL("DELETE FROM Despesas WHERE id="+id);
    }
}
