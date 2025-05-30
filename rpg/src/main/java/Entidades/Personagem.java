package Entidades;

//Classe PERSONAGENS Herdada de LUTADOR
public class Personagem extends Lutador {

	//Aributos
	protected int id;
	private Raca raca;
	private Arquetipo arquetipo;

	public Personagem() { }
	
	//Abrituto Construtor
	public Personagem(String nome, int vida, int escudo, int poderFisico, int poderHabilidade, Raca raca, Arquetipo arquetipo) {
		this.nome = nome;
		this.vida = vida;
		this.escudo = escudo;
		this.poderFisico = poderFisico;
		this.poderHabilidade = poderHabilidade;
		this.raca = raca;
		this.arquetipo = arquetipo;

		this.vida = getVida() + raca.getVida() + arquetipo.getVida();
		this.escudo = getEscudo() + raca.getEscudo() + arquetipo.getEscudo();
		this.poderFisico = getPoderFisico() + raca.getPoderFisico() + arquetipo.getPoderFisico();
		this.poderHabilidade = getPoderHabilidade() + raca.getPoderHabilidade() + arquetipo.getPoderHabilidade();
	}

	//Abributos Getteres e Setteres
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Arquetipo getArquetipo() {
		return arquetipo;
	}

	public void setArquetipo(Arquetipo arquetipo) {
		this.arquetipo = arquetipo;
	}

	//Método para visualizar Atríbutos dos Personagens
	public String toString() {
		return "\nPersonagem [ " +
				"\n Id: " + this.getId()  +
				"\n Nome: " + this.getNome() +
				"\n Vida: " + this.getVida() +
				"\n Escudo: = " + this.getEscudo() +
				"\n Poder Físico: " + this.getPoderFisico() +
				"\n Poder Habilidade: " + this.getPoderHabilidade() +
				"\n Raca: " + raca.getId() +
				"\n Arquetipo: " + arquetipo.getId() + " ]\n";

	}
	
}
