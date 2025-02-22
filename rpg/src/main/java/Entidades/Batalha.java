package Entidades;

public class Batalha extends Personagem{

	protected int id;
	protected Personagem lutador1;
	protected Personagem lutador2;
	protected Personagem vencedor;
	
	public Batalha() {
		
	}
	
	public Batalha (Personagem lutador1, Personagem lutador2, Personagem vencedor) {
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
	public Personagem getLutador1() {
		return lutador1;
	}
	public void setLutador1(Personagem lutador1) {
		this.lutador1 = lutador1;
	}
	public Personagem getLutador2() {
		return lutador2;
	}
	public void setLutador2(Personagem lutador2) {
		this.lutador2 = lutador2;
	}
	public Personagem getVencedor() {
		return vencedor;
	}
	public void setVencedor(Personagem vencedor) {
		this.vencedor = vencedor;
	}
	
	//Método para iníciar a batalha 
	public void iniciar() {
		while(true) {
			if (lutador1.getVida() > 0 && lutador2.getVida() > 0) {
				lutador1.atacar(lutador2);
				lutador2.atacar(lutador1);
						
			} else if (lutador1.getVida() > 0 && lutador2.getVida() <= 0){
				this.setVencedor(lutador1);
				lutador2.setVida(0);
				System.out.println("\nO ganhador da batalha é o Jogador 1 com o personagem " + lutador1.getNome() + " com o ID " + lutador1.getId());
				break;
				
			} else if (lutador1.getVida() <= 0 && lutador2.getVida() > 0) {
				this.setVencedor(lutador2);
				lutador1.setVida(0);
				System.out.println("\nO ganhador da batalha é o Jogador 2 com o personagem " + lutador2.getNome() + " com o ID " + lutador2.getId());
				break;
				
			} else {
				System.out.println("Ouve um empate!");
				lutador1.setVida(0);
				lutador2.setVida(0);
				System.out.println("\nSituação dos personagens depois da batalha \n" + lutador2.toString() + lutador1.toString());
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "\n [id=" + this.getId() + ", lutador1=" + lutador1.getId() + ", lutador2=" + lutador2.getId() + ", vencedor=" + vencedor.getId()
				+ "]";
	}
	
}
