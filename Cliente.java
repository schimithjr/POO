package aai;

public class Cliente extends CodigoCadastro implements FuncoesApp {
	private String nome;
	private String telefone;
	private String endereco;
	private int codigo;
	private Pedido pedido;
	
	
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone= "Não informado";
		this.codigo= gerarCod();
	}
	
	
	


	public void fazerPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public String getNome() {
		return nome;
	}
	
	
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public String toString() {
		return "Nome: "+nome+"\nEndereço: "+endereco+"\nTelefone: "+telefone+"\nCódigo: "+codigo;
	}
	@Override
	public void statusPedido() {
		System.out.println(pedido.status);
	}


	@Override
	public String EmitirCupomFiscal() {
		String aux="";
		aux=this.nome+"\t"+this.codigo+"\n\n"
				+ "-------------------------------------\n";
		for(Produtos p : pedido.pedidos) {
			aux+=p.descricao+"\tR$"+p.preco+"\n";
		}
		aux+="\n-------------------------------------"
				+ "\nValor total\tR$"+pedido.valorTotal;
		return aux;
	}
	
	
}
