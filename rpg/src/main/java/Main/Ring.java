
package Main;
	
import java.util.Scanner;
import Entidades.*;
import Repositorio.RepositorioArquetipo;
import Repositorio.RepositorioRaca;
import Repositorio.RepositorioPersonagem;
import Repositorio.RepositorioBatalha;
import Repositorio.RepositorioCriarPersonagem;

public class Ring {
	public static void main(String[] args) {

		try (Scanner entrada = new Scanner(System.in)) {
			RepositorioPersonagem personagemRepositorio = new RepositorioPersonagem();
			RepositorioBatalha batalhaRepositorio = new RepositorioBatalha();
			RepositorioRaca racaRepositorio = new RepositorioRaca();
			RepositorioArquetipo arquetipoRepositorio = new RepositorioArquetipo();
			RepositorioCriarPersonagem criarPersonagemRepositorio = new RepositorioCriarPersonagem();

			//While para sempre mostrar o MENU
			while (true) {
				//Selecionar rotina que deseja
				System.out.println("===== MENU =====");
				System.out.println("Escolha uma opção \n 1 - Começar uma batalha \n 2 - Consultar dados \n 3 - Deletar batalha \n 4 - Criar seu próprio Personagem \n 5 - Sair");
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
							System.out.println("Todos as Personagens");
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
						String nomePersonagem = entrada.nextLine();

						System.out.println(personagemRepositorio.buscarTodosPersonagens());
						System.out.print("Selecione um personagem: ");
						int personagem = entrada.nextInt();
						Personagem escolhaPersonagem = personagemRepositorio.buscarPersonagemPorId(personagem);

						System.out.println(racaRepositorio.buscarTodasRacas());
						System.out.print("Selecione uma raça: ");
						int raca = entrada.nextInt();
						Raca escolhaRaca = racaRepositorio.buscarRacaPorId(raca);

						System.out.println(arquetipoRepositorio.buscarTodasArquetipos());
						System.out.print("Selecione um arquétipo: ");
						int arquetipo = entrada.nextInt();
						Arquetipo escolhaArquetipo = arquetipoRepositorio.buscarArquetipoPorId(arquetipo);

						CriarPersonagem personagemCriado = new CriarPersonagem(nomePersonagem, escolhaPersonagem, escolhaRaca, escolhaArquetipo);
						criarPersonagemRepositorio.salvarPersonagemCriado(personagemCriado);

					}

				} else {
					System.out.println("Obrigado por jogar!");
					break;

				} 
				
			}
		
		} 
		
	}

}