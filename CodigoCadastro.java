package aai;

import java.util.Random;
//Classe abstrata para se obter um código para o cadastro
public abstract class CodigoCadastro {
	public int gerarCod() {
		Random gerador= new Random();
		return gerador.nextInt(1000);
	}
}
