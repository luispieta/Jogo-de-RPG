package Repositorio;

import Entidades.Arquetipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import BancoDeDados.DatabaseConnection;

// Classe responsável por acessar e manipular os dados da entidade Raca no banco de dados
public class RepositorioArquetipo {

    // Método para salvar uma instância de Raca no banco de dados
    public void salvarArquetipo(Arquetipo arquetipo) {
        // Comando SQL para inserir uma nova raça com os valores especificados
        String sql = "INSERT INTO arquetipos (nome, vida, escudo, poder_fisico, poder_habilidade) VALUES (?, ?, ?, ?, ?)";

        // Tenta conectar ao banco de dados e preparar a execução do comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             // Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, arquetipo.getNome());
            stmt.setInt(2, arquetipo.getVida());
            stmt.setInt(3, arquetipo.getEscudo());
            stmt.setInt(4, arquetipo.getPoderFisico());
            stmt.setInt(5, arquetipo.getPoderHabilidade());
            // Executa a inserção no banco de dados
            stmt.executeUpdate();

            // Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Atribui o ID gerado à instância de Raca
            	arquetipo.setId(generatedKeys.getInt(1));
            }

            // Mensagem de confirmação de que a raça foi salva com sucesso
            System.out.println("Arquetipo " + arquetipo.getNome() + " salva com ID " + arquetipo.getId());

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }
    }

    // Método para buscar todas as raças no banco de dados
    public List<Arquetipo> buscarTodasArquetipos() {
        // Lista para armazenar as raças encontradas
        List<Arquetipo> arquetipo = new ArrayList<>();
        // Comando SQL para selecionar todas as raças
        String sql = "SELECT * FROM arquetipos";

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre os resultados e cria objetos Raca para cada linha
            while (rs.next()) {
            	Arquetipo arquetipos = new Arquetipo();
            	arquetipos.setId(rs.getInt("id_arquetipo"));
            	arquetipos.setNome(rs.getString("nome"));
            	arquetipos.setVida(rs.getInt("vida"));
            	arquetipos.setEscudo(rs.getInt("escudo"));
            	arquetipos.setPoderFisico(rs.getInt("poder_fisico"));
            	arquetipos.setPoderHabilidade(rs.getInt("poder_habilidade"));
                // Adiciona a raça à lista
            	arquetipo.add(arquetipos);
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a lista de raças encontradas
        return arquetipo;
    }

    // Método para buscar uma raça específica pelo ID
    public Arquetipo buscarArquetipoPorId(int id) {
        // Comando SQL para selecionar a raça pelo ID
        String sql = "SELECT * FROM arquetipos WHERE id_arquetipo = ?";
        Arquetipo arquetipo = null;

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define o valor do parâmetro na instrução SQL
            stmt.setInt(1, id);
            // Executa a consulta e obtém os resultados
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se a raça foi encontrada
                if (rs.next()) {
                	arquetipo = new Arquetipo();
                	arquetipo.setId(rs.getInt("id_arquetipo"));
                	arquetipo.setNome(rs.getString("nome"));
                	arquetipo.setVida(rs.getInt("vida"));
                	arquetipo.setEscudo(rs.getInt("escudo"));
                	arquetipo.setPoderFisico(rs.getInt("poder_fisico"));
                	arquetipo.setPoderHabilidade(rs.getInt("poder_habilidade"));
                }
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a raça encontrada ou null se não existir
        return arquetipo;
    }
}