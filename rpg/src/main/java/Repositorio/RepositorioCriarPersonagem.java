package Repositorio;

import Entidades.CriarPersonagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BancoDeDados.DatabaseConnection;

public class RepositorioCriarPersonagem {

    public void salvarPersonagemCriado(CriarPersonagem criarPersonagem) {

        String sql = "INSERT INTO criar_personagem (nome, escolha_personagem, escolha_raca, escolha_arquetipo) VALUES (?, ?, ?, ?)";

        try(Connection conexao = DatabaseConnection.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                stmt.setString(1, criarPersonagem.getNome());
                stmt.setInt(2, criarPersonagem.getPersonagem().getId());
                stmt.setInt(3, criarPersonagem.getRaca().getId());
                stmt.setInt(4, criarPersonagem.getArquetipo().getId());

                stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                criarPersonagem.setId(generatedKeys.getInt(1));

            }
            System.out.println("Criação do Personagem " + criarPersonagem.getNome() + " salva com ID " + criarPersonagem.getId());

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}