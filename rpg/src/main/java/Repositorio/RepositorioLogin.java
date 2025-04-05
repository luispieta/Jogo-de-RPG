package Repositorio;

import BancoDeDados.DatabaseConnection;
import Entidades.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioLogin {

    public void salvarLogin(Login login) {

        String sql = "INSERT INTO usuario (nome, login, senha, email, telefone) VALUES (?, ?, ?, ?, ?)";

        try(Connection conexao = DatabaseConnection.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, login.getNome());
            stmt.setString(2, login.getLogin());
            stmt.setString(3, login.getSenha());
            stmt.setString(4, login.getEmail());
            stmt.setString(5, login.getTelefone());

            stmt.executeUpdate();

            ResultSet generetedKeys = stmt.getGeneratedKeys();
            if(generetedKeys.next()) {
                login.setId(generetedKeys.getInt(1));

            }
            System.out.println("Login " + login.getNome() + " salva com ID " + login.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
