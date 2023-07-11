package br.uepg.deinfo;

public class Pagamento {

	private String vencimento;

	private String descricao;

	private float valor;

	public String getVencimento() {
		return this.vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
