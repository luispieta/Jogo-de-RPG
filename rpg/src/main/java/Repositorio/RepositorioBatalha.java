package Repositorio;

import Entidades.Batalha;
import Entidades.Personagem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import BancoDeDados.DatabaseConnection;

public class RepositorioBatalha {

    public void salvarBatalha(Batalha batalha) {
        String sql = "INSERT INTO batalhas (lutador1_id, lutador2_id, vencedor_id) VALUES (?, ?, ?)";

        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, batalha.getLutador1().getId());
            stmt.setInt(2, batalha.getLutador2().getId());

            if (batalha.getVencedor() != null) {
                stmt.setInt(3, batalha.getVencedor().getId());

            } else {
                stmt.setNull(3, Types.INTEGER);
            }

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
            	batalha.setId(generatedKeys.getInt(1));
            }

            System.out.println("Lutador 1" + batalha.getLutador1() + "Lutador 2 " + batalha.getLutador2() + " salva com ID " + batalha.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Batalha> buscarTodasBatalhas() {
        List<Batalha> batalhas = new ArrayList<>();
        String sql = "SELECT * FROM batalhas";

        try (Connection conexao = DatabaseConnection.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                int lutador1_id = rs.getInt("lutador1_id");
                int lutador2_id = rs.getInt("lutador2_id");
            	int vencedorId = rs.getInt("vencedor_id");
                
                Batalha batalha = new Batalha();
            	batalha.setId(rs.getInt("id_batalha"));
                
                RepositorioPersonagem repositorioLutador1 = new RepositorioPersonagem();
                Personagem lutador1 = repositorioLutador1.buscarPersonagemPorId(lutador1_id);
                batalha.setLutador1(lutador1);

                RepositorioPersonagem repositorioLutador2 = new RepositorioPersonagem();
                Personagem lutador2 = repositorioLutador2.buscarPersonagemPorId(lutador2_id);
                batalha.setLutador2(lutador2);

                if (!rs.wasNull()) {
                    RepositorioPersonagem repositorioVencedor = new RepositorioPersonagem();
                    Personagem vencedor = repositorioVencedor.buscarPersonagemPorId(vencedorId);
                    batalha.setVencedor(vencedor);

                } else {
                    batalha.setVencedor(null); // Por precauções
                }

            	batalhas.add(batalha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return batalhas;
    }

    public Batalha buscarBatalhaPorId(int id) {
        String sql = "SELECT * FROM batalhas WHERE id_batalha = ?";
    	Batalha batalha = null;

        try (Connection conexao = DatabaseConnection.conectar();
        	PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int lutador1_id = rs.getInt("lutador1_id");
                    int lutador2_id = rs.getInt("lutador2_id");
                    int vencedorId = rs.getInt("vencedor_id");

                	batalha = new Batalha();    
                	batalha.setId(rs.getInt("id_batalha"));

                    RepositorioPersonagem repositorioLutador1 = new RepositorioPersonagem();
                    Personagem lutador1 = repositorioLutador1.buscarPersonagemPorId(lutador1_id);
                    batalha.setLutador1(lutador1);

                    RepositorioPersonagem repositorioLutador2 = new RepositorioPersonagem();
                    Personagem lutador2 = repositorioLutador2.buscarPersonagemPorId(lutador2_id);
                    batalha.setLutador2(lutador2);

                    if (!rs.wasNull()) {
                        RepositorioPersonagem repositorioVencedor = new RepositorioPersonagem();
                        Personagem vencedor = repositorioVencedor.buscarPersonagemPorId(vencedorId);
                        batalha.setVencedor(vencedor);

                    } else {
                        batalha.setVencedor(null); // Por precauções
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return batalha;
    }

    public boolean deletarBatalha(int id) {

        String sql = "DELETE FROM batalhas WHERE id_batalha = ?";
        boolean deletar = false;

        try(Connection conexao = DatabaseConnection.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);) {

                stmt.setInt(1, id);
                int linhaAfetadas = stmt.executeUpdate();

                if (linhaAfetadas > 0 ){

                    deletar = true;
                    System.out.println("A batalha deletada foi como ID " + id + ". Deletado com sucesso!");
                
                } else {
                    System.out.println("A batalha selecionada não foi encontrada!");

                }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        
        return deletar;
        
    }

}