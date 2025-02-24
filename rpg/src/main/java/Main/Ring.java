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
			/*
			
			//Salavando as raças
			Raca elfo = new Raca("Elfo", 200, 130, 5, 15); 
			racaRepositorio.salvarRaca(elfo);
			
			Raca anao = new Raca("Anão", 180, 80, 7, 20); 
			racaRepositorio.salvarRaca(anao);
			
			Raca orc = new Raca("Orc", 250, 100, 4, 18);
			racaRepositorio.salvarRaca(orc);
		
			Raca humano = new Raca("Humano", 150, 150, 10, 12); 
			racaRepositorio.salvarRaca(humano);        
			
			Raca dragao = new Raca("Dragão", 300, 100, 15, 25);	
			racaRepositorio.salvarRaca(dragao);
			
			//Salvando os arquétipos
			Arquetipo guerreiro = new Arquetipo("Guerreiro", 25, 20, 0, 15);  
			arquetipoRepositorio.salvarArquetipo(guerreiro);
			
			Arquetipo arqueiro = new Arquetipo("Arqueiro", 15, 25, 5, 10);   
			arquetipoRepositorio.salvarArquetipo(arqueiro);
			
			Arquetipo mago = new Arquetipo("Mago", 10, 10, 25, 10);          
			arquetipoRepositorio.salvarArquetipo(mago);

			Arquetipo berserker = new Arquetipo("Berserker", 30, 10, 0, 20);  
			arquetipoRepositorio.salvarArquetipo(berserker);
			        
			Arquetipo xama = new Arquetipo("Xamã", 15, 10, 20, 15); 
			arquetipoRepositorio.salvarArquetipo(xama);
			
			Arquetipo monge = new Arquetipo("Monge", 50, 5, 10, 25);
			arquetipoRepositorio.salvarArquetipo(monge);
			
			//Salvando os Personagens 
			Personagem thorin = new Personagem("Thorin", 1000 + anao.getVida() + guerreiro.getVida(), 500 + anao.getEscudo() + guerreiro.getEscudo(), 75 + anao.getPoderFisico() + guerreiro.getPoderFisico(), 80 + anao.getPoderHabilidade() + guerreiro.getPoderHabilidade(), anao, guerreiro);
			personagemRepositorio.salvarPersonagem(thorin);
			
			Personagem legolas = new Personagem("Legolas", 1000 + elfo.getVida() + arqueiro.getVida(), 300  + elfo.getEscudo() + arqueiro.getEscudo(), 85 + elfo.getPoderFisico() + arqueiro.getPoderFisico(), 60 + elfo.getPoderHabilidade() + arqueiro.getPoderHabilidade(), elfo, arqueiro);
			personagemRepositorio.salvarPersonagem(legolas);
			
			Personagem gandalf = new Personagem("Gandalf", 1000 + humano.getVida() + mago.getVida(), 200 + humano.getEscudo() + mago.getEscudo(), 100 + humano.getPoderFisico() + mago.getPoderFisico(), 40 + humano.getPoderHabilidade() + mago.getPoderHabilidade(), humano, mago);
			personagemRepositorio.salvarPersonagem(gandalf);

			Personagem ezio = new Personagem("Ezio", 1000 + humano.getVida() + guerreiro.getVida(), 250 + humano.getEscudo() + guerreiro.getEscudo(), 90 + humano.getPoderFisico() + guerreiro.getPoderFisico(), 70 + humano.getPoderHabilidade() + guerreiro.getPoderHabilidade(), humano, guerreiro);
			personagemRepositorio.salvarPersonagem(ezio);
			
			Personagem conan = new Personagem("Conan", 1000 + anao.getVida() + arqueiro.getVida(), 400 + anao.getEscudo() + arqueiro.getEscudo(), 50 + anao.getPoderFisico() + arqueiro.getPoderFisico(), 95 + anao.getPoderHabilidade() + arqueiro.getPoderHabilidade(), anao, arqueiro);
			personagemRepositorio.salvarPersonagem(conan);
			
			Personagem malfurion = new Personagem("Malfurion", 1000 + elfo.getVida() + mago.getVida(), 350 + elfo.getEscudo() + mago.getEscudo(), 80 + elfo.getPoderFisico() + mago.getPoderFisico(), 50 + elfo.getPoderHabilidade() + mago.getPoderHabilidade(), elfo, mago);
			personagemRepositorio.salvarPersonagem(malfurion);
			
			Personagem uther = new Personagem("Uther", 1000 + orc.getVida() + berserker.getVida(), 600 + orc.getEscudo() + berserker.getEscudo(), 70 + orc.getPoderFisico() + berserker.getPoderFisico(), 75 + orc.getPoderHabilidade() + berserker.getPoderHabilidade(), orc, berserker);
			personagemRepositorio.salvarPersonagem(uther);
			
			Personagem kelThuzad = new Personagem("Kel'Thuzad", 1000 + orc.getVida() + xama.getVida(), 150 + orc.getEscudo() + xama.getEscudo(), 95 + orc.getPoderFisico() + xama.getPoderFisico(), 45 + orc.getPoderHabilidade() + xama.getPoderHabilidade(), orc, xama);
			personagemRepositorio.salvarPersonagem(kelThuzad);
			
			Personagem chenstormstout = new Personagem("Chen Stormstout", 1000 + dragao.getVida() + monge.getVida(), 450 + dragao.getEscudo() + monge.getEscudo(), 65 + dragao.getPoderFisico() + monge.getPoderFisico(), 85 + dragao.getPoderHabilidade() + monge.getPoderHabilidade(), dragao, monge);
			personagemRepositorio.salvarPersonagem(chenstormstout);
			
			Personagem jaina = new Personagem("Jaina", 1000 + dragao.getVida() + xama.getVida(), 250 + dragao.getEscudo() + xama.getEscudo(), 95 + dragao.getPoderFisico() + xama.getPoderFisico(), 50 + dragao.getPoderHabilidade() + xama.getPoderHabilidade(), dragao, xama);
			personagemRepositorio.salvarPersonagem(jaina);
			
			*/

			//While para sempre mostrar o MENU
			while (true) {
				//Selecionar rotina que deseja
				System.out.println("===== MENU =====");
				System.out.println("Escolha uma opção \n 1 - Começar uma batalha \n 2 - Consultar dados \n 3 - Sair");
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
						System.out.print("Insira um ID para deletar uma batalha: ")
						int deletar = entrada.nextInt();
						
						if (deletar > 0) {
							System.out.println("Deseja mesmo deletar a batalha? \n S - sim \n N - Não");
							int simNao = entrada.next();
							
							if(simNao == 2) {
								System.out.println("Cancelamento do registro a ser deletado.");
								return deletar;

							} else {
								System.out.println(RepositorioBatalha.deletarBatalha(deletar));
								System.out.println("Batalha deletada, o ID deletado é " + deletar);
								
							}
						}
					}
					return deletar;

				} else if(escolha == 4) {
					System.out.println("Crie seu próprio jogador \n 1 - sim \n 2 - não \n 3 - Sair");
					int criar = entrada.nextInt();

					if (criar == )

				} else {
					System.out.println("Obrigado por jogar!");
					break;

				}
				
			}
		} 
		
	}

}