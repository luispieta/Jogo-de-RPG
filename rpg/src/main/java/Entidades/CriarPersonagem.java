package Entidades;
import Entidades.Arquetipo;
import Entidades.Personagem;
import Entidades.Raca;

public class CriarPersonagem {

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
}