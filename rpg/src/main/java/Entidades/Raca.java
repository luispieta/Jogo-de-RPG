package Entidades;

public class Raca extends Lutador{

	public Raca() {
		
	}
	
	public Raca(String nome, int vida, int escudo, int poderFisico, int poderHabilidade) {
		this.nome = nome;
		this.vida = vida;
		this.escudo = escudo;
		this.poderFisico = poderFisico;
		this.poderHabilidade = poderHabilidade;
	}

	protected int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
		
	public String toString() {
		return "\nRaça [" +
				"\n Id: " + this.getId() +
				"\n Nome: " + this.getNome() +
				"\n Vida: " + this.getVida() +
				"\n Escudo: " + this.getEscudo() +
				"\n Poder Físico: " + this.getPoderFisico() +
				"\n Poder Habilidade: " + this.getPoderHabilidade() + " ]\n";
	}
	
}
