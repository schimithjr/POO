package aai;

import java.util.ArrayList;
// A classe loja herda a classe abstrata CodigoCadastro e implementa a interface FuncoesApp
public class Loja extends CodigoCadastro implements FuncoesApp{
	private String nomeLoja;
	private ArrayList<Produtos> itens;
	private int codigo;
	private Pedido pedido;
	private boolean solicitacao;
	
	public Loja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
		this.codigo= gerarCod();
		this.itens= new ArrayList<Produtos>();
		this.solicitacao= false;
	}
	
	
	
	public String getNomeLoja() {
		return nomeLoja;
	}


	public void addItem(Produtos p) {
		itens.add(p);
	}
	
	
	public void cardapio() {
		System.out.println(this.nomeLoja+"\tCódigo da loja: "+this.codigo);
		int cont=0;
		for(Produtos p : itens) {
			cont++;
			System.out.println(cont+"- "+p.getDescricao()+"\tR$"+p.getPreco()+"\t"+p.getCodigo());
			
		}
	}
	
	public void receberPedido(Pedido p) {
		this.pedido= p;
		if(pedido!=null) {
			this.solicitacao= true;
			pedido.status= "Pedido recebido e sendo feito.";
		}
	}
	
	public void pedidoPronto(){
		if(solicitacao) {
			this.pedido.status= "Pedido pronto e encaminhado.";
			System.out.println("Pedido Pronto!");
		}
	}
	// Sobreescrevendo métodos da interface
	@Override
	public void statusPedido() {
		System.out.println(this.pedido.status);
		
	}

	@Override
	public String EmitirCupomFiscal() {
		String aux;
		aux=this.nomeLoja+"\t"+this.codigo+"\n"
				+ "-------------------------------------\n";
		for(Produtos p : pedido.pedidos) {
			aux+=p.descricao+"     "+p.codigo+"     R$"+p.preco+"\n";
		}
		aux+="\n-------------------------------------"
				+ "\nValor total\tR$"+pedido.valorTotal;
		return aux;
	}
	
	
	
}
