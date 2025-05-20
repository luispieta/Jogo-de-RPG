package Entidades;

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

		int jogadorVida1 = lutador1.getVida();
		int jogadorVida2 = lutador2.getVida();
		int turno = 1;

		while(jogadorVida1 > 0 && jogadorVida2 > 0) {

			System.out.println("===== " + turno + "° TURNO =====");
			System.out.print("\n");

			int ataqueJogador1 = 0;
			lutador1.girarDado();
			ataqueJogador1 = (lutador1.getPoderFisico() + lutador1.getPoderHabilidade()) + lutador1.getDado();

			jogadorVida2 -= ataqueJogador1;
			System.out.println("Jogador 1 causou " + ataqueJogador1 + " de dano no jogador 2, resultando em " + (jogadorVida2 - ataqueJogador1) + " de vida" );
			System.out.print("\n");
			if(jogadorVida2 <= 0) {
				System.out.println("O jogador 2 foi derrotado");
			}

			int ataqueJogador2 = 0;
			lutador2.girarDado();
			ataqueJogador2 = (lutador2.getPoderFisico() + lutador2.getPoderHabilidade()) + lutador2.getDado();

			jogadorVida1 -= ataqueJogador2;
			System.out.println("Jogador 2 causou " + ataqueJogador2 + " de dano no jogador 1, resultando em " + (jogadorVida1 - ataqueJogador2) + " de vida" );
			System.out.print("\n");
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
		/*
		while(true) {
			if (lutador1.getVida() > 0 && lutador2.getVida() > 0) {
				lutador1.atacar(lutador2);
				lutador2.atacar(lutador1);
						
			} else if (lutador1.getVida() > 0 && lutador2.getVida() <= 0){
				this.setVencedor(lutador1);
				lutador2.setVida(0);
				System.out.println("\nO ganhador da batalha é o Jogador 1 com o personagem " + lutador1.getNome() + " com o ID ");
				break;
				
			} else if (lutador1.getVida() <= 0 && lutador2.getVida() > 0) {
				this.setVencedor(lutador2);
				lutador1.setVida(0);
				System.out.println("\nO ganhador da batalha é o Jogador 2 com o personagem " + lutador2.getNome() + " com o ID ");
				break;
				
			} else {
				System.out.println("Ouve um empate!");
				this.setVencedor(null);
				lutador1.setVida(0);
				lutador2.setVida(0);
				System.out.println("\nSituação dos personagens depois da batalha \n" + lutador2.toString() + lutador1.toString());
				break;
			}
		}
		 */
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
