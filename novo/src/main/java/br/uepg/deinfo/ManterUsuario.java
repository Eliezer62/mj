package br.uepg.deinfo;

import java.util.HashMap;
public class ManterUsuario 
{
    Window janela;

    public static boolean PossuiConta(boolean res, Window janela)
    {
        if(res)
        {
            
            MostraTelaLogin(janela);
        }
        else
        {
            MostraTelaCadastro(janela);
        }

        return true;
    }


    public static Cadastro validarLogin(String email, String senha)
    {
        Driver driver = new Driver("banco.bg");
        
        HashMap resultado = driver.consultaLogin("SELECT * FROM Cadastro WHERE email=\""+email+"\"");
        
        String senhaBD = resultado.get("senha").toString();

        System.out.println(senhaBD.equals(senha));
        if(!senhaBD.equals(senha))
        {
            
            return null;
        }

        else
        {
            Cadastro cad = new Cadastro();
            cad.setEmail(resultado.get("email").toString());
            cad.setSenha(resultado.get("senha").toString());
            cad.setNascimento(resultado.get("nascimento").toString());
            cad.setNome(resultado.get("nome").toString());
            cad.setSalario(Float.parseFloat(resultado.get("salario").toString()));

            return cad;
        }
    }


    public static void MostraTelaLogin(Window janela)
    {
        Tela nova = new TelaLogin(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);
        nova.mostraTela();
    }

    public static void MostraTelaCadastro(Window janela)
    {
        Tela nova = new TelaCadastro(janela);
        janela.getAtual().removeTela();
        janela.setAtual(nova);
        nova.mostraTela();
    }


    public static void SalvaDados(Window janela, Cadastro cad)
    {
        Driver driver = new Driver("banco.bg");

        String q = "INSERT INTO cadastro (email, senha, nome, nascimento, salario) VALUES (\""+cad.getEmail()+"\", \""+cad.getSenha()+"\", \""+cad.getNome()+"\", \""+cad.getNascimento()+"\","+cad.getSalario()+")";

        driver.executarSQL(q);
        MostraTelaLogin(janela);
    }
}
