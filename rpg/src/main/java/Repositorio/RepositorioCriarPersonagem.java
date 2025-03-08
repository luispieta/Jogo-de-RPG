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
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setString(1, criarPersonagem.getNome());
                stmt.setInt(2, criarPersonagem.getPersonagem().getId());
                stmt.setInt(3, criarPersonagem.getRaca().getId());
                stmt.setInt(4, criarPersonagem.getRaca().getId());
                stmt.setInt(5, criarPersonagem.getArquetipo().getId());

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