package br.uepg.deinfo;

public class ManterReceitas 
{
    public static void CadastrarNovaReceita(Window janela)
    {
        Tela nova = new TelaReceita(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);
        nova.mostraTela();
    }


    public static void SalvarReceita(String data, String valor, String descricao)
    {
        Driver driver = new Driver("banco.bg");
        
        driver.executarSQL("INSERT INTO \"Receitas\"(data, descricao, valor) VALUES (\""+data+"\",\""+descricao+"\","+valor+");");
    }


    public static void RemoverReceita(Window janela)
    {
        Tela nova = new TelaReceitaRemover(janela);
        janela.setAtual(nova);
        nova.mostraTela();
    }


    public static void ExcluirReceita(int id)
    {
        Driver driver = new Driver("banco.bg");
        driver.executarSQL("DELETE FROM Receitas WHERE id="+id);
    }
}
