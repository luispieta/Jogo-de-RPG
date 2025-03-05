
package Main;
	
import java.util.Scanner; 
import Entidades.Personagem;
import Entidades.Batalha;
import Repositorio.RepositorioArquetipo;
import Repositorio.RepositorioRaca;
import Repositorio.RepositorioPersonagem;
import Repositorio.RepositorioBatalha;

public class Ring {
	public static void main(String[] args) {

		try (Scanner entrada = new Scanner(System.in)) {
			RepositorioPersonagem personagemRepositorio = new RepositorioPersonagem();
			RepositorioBatalha batalhaRepositorio = new RepositorioBatalha(); 
			RepositorioRaca racaRepositorio = new RepositorioRaca();
			RepositorioArquetipo arquetipoRepositorio = new RepositorioArquetipo();

			//While para sempre mostrar o MENU
			while (true) {
				//Selecionar rotina que deseja
				System.out.println("===== MENU =====");
				System.out.println("Escolha uma opção \n 1 - Começar uma batalha \n 2 - Consultar dados \n 3 - Deletar batalha \n 4 - Sair");
				int escolha = entrada.nextInt();
				System.out.print("\n");

				//IFs para escolher alguma rotina
				if (escolha == 1) {
					//Consultar personagens, assim escolhendo para poder jogar contra o outro jogador
					System.out.println(personagemRepositorio.buscarTodosPersonagens());
					System.out.println("Escolha um personagem digitando de 1 a 10");

					System.out.print("Jogador 1: ");
					int escolha1 = entrada.nextInt();
					System.out.print("Jogador 2: ");
					int escolha2 = entrada.nextInt();
								
					Personagem escolhaJogador1 = personagemRepositorio.buscarPersonagemPorId(escolha1);
					Personagem escolhaJogador2 = personagemRepositorio.buscarPersonagemPorId(escolha2);

					//Resultado NULL para dizer que não tem nem um jogador como vencedor
					Personagem vencedor = null;
							
					
					if (escolhaJogador1.getVida() > escolhaJogador2.getVida()) {
						vencedor = escolhaJogador1;
							
					} else if (escolhaJogador2.getVida() > escolhaJogador1.getVida()) {
						vencedor = escolhaJogador2;
					
					} else {
						System.out.println("Empate!");
					}
				
					Batalha batalhas = new Batalha(escolhaJogador1, escolhaJogador2, vencedor);
					batalhas.iniciar();
					batalhaRepositorio.salvarBatalha(batalhas);

				} else if (escolha == 2) {
					while(true) {
						System.out.println("===== CONSULTAR DADOS =====");
						System.out.println("O que deseja Consultar? \n 1 - Arquétipos \n 2 - Raças \n 3 - Personagens \n 4 - Batalhas \n 5 - Sair");
						int consultar = entrada.nextInt();
						System.out.println("\n");

						if (consultar == 1) {
							System.out.println("Todos os Arquétipos");
							System.out.println(arquetipoRepositorio.buscarTodasArquetipos());

						} else if (consultar == 2) {
							System.out.println("Todos as Raças");
							System.out.println(racaRepositorio.buscarTodasRacas());

						} else if (consultar == 3) {
							System.out.println("Todos as Persongens");
							System.out.println(personagemRepositorio.buscarTodosPersonagens());

						} else if (consultar == 4) {
							System.out.println("Todas as Batalhas");
							System.out.println(batalhaRepositorio.buscarTodasBatalhas());

						} else {
							break;

						}

					} 
				
				} else if (escolha == 3) {
					
					while (true) {
						System.out.print("Insira um ID para deletar uma batalha: ");
						int deletar = entrada.nextInt();
						
						if (deletar > 0) {
							System.out.println("Deseja mesmo deletar a batalha? \n S - sim \n N - Não");
							String simNao = entrada.next();
							
							if(simNao.equals("n")) {
								System.out.println("Cancelamento do registro a ser deletado.");

							} else {
								System.out.println(batalhaRepositorio.deletarBatalha(deletar));
								System.out.println("Batalha deletada, o ID deletado é " + deletar);
								
							}
						}
					}

				} else if(escolha == 4) {
					System.out.println("Crie seu próprio jogador \n 1 - sim \n 2 - não");
					int criarPersonagem = entrada.nextInt();
					
					if (criarPersonagem == 2) {
						break;
					} else {
						System.out.print("Escolha um nome para seu personagem: ");
						String nomePersonagem = entrada.next();

						System.out.println("Selecione um personagem")

					}
					

				} else {
					System.out.println("Obrigado por jogar!");
					break;

				} 
				
			}
		
		} 
		
	}

}