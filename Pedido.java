package aai;

import java.util.ArrayList;

public class Pedido {
	protected ArrayList<Produtos> pedidos;
	protected String status;
	protected double valorTotal;
	
	public Pedido() {
		this.pedidos= new ArrayList<Produtos>();
		this.status= "Nenhum pedido";
		this.valorTotal=0;
	}
	
	
	public String getStatus() {
		return status;
	}
	

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addProduto(Produtos p) {
		this.pedidos.add(p);
		this.valorTotal+= p.preco;
		this.status= "Solicitação enviada ao restaurante";
	}
	
	@Override
	public String toString() {
		String imp="";
		for(Produtos p : pedidos) {
			imp+= p.descricao+"\n";
		}
		return imp;
	}
	
	
}
