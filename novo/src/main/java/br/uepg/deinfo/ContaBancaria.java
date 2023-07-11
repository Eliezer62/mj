package br.uepg.deinfo;

public class ContaBancaria 
{
    private String banco;

    private int agencia;

    private int conta;

    private double saldo;

    public String getBanco() 
    {
        return this.banco;
    }

    public void setBanco(String banco) 
    {
        this.banco = banco;
    }

    public int getAgencia() 
    {
        return this.agencia;
    }

    public void setAgencia(int agencia) 
    {
        this.agencia = agencia;
    }

    public int getConta() 
    {
        return this.conta;
    }

    public void setConta(int conta) 
    {
        this.conta = conta;
    }

    public double getSaldo() 
    {
        return this.saldo;
    }

    public void setSaldo(double saldo) 
    {
        this.saldo = saldo;
    }

}
