package Repositorio;

import Entidades.Personagem;
import Entidades.Raca;
import Entidades.Arquetipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BancoDeDados.DatabaseConnection;

// Classe responsável por acessar e manipular os dados da entidade Raca no banco de dados
public class RepositorioPersonagem {
	
    // Método para salvar uma instância de Raca no banco de dados
    public void salvarPersonagem(Personagem personagem) {
        // Comando SQL para inserir uma nova raça com os valores especificados
        String sql = "INSERT INTO personagens (nome, vida, escudo, poder_fisico, poder_habilidade, raca_id, arquetipo_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Tenta conectar ao banco de dados e preparar a execução do comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             // Prepara a instrução SQL e especifica que as chaves geradas serão retornadas
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            // Define os valores dos parâmetros na instrução SQL
            stmt.setString(1, personagem.getNome());
            stmt.setInt(2, personagem.getVida());
            stmt.setInt(3, personagem.getEscudo());
            stmt.setInt(4, personagem.getPoderFisico());
            stmt.setInt(5, personagem.getPoderHabilidade());
            stmt.setInt(6, personagem.getRaca().getId());
            stmt.setInt(7, personagem.getArquetipo().getId());
            // Executa a inserção no banco de dados
            stmt.executeUpdate();

            // Obtém as chaves geradas pelo banco (neste caso, o ID da raça inserida)
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                // Atribui o ID gerado à instância de Raca
            	personagem.setId(generatedKeys.getInt(1));
            }

            // Mensagem de confirmação de que a raça foi salva com sucesso
            System.out.println("Personagem " + personagem.getNome() + " salva com ID " + personagem.getId());

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }
    }

    // Método para buscar todas as raças no banco de dados
    public List<Personagem> buscarTodosPersonagens() {
        // Lista para armazenar as raças encontradas
        List<Personagem> personagem = new ArrayList<>();
        // Comando SQL para selecionar todas as raças
        String sql = "SELECT * FROM personagens";

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Itera sobre os resultados e cria objetos Raca para cada linha
            while (rs.next()) {
            	Personagem personagens = new Personagem();
            	personagens.setId(rs.getInt("id_personagem"));
            	personagens.setNome(rs.getString("nome"));
            	personagens.setVida(rs.getInt("vida"));
            	personagens.setEscudo(rs.getInt("escudo"));
            	personagens.setPoderFisico(rs.getInt("poder_fisico"));
            	personagens.setPoderHabilidade(rs.getInt("poder_habilidade"));
            	
            	Raca raca = new Raca();
            	raca.setId(rs.getInt("raca_id"));
            	personagens.setRaca(raca);
            	
            	Arquetipo arquetipo = new Arquetipo();
            	arquetipo.setId(rs.getInt("arquetipo_id"));
            	personagens.setArquetipo(arquetipo);

            	personagem.add(personagens);

            }

        } catch (SQLException e) {
            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
            e.printStackTrace();
        }

        // Retorna a lista de raças encontradas
        return personagem;
    }

    // Método para buscar uma raça específica pelo ID
    public Personagem buscarPersonagemPorId(int id) {
        // Comando SQL para selecionar a raça pelo ID
        String sql = "SELECT * FROM personagens WHERE id_personagem = ?";
        Personagem personagem = null;

        // Tenta conectar ao banco de dados e executar o comando SQL
        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            // Define o valor do parâmetro na instrução SQL
            stmt.setInt(1, id);
            // Executa a consulta e obtém os resultados
            try (ResultSet rs = stmt.executeQuery()) {
                // Verifica se a raça foi encontrada
                if (rs.next()) {
                	int racaId = rs.getInt("raca_id");
                	int arquetipoId = rs.getInt("arquetipo_id");
                	
                	personagem = new Personagem();
                	personagem.setId(rs.getInt("id_personagem"));
                	personagem.setNome(rs.getString("nome"));
                	personagem.setVida(rs.getInt("vida"));
                	personagem.setEscudo(rs.getInt("escudo"));
                	personagem.setPoderFisico(rs.getInt("poder_fisico"));
                	personagem.setPoderHabilidade(rs.getInt("poder_habilidade"));
                	
                	RepositorioRaca repositorioRaca = new RepositorioRaca();
                	Raca raca = repositorioRaca.buscarRacaPorId(racaId);
                	personagem.setRaca(raca);
                	
                	RepositorioArquetipo repositorioArquetipo = new RepositorioArquetipo();
                	Arquetipo arquetipo = repositorioArquetipo.buscarArquetipoPorId(arquetipoId);
                	personagem.setArquetipo(arquetipo);
                	
                }
            }

	        } catch (SQLException e) {
	            // Em caso de erro, imprime o stack trace para facilitar a identificação do problema
	            e.printStackTrace();
	        }
	        return personagem;

        // Retorna a raça encontrada ou null se não existir
    }
}
