    package Repositorio;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import BancoDeDados.DatabaseConnection;
    import Entidades.*;
    import java.util.ArrayList;
    import java.util.List;

    public class RepositorioCriarPersonagem {

        RepositorioPersonagem repositorioPersonagem = new RepositorioPersonagem();
        RepositorioRaca repositorioRaca = new RepositorioRaca();
        RepositorioArquetipo repositorioArquetipo = new RepositorioArquetipo();
        Personagem personagem = new Personagem();
        Raca raca = new Raca();
        Arquetipo arquetipo = new Arquetipo();

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

        public List<CriarPersonagem> buscarTodosPersonagensCriados() {

            List<CriarPersonagem> criarPersonagem = new ArrayList<>();
            String sql = "SELECT * FROM criar_personagem";

            try (Connection conexao = DatabaseConnection.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

                while(rs.next()) {
                    CriarPersonagem criarPersonagens = new CriarPersonagem();
                    criarPersonagens.setId(rs.getInt("id_criar"));
                    criarPersonagens.setNome(rs.getString("nome"));

                    Personagem personagem = repositorioPersonagem.buscarPersonagemPorId(rs.getInt("escolha_personagem"));
                    criarPersonagens.setPersonagem(personagem);

                    Raca raca = repositorioRaca.buscarRacaPorId(rs.getInt("escolha_raca"));
                    criarPersonagens.setRaca(raca);

                    Arquetipo arquetipo = repositorioArquetipo.buscarArquetipoPorId(rs.getInt("escolha_arquetipo"));
                    criarPersonagens.setArquetipo(arquetipo);

                    criarPersonagens.aplicandoPersonagemEmCriarPersonagem();
                    criarPersonagem.add(criarPersonagens);

                }

            } catch (SQLException e) {
                e.printStackTrace();

            }

            return criarPersonagem;
        }

        public CriarPersonagem buscarCriarPersonagemPorId(int id){

            String sql = "SELECT * FROM criar_personagem WHERE id_criar = ?";
            CriarPersonagem criarPersonagem = null;

            try(Connection conexao = DatabaseConnection.conectar();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {

                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if(rs.next()) {

                        criarPersonagem = new CriarPersonagem();
                        criarPersonagem.setId(rs.getInt("id_criar"));
                        criarPersonagem.setNome(rs.getString("nome"));

                        Personagem personagem = repositorioPersonagem.buscarPersonagemPorId(rs.getInt("escolha_personagem"));
                        criarPersonagem.setPersonagem(personagem);

                        Raca raca = repositorioRaca.buscarRacaPorId(rs.getInt("escolha_raca"));
                        criarPersonagem.setRaca(raca);

                        Arquetipo arquetipo = repositorioArquetipo.buscarArquetipoPorId(rs.getInt("escolha_arquetipo"));
                        criarPersonagem.setArquetipo(arquetipo);

                        criarPersonagem.aplicandoPersonagemEmCriarPersonagem();

                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return criarPersonagem;

        }

    }