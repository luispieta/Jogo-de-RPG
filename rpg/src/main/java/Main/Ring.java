
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
			CriarPersonagem criarPersonagem = new CriarPersonagem();

			System.out.println("===== MENU =====");
			System.out.println("Qual deseja acessar? \n 1 - Menu do Gestor/Desenvolvedor \n 2 - Menu de Batalhas");
			int acessarMenu = entrada.nextInt();

			//While para sempre mostrar o MENU
			while (true) {
				//Selecionar rotina que deseja
				System.out.println("===== MENU DE BATALHAS =====");
				System.out.println("Escolha uma opção \n 1 - Começar uma batalha \n 2 - Consultar dados \n 3 - Deletar batalha \n 4 - Criar seu próprio Personagem \n 5 - Sair");
				int escolha = entrada.nextInt();
				System.out.print("\n");

				//IFs para escolher alguma rotina
				if (escolha == 1) {
					System.out.println("===== BATALHA =====");
					IniciarBatalha iniciarBatalha = new IniciarBatalha(personagemRepositorio, criarPersonagemRepositorio);

					System.out.println("Jogador 1, escolha uma opção:");
					Lutador jogador1 = iniciarBatalha.escolherPersonagem();

					System.out.println("Jogador 2, escolha uma opção:");
					Lutador jogador2 = iniciarBatalha.escolherPersonagem();

					Batalha batalhas = new Batalha(jogador1, jogador2, null);
					batalhas.iniciar();
					batalhaRepositorio.salvarBatalha(batalhas);
					System.out.print("\n");

				} else if (escolha == 2) {
					loop: while(true) {
						System.out.println("===== CONSULTAR DADOS =====");
						System.out.println("O que deseja Consultar? \n 1 - Arquétipos \n 2 - Raças \n 3 - Personagens \n 4 - Personagens Criados \n 5 - Batalhas \n 6 - Sair");
						int consultar = entrada.nextInt();
						System.out.println("\n");

						switch (consultar) {
							case 1:
								System.out.println("Todos os Arquétipos");
								System.out.println(arquetipoRepositorio.buscarTodasArquetipos());
								break;

							case 2:
								System.out.println("Todos as Raças");
								System.out.println(racaRepositorio.buscarTodasRacas());
								break;

							case 3:
								System.out.println("Todos as Personagens");
								System.out.println(personagemRepositorio.buscarTodosPersonagens());
								break;

							case 4:
								System.out.println("Todos as Personagens Criados");
								System.out.println(criarPersonagemRepositorio.buscarTodosPersonagensCriados());
								break;

							case 5:
								System.out.println("Todas as Batalhas");
								System.out.println(batalhaRepositorio.buscarTodasBatalhas());
								break;

							case 6:
								break loop;

							default:
								System.out.println("Número Inválido");
								break;

						}

					} 
				
				} else if (escolha == 3) {
					loop: while (true) {
						System.out.println("===== DELETAR BATALHAS E PERSONAGENS CRIADOS =====");
						System.out.println("Escolha se deseja deletar alguma Batalha ou algum Personagem Criado \n 1 - Batalhas \n 2 - Personagens Criados \n 3 - Sair");
						int batalhaPersonagens = entrada.nextInt();

						switch (batalhaPersonagens) {
							case 1:
								System.out.print("Insira um ID para deletar uma Batalha: ");
								int deletarBatalha = entrada.nextInt();

								if (deletarBatalha > 0) {
									System.out.println("Deseja mesmo deletar a Batalha? \n S - sim \n N - Não");
									String simNao = entrada.next();

									if(simNao.equals("n")) {
										System.out.println("Cancelamento do registro a ser deletado.");

									} else {
										System.out.println(batalhaRepositorio.deletarBatalha(deletarBatalha));
										System.out.println("Batalha deletada, o ID deletado é " + deletarBatalha);

									}
								}
								break;

							case 2:
								System.out.print("Insira um ID para deletar um Personagem: ");
								int deletarPersonagem = entrada.nextInt();

								if (deletarPersonagem > 0) {
									System.out.println("Deseja mesmo deletar o Personagem? \n S - sim \n N - Não");
									String simNao = entrada.next();

									if(simNao.equals("n")) {
										System.out.println("Cancelamento do registro a ser deletado.");

									} else {
										System.out.println(batalhaRepositorio.deletarBatalha(deletarPersonagem));
										System.out.println("Personagem deletada, o ID deletado é " + deletarPersonagem);

									}
								}
								break;

							case 3:
								break loop;

							default:
								System.out.println("Número Inválido");
								break;

						}

					}

				} else if(escolha == 4) {
					System.out.println("===== CRIANDO O PRÓPRIO PERSONAGEM =====");
					System.out.println("Crie seu próprio jogador \n 1 - sim \n 2 - não");
					int criar = entrada.nextInt();
					criarPersonagem.personagensCriar(criar);

				} else {
					System.out.println("Obrigado por jogar!");
					System.out.println(criarPersonagemRepositorio.buscarTodosPersonagensCriados());
					break;

				} 
				
			}
		
		} 
		
	}

}