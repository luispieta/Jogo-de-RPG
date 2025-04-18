package Entidades;

import Repositorio.RepositorioCriarPersonagem;
import Repositorio.RepositorioPersonagem;
import java.util.Scanner;

public class IniciarBatalha {
    Scanner entrada = new Scanner(System.in);
    RepositorioPersonagem personagemRepositorio = new RepositorioPersonagem();
    RepositorioCriarPersonagem criarPersonagemRepositorio = new RepositorioCriarPersonagem();

    private RepositorioPersonagem repositorioPersonagem;
    private RepositorioCriarPersonagem repositorioCriarPersonagem;

    public IniciarBatalha(RepositorioPersonagem rp, RepositorioCriarPersonagem rcp){
        this.repositorioPersonagem = rp;
        this.repositorioCriarPersonagem = rcp;
    }

    public Lutador escolherPersonagem() {

        while (true) {
            System.out.println("1 - Personagem do sistema");
            System.out.println("2 - Personagem criado pelo usuário");
            System.out.println("3 - Sair");
            System.out.println("Escolha uma opção:");
            int tipo = entrada.nextInt();

            if (tipo == 3) {
                return null;

            } else if (tipo == 2) {
                System.out.println("=== PERSONAGENS CRIADOS ===");
                System.out.println(criarPersonagemRepositorio.buscarTodosPersonagensCriados());
                System.out.println("Escolha um personagem para batalhar (digite o ID):");
                int escolha = entrada.nextInt();

                return criarPersonagemRepositorio.buscarCriarPersonagemPorId(escolha);

            } else if (tipo == 1) {
                System.out.println("=== PERSONAGENS DO SISTEMA ===");
                System.out.println(personagemRepositorio.buscarTodosPersonagens());
                System.out.println("Escolha um personagem para batalhar (digite o ID):");
                int escolha = entrada.nextInt();

                return personagemRepositorio.buscarPersonagemPorId(escolha);

            } else {
                System.out.println("Número inválido. Tente novamente!");

            }

        }

    }

}
