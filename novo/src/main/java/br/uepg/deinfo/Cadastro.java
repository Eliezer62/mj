package br.uepg.deinfo;

public class Cadastro 
{
    private String email;
    private String senha;
    private String nome;
    private String nascimento;
    private float salario;

    public String getEmail() 
    {
        return this.email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getSenha() 
    {
        return this.senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getNascimento() 
    {
        return this.nascimento;
    }

    public void setNascimento(String nascimento) 
    {
        this.nascimento = nascimento;
    }

    public float getSalario() 
    {
        return this.salario;
    }

    public void setSalario(float salario) 
    {
        this.salario = salario;
    }

}
