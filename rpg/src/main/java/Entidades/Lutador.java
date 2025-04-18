package Entidades;

//Classe abstrata
public abstract class Lutador {

	protected int id;
	protected String nome;
	protected int vida;
	protected int escudo;
	protected int poderFisico;
	protected int poderHabilidade;
	protected int dado;
	
//	Atributos
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getEscudo() {
		return escudo;
	}
	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	public int getPoderFisico() { return poderFisico; }
	public void setPoderFisico(int poderFisico) {
		this.poderFisico = poderFisico;
	}
	public int getPoderHabilidade() {
		return poderHabilidade;
	}
	public void setPoderHabilidade(int poderHabilidade) {
		this.poderHabilidade = poderHabilidade;
	}
	
	public int getDado() {
		return dado;
	}
	protected void setDado(int dado) {
		this.dado = dado;
	}
	
	//Método para girar o dado em um número aleatório
	protected void girarDado() {
		//Utilizando o método MATH.RANDOM para gerar um número aleatório
		int numero = (int) (Math.random() * 21);
		//Com o reesultado do NUMERO, coloco o valor que o random deu para colocar no abributo SETTER ou DADO
		this.setDado(numero);
	}
	
	//Método para atacar o alvo
	public void atacar(Lutador alvo) {
		//Colocando o valor do dado dentro do método
		this.girarDado();
		
		//Gerando o ataque para causar o dano no alvo, somando Poder Físico com Poder Habilidade, 
		//depois multiplicando o resultado com o valor do dado que foi dado
		int dano = (this.getPoderFisico() + this.getPoderHabilidade()) * this.getDado();
		//Alvo recebe o dano
		alvo.defender(dano);	
	}
	
	//Método para o alvo se defender
	public void defender(int dano) {
		//IF para ver se o alvo tem escudo ou não, se tiver rodará adinate, se não pulara para próximo IF
		if (this.getEscudo() > 0) {
			
			//Valor do dano que tirará do escudo
			int valorEscudo = (this.getEscudo()) - (dano);
			this.setEscudo(valorEscudo);	
			
			//IF para ver se tem escudo, se não tiver o SET do Escudo ficará 0 (Estética do código)
			if (this.getEscudo() < 0) {
				this.setEscudo(0);
			}
			
			//IF para ver se está com escudo ainda. Se com um golpe tirou toda a porcentagem do escudo irá para outro método, 
			//Se não a porcentagem restante do golpe irá tirar da vida
			if(this.getEscudo() <= 0) {
				int valorVida = -valorEscudo; 
				this.setVida(this.getVida() - valorVida);
			}
			
		// IF para ver se tem escudo, se não tiver tirará da vida, pulando o primeiro IF
		}else if (this.getEscudo() <= 0) {
			this.setVida(this.getVida() - dano);
			
		} 
	}
	
}
