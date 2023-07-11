package br.uepg.deinfo;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;
import java.util.Date;  

public class GerarRelatorio 
{
    public static void GerarRelatorio(Window janela)
    {
        Tela nova = new TelaGerarRelatorio(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);    
        nova.mostraTela();
    }


    public static Vector<Despesa> ConsultaDespesas()
    {
        Driver driver = new Driver("banco.bg");
        String[] argv = {"id","descricao","valor"};
        Stack<HashMap<String, String>> retorno = driver.ObterDados("SELECT * FROM Despesas", argv);

        Vector<Despesa> despesas = new Vector<Despesa>();

        for(HashMap<String, String> a: retorno)
        {
            Despesa temp = new Despesa();
            temp.setId(Integer.parseInt(a.get("id")));
            temp.setDescricao(a.get("descricao"));
            temp.setValor(Float.parseFloat(a.get("valor")));
            despesas.add(temp);
        }

        return despesas;
    }


    public static Vector<Receita> ConsultaReceitas()
    {
        Driver driver = new Driver("banco.bg");
        String[] argv = {"id","descricao","valor"};
        Stack<HashMap<String, String>> retorno = driver.ObterDados("SELECT * FROM Receitas", argv);

        Vector<Receita> receitas = new Vector<Receita>();

        for(HashMap<String, String> a: retorno)
        {
            Receita temp = new Receita();
            temp.setDescricao(a.get("descricao"));
            temp.setValor(Float.parseFloat(a.get("valor")));
            temp.setData(a.get("data"));
            receitas.add(temp);
        }

        return receitas;
    }


    public static Vector<Pagamento> ConsultaPagamentos()
    {
        Driver driver = new Driver("banco.bg");
        String[] argv = {"id","descricao","valor", "vecimento"};
        Stack<HashMap<String, String>> retorno = driver.ObterDados("SELECT * FROM Pagamentos", argv);

        Vector<Pagamento> pagamentos = new Vector<Pagamento>();

        for(HashMap<String, String> a: retorno)
        {
            Pagamento temp = new Pagamento();
            temp.setDescricao(a.get("descricao"));
            temp.setValor(Float.parseFloat(a.get("valor")));
            temp.setVencimento(a.get("vencimento"));
            pagamentos.add(temp);
        }

        return pagamentos;
    }

    
    public static void MostraRelatorio(Window janela, Vector<Despesa> despesas, Vector<Receita> receitas, Vector<Pagamento> pagamentos)
    { 
        Tela nova = new TelaRelatorio(janela);

        float total = 0;
        for(Despesa e:despesas)
        {
            total+=e.getValor();
        }


        System.out.println(total);


        janela.getAtual().removeTela();
        janela.setAtual(nova);    
        nova.mostraTela();
    }


    public static void ObterFiltros(Tela tela)
    {

    }
}
