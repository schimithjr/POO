package aai;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		//Criando lojas e produtos
		Loja l1= new Loja("Pizzzaria");
		Produtos p1= new Produtos("Pizza G", 35.5);
		Produtos p2= new Produtos("Pizza M", 32);
		Produtos p3= new Produtos("Pizza P", 29.5);
		
		Loja l2= new Loja("Lanchonete");
		Produtos p4= new Produtos("Hamburguer", 15);
		Produtos p5= new Produtos("Salgado", 4.5);
		Produtos p6= new Produtos("Pastel", 6);
		
		Loja l3= new Loja("Distribuidora");
		Produtos p7= new Produtos("Cerveja", 4.5);
		Produtos p8= new Produtos("Vodka", 32);
		Produtos p9= new Produtos("Cachaça", 20);
		
		//Criando objeto pedido
		Pedido pe= new Pedido();
		
		//Adicionando produtos ao cardápio da loja
		l1.addItem(p1);
		l1.addItem(p2);
		l1.addItem(p3);
		
		l2.addItem(p4);
		l2.addItem(p5);
		l2.addItem(p6);
		
		l3.addItem(p7);
		l3.addItem(p8);
		l3.addItem(p9);
		//op-> Pedido/ op2-> definir telefone/ op3-> Avisar que o pedido está pronto
		// aux-> Escolher loja
		int op, op2=0, op3=0, aux=0;
		//Cadastro do cliente
		System.out.println("Qual seu nome?");
		String nome= sc.next();
		System.out.println("Insira seu endereço: ");
		String endereco= sc.next();
		Cliente c1= new Cliente(nome, endereco);
		c1.fazerPedido(pe);
		//Telefone opcional
		do {
			System.out.println("Deseja inserir telefone?\n1-Sim\n2-Não");
			op2=sc.nextInt();
			if(op2==1) {
				System.out.println("Digite seu telefone:");
				String telefone= sc.next();
				c1.setTelefone(telefone);
				System.out.println("Cadastro feito com sucesso!");
			} else if(op2==2) {
				System.out.println("Cadastro feito com sucesso!");
			} else {
				System.out.println("Insira uma opção válida");
			}
		}while (op2!=1 && op2!=2);
		
		//Iniciando o pedido pela escolha da loja
		while(aux!=1 && aux!=2 && aux!=3) {
			System.out.println("Qual loja deseja acessar?\n"
					+ "1-"+l1.getNomeLoja()+
					"\n2-"+l2.getNomeLoja()
					+"\n3-"+l3.getNomeLoja());
			aux= sc.nextInt();
			if(aux!=1 && aux!=2 && aux!=3) {
				System.out.println("Inválido.");
			}
		}
		
		//Agora, a escolha do(s) produto(s)
		try {
			do {
			op=0;
			System.out.println("Faça seu pedido através dos números indicados");
			if(aux==1) {
				l1.cardapio();
			} else if(aux==2) {
				l2.cardapio();
			} else if(aux==3) {
				l3.cardapio();
			}
			System.out.println("4- Finalizar");
			
				op=sc.nextInt();
				switch(op) {
				case 1:
					if(aux==1) {
						pe.addProduto(p1);
					} else if(aux==2) {
						pe.addProduto(p4);
					} else if(aux==3) {
						pe.addProduto(p7);
					}
					break;
				case 2:
					if(aux==1) {
						pe.addProduto(p2);
					} else if(aux==2) {
						pe.addProduto(p5);
					} else if(aux==3) {
						pe.addProduto(p8);
					}
					break;
				case 3:
					if(aux==1) {
						pe.addProduto(p3);
					} else if(aux==2) {
						pe.addProduto(p6);
					} else if(aux==3) {
						pe.addProduto(p9);
					}
					break;
				case 4:
					System.out.println("Pedido computado.");
					System.out.println(c1.EmitirCupomFiscal());
					break;
				default:
					System.out.println("Opção inválida");
				}
				
			
			}while (op!=4);
		} catch (InputMismatchException e) {
			System.out.println("Insira um dígito válido.");
		}
		
		//A loja recebe o pedido e emite seu cupom fiscal
		if(aux==1) {
			l1.receberPedido(pe);
			l1.statusPedido();
			System.out.println(l1.EmitirCupomFiscal());
		} else if(aux==2) {
			l2.receberPedido(pe);
			l2.statusPedido();
			System.out.println(l2.EmitirCupomFiscal());
		} else if(aux==3) {
			l3.receberPedido(pe);
			l3.statusPedido();
			System.out.println(l3.EmitirCupomFiscal());
		}
		
		//Confirmação do pedido pronto pela loja
		do {
			System.out.println("O pedido está pronto?\n1-Sim\n2-Não");
			op3=sc.nextInt();
			if(op3==1 && aux==1) {
				l1.pedidoPronto();
				l1.statusPedido();
			}if(op3==1 && aux==2) {
				l2.pedidoPronto();
				l2.statusPedido();
			}if(op3==1 && aux==3) {
				l3.pedidoPronto();
				l3.statusPedido();
			} if(op3!=1 && op3!=2) {
				System.out.println("Opção inválida");
			}
		} while(op3!=1);
		
		//Emissão do cupom fiscal com informações do cliente
		System.out.println(c1.EmitirCupomFiscal());
		sc.close();
	}

}
