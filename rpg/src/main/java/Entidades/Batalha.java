package Entidades;

import java.util.Scanner;

public class Batalha {

	protected int id;
	protected Lutador lutador1;
	protected Lutador lutador2;
	protected Lutador vencedor;
	
	public Batalha() {
		
	}
	
	public Batalha (Lutador lutador1, Lutador lutador2, Lutador vencedor) {
		this.lutador1 = lutador1;
		this.lutador2 = lutador2;
		this.vencedor = vencedor;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Lutador getLutador1() {
		return lutador1;
	}
	public void setLutador1(Lutador lutador1) {
		this.lutador1 = lutador1;
	}
	public Lutador getLutador2() {
		return lutador2;
	}
	public void setLutador2(Lutador lutador2) {
		this.lutador2 = lutador2;
	}
	public Lutador getVencedor() {
		return vencedor;
	}
	public void setVencedor(Lutador vencedor) {
		this.vencedor = vencedor;
	}
	
	//Método para iníciar a batalha
	public void iniciar() {

		Scanner validacao = new Scanner(System.in);
		int jogadorVida1 = lutador1.getVida() + lutador1.getEscudo();
		int jogadorVida2 = lutador2.getVida() + lutador2.getEscudo();
		int turno = 1;

		while(jogadorVida1 > 0 && jogadorVida2 > 0) {

			System.out.println("===== " + turno + "° TURNO =====");
			System.out.print("\n");

			int ataqueJogador1 = 0;
			int defenderJogador1 = 0;
			System.out.println("VEZ DO JOGADOR " + lutador1.getNome());
			System.out.println("Faça uma escolha para o personagem \n 1 - Atacar \n 2 - Defender");
			int reacaoJogador1 = validacao.nextInt();

			//atacar
			if(reacaoJogador1 == 1) {
				System.out.print("\n");
				lutador1.girarDado();
				ataqueJogador1 = (lutador1.getPoderFisico() + lutador1.getPoderHabilidade()) + lutador1.getDado();
				jogadorVida2 -= ataqueJogador1;
				System.out.printf("Jogador" + lutador1.getNome() + " causou " + ataqueJogador1 + " de dano no jogador " + lutador2.getNome()
						+ ", deixando " + (jogadorVida2 - ataqueJogador1) + " de vida" );

				//defender
			} else {
				lutador1.girarDado();
				defenderJogador1 = jogadorVida2 / lutador1.getDado();
				jogadorVida2 -= defenderJogador1;
				System.out.println("Jogador " + lutador1.getNome() + " defendeu " + defenderJogador1 + " de dano no jogador 1, resultando em "
						+ (jogadorVida2 - defenderJogador1) + " de vida" );

			}

			if(jogadorVida2 <= 0) {
				System.out.println("O jogador 2 foi derrotado");
			}

			int ataqueJogador2 = 0;
			int defenderJogador2 = 0;
			System.out.println("Vez do Jogador 1");
			System.out.println("Faça uma escolha para o personagem \n 1 - Atacar \n 2 - Defender");
			int reacaoJogador2 = validacao.nextInt();

			//atacar
			if(reacaoJogador2 == 1) {
				lutador2.girarDado();
				ataqueJogador2 = (lutador2.getPoderFisico() + lutador2.getPoderHabilidade()) + lutador2.getDado();
				jogadorVida2 -= ataqueJogador2;
				System.out.printf("Jogador" + lutador2.getNome() + " causou " + ataqueJogador2 + " de dano no jogador " + lutador1.getNome()
						+ ", deixando " + (jogadorVida1 - ataqueJogador2) + " de vida" );

			//defender
			} else {
				lutador2.girarDado();
				defenderJogador2 = jogadorVida2 / lutador2.getDado();
				jogadorVida2 -= defenderJogador2;
				System.out.println("Jogador " + lutador2.getNome() + " defendeu " + defenderJogador2 + " de dano no jogador 1, resultando em " + (jogadorVida2 - defenderJogador2) + " de vida" );

			}

			if(jogadorVida1 <= 0){
				System.out.println("O jogador 1 foi derrotado");
			}

			turno++;
			System.out.print("\n");
		}

		if(jogadorVida1 > 0) {
			System.out.println("Jogador 1 ganhou");
			this.setVencedor(lutador1);

		} else if(jogadorVida2 > 0) {
			System.out.println("Jogador 2 ganhou");
			this.setVencedor(lutador2);

		} else{
			System.out.println("Ouve um empate");
			this.setVencedor(null);

		}

	}

	@Override
	public String toString() {
		return "\nBatalha [" +
				"\n id = " + this.getId() +
				"\n lutador1 = " + lutador1.getNome() +
				"\n lutador2 = " + lutador2.getNome() +
				"\n vencedor = " + vencedor + " ]\n";
	}
	
}
