public class RepositorioCriarPersonagem {

    public void salvarPersonagemCriado(Personagem personagem) {

        String sql = "INSERT INTO (nome_personagem, escolha_personagem, escolha_raca, escolha_arquetipo) VALUES (?, ?, ?, ?)";

        try(Connection conexao = DatabaseConnection.PreparedStatement;
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setNome(1, personagem.getNome("nome_personagem"));
                stmt.set

            ResultSet generatedKeys = stmt.generatedKeys();
            if (generatedKeys.next()) {
                personagem.setId(generatedKeys.getInt(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}