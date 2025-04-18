
package Main;
	
import java.nio.channels.Selector;
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

			if (acessarMenu == 2) {
				System.out.println("Acesse com seu Login e Senha");
				System.out.println("Insirá seu Login");
				String login = entrada.next();
				System.out.println("Insirá sua senha");
				String senha = entrada.next();

			} else {

			}
			//While para sempre mostrar o MENU
			while (true) {
				//Selecionar rotina que deseja
				System.out.println("===== MENU DE BATALHAS =====");
				System.out.println("Escolha uma opção \n 1 - Começar uma batalha \n 2 - Consultar dados \n 3 - Deletar batalha \n 4 - Criar seu próprio Personagem \n 5 - Sair");
				int escolha = entrada.nextInt();
				System.out.print("\n");

				//IFs para escolher alguma rotina
				if (escolha == 1) {

					IniciarBatalha iniciarBatalha = new IniciarBatalha(personagemRepositorio, criarPersonagemRepositorio);

					System.out.println("Jogador 1, escolha uma opção:");
					Lutador jogador1 = iniciarBatalha.escolherPersonagem();

					System.out.println("Jogador 2, escolha uma opção:");
					Lutador jogador2 = iniciarBatalha.escolherPersonagem();

					//Resultado NULL para dizer que não tem nem um jogador como vencedor
					Lutador vencedor = null;

                    if (jogador1.getVida() > jogador2.getVida()) {
						vencedor = jogador1;

					} else if (jogador2.getVida() > jogador1.getVida()) {
						vencedor = jogador2;

					} else {
						System.out.println("Empate!");
					}
				
					Batalha batalhas = new Batalha(jogador1, jogador2, vencedor);
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