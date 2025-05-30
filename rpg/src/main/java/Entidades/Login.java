package Entidades;

public class Login {

    protected int id;
    public String nome;
    private String login;
    private String senha;
    protected String email;
    protected String telefone;

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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return "\nLogin [ " +
                "\n Id: " + this.getId() +
                "\n Nome: " + this.getNome() +
                "\n Login: " + this.getLogin() +
                "\n Senha: " + this.getSenha() +
                "\n Email: " + this.getEmail() +
                "\n Telefone: " + this.getTelefone();
    }

}