package Repositorio;

import Entidades.Raca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDeDados.DatabaseConnection;

// Classe responsável por acessar e manipular os dados da entidade Raca no banco de dados
public class RepositorioRaca {

    // Método para salvar uma instância de Raca no banco de dados
    public void salvarRaca(Raca raca) {
        // Comando SQL para inserir uma nova raça com os valores especificados
        String sql = "INSERT INTO racas (nome, vida, escudo, poder_fisico, poder_habilidade) VALUES (?, ?, ?, ?, ?)";

        // Tenta conectar ao banco de dados e preparar a execução do comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             // Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, raca.getNome());
            stmt.setInt(2, raca.getVida());
            stmt.setInt(3, raca.getEscudo());
            stmt.setInt(4, raca.getPoderFisico());
            stmt.setInt(5, raca.getPoderHabilidade());
            // Executa a inserção no banco de dados
            stmt.executeUpdate();

            // Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Atribui o ID gerado à instância de Raca
                raca.setId(generatedKeys.getInt(1));
            }

            // Mensagem de confirmação de que a raça foi salva com sucesso
            System.out.println("Raça " + raca.getNome() + " salva com ID " + raca.getId());

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }
    }

    // Método para buscar todas as raças no banco de dados
    public List<Raca> buscarTodasRacas() {
        // Lista para armazenar as raças encontradas
        List<Raca> raca = new ArrayList<>();
        // Comando SQL para selecionar todas as raças
        String sql = "SELECT * FROM racas";

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre os resultados e cria objetos Raca para cada linha
            while (rs.next()) {
                Raca racas = new Raca();
                racas.setId(rs.getInt("id_raca"));
                racas.setNome(rs.getString("nome"));
                racas.setVida(rs.getInt("vida"));
                racas.setEscudo(rs.getInt("escudo"));
                racas.setPoderFisico(rs.getInt("poder_fisico"));
                racas.setPoderHabilidade(rs.getInt("poder_habilidade"));
                // Adiciona a raça à lista
                raca.add(racas);
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a lista de raças encontradas
        return raca;
    }

    // Método para buscar uma raça específica pelo ID
    public Raca buscarRacaPorId(int id) {
        // Comando SQL para selecionar a raça pelo ID
        String sql = "SELECT * FROM racas WHERE id_raca = ?";
        Raca raca = null;

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define o valor do parâmetro na instrução SQL
            stmt.setInt(1, id);
            // Executa a consulta e obtém os resultados
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se a raça foi encontrada
                if (rs.next()) {
                    raca = new Raca();
                    raca.setId(rs.getInt("id_raca"));
                    raca.setNome(rs.getString("nome"));
                    raca.setVida(rs.getInt("vida"));
                    raca.setEscudo(rs.getInt("escudo"));
                    raca.setPoderFisico(rs.getInt("poder_fisico"));
                    raca.setPoderHabilidade(rs.getInt("poder_habilidade"));
                }
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a raça encontrada ou null se não existir
        return raca;
    }
}