package Entidades;

import Repositorio.RepositorioCriarPersonagem;
import Repositorio.RepositorioPersonagem;

//Classe PERSONAGENS Herdada de LUTADOR
public class Personagem extends Lutador{

	RepositorioPersonagem personagemRepositorio = new RepositorioPersonagem();
	RepositorioCriarPersonagem criarPersonagemRepositorio = new RepositorioCriarPersonagem();

	//Aributos
	protected int id;
	public Raca raca;	
	private Arquetipo arquetipo;

	public Personagem() {
		
	}
	
	//Abrituto Construtor
	public Personagem(String nome, int vida, int escudo, int poderFisico, int poderHabilidade, Raca raca, Arquetipo arquetipo) {
		this.nome = nome;
		this.vida = vida;
		this.escudo = escudo;
		this.poderFisico = poderFisico;
		this.poderHabilidade = poderHabilidade;
		this.raca = raca;
		this.arquetipo = arquetipo;
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

	public void escolhaPersonagem(int escolha) {

		while(escolha != 3) {
			if (escolha == 2) {
				System.out.println(criarPersonagemRepositorio.buscarTodosPersonagensCriados());

			} else {
				//Consultar personagens, assim escolhendo para poder jogar contra o outro jogador
				System.out.println(personagemRepositorio.buscarTodosPersonagens());

			}
			break;
		}
	}
	
	//Método para visualizar Atríbutos dos Personagens
	public String toString() {
		return "id = " + this.getId()  + ",\n nome = " + this.getNome() + ",\n vida = " + this.getVida() + ",\n escudo = " + this.getEscudo() + 
				",\n Poder Físico = " + this.getPoderFisico() + ",\n Poder Habilidade = " + this.getPoderHabilidade() + ",\n Raca = " + raca.getId() + ",\n Arquetipo = " + arquetipo.getId() +",\n Valor do dado = " + this.getDado() + "\n \n";
	}
	
}
