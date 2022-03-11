package aai;

public class Produtos extends CodigoCadastro{
	protected String descricao;
	protected int codigo;
	protected double preco;
	
	public Produtos(String descricao, double preco) {
		this.descricao = descricao;
		this.preco = preco;
		this.codigo= gerarCod();
	}

	public String getDescricao() {
		return descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getPreco() {
		return preco;
	}
	
}
