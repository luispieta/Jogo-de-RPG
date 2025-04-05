package Entidades;
import Entidades.Arquetipo;
import Entidades.Personagem;
import Entidades.Raca;
import Repositorio.*;

import java.util.Scanner;

public class CriarPersonagem {
    RepositorioPersonagem personagemRepositorio = new RepositorioPersonagem();
    RepositorioArquetipo arquetipoRepositorio = new RepositorioArquetipo();
    RepositorioRaca racaRepositorio = new RepositorioRaca();
    RepositorioCriarPersonagem criarPersonagemRepositorio = new RepositorioCriarPersonagem();

    protected int id;
    public String nome;
    protected Personagem personagem;
    protected Raca raca;
    protected Arquetipo arquetipo;

    public CriarPersonagem() {

    }

    public CriarPersonagem(String nome, Personagem personagem, Raca raca, Arquetipo arquetipo) {
        this.nome = nome;
        this.personagem = personagem;
        this.raca = raca;
        this.arquetipo = arquetipo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Personagem getPersonagem() {
        return personagem;
    }
    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    public Arquetipo getArquetipo() {
        return arquetipo;
    }
    public void setArquetipo(Arquetipo arquetipo) {
        this.arquetipo = arquetipo;
    }
    public Raca getRaca() {
        return raca;
    }
    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public void personagensCriar(int criar){
        Scanner entrada = new Scanner(System.in);

        while (true) {
            if (criar == 2) {
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
            break;

        }

    }

}