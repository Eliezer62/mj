package br.uepg.deinfo;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Stack;

public class Driver 
{
    private Statement statement;
    PreparedStatement stmt;
    private Connection conexao;

    Driver(String bg)
    {
        try 
        {
            conexao = DriverManager.getConnection("jdbc:sqlite:"+bg);
            if (conexao != null) 
            {  
                DatabaseMetaData meta = conexao.getMetaData();  
            }  
            System.out.println("Conexão Realizada com Sucesso");
            statement = conexao.createStatement();
        } 
        catch (SQLException  e) 
        {
            System.out.println("ERRO BANCO DE DADOS: "+e.getMessage());
        }
    }


    public void executarSQL(String q)
    {
        try
        {
            stmt = conexao.prepareStatement(q);
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public HashMap consultaLogin(String q)
    {
        try
        {
            stmt = conexao.prepareStatement(q);
            ResultSet resultSet = stmt.executeQuery();
            HashMap <String, String> retorno = new HashMap<String, String>();
            while(resultSet.next())
            {
                retorno.put("email", resultSet.getString("email"));
                retorno.put("nome", resultSet.getString("nome"));
                retorno.put("nascimento", resultSet.getString("nascimento"));
                retorno.put("salario", resultSet.getString("salario"));
                retorno.put("senha", resultSet.getString("senha"));
            }

            return retorno;
        }   
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        } 
    }


    public Stack<HashMap<String, String>> ObterDados(String q, String[] valores)
    {
        try
        {
            stmt = conexao.prepareStatement(q);
            ResultSet resultSet = stmt.executeQuery();
            Stack<HashMap<String, String>> dados = new Stack<HashMap<String, String>>();
            while(resultSet.next())
            {
                HashMap<String, String> temp = new HashMap<String, String>();
                for(int c=0;c<valores.length;c++)
                {
                    temp.put(valores[c], resultSet.getString(valores[c]));
                }
                dados.push(temp);
            }
            

            return dados;
        }   
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        } 
    }

    
}
