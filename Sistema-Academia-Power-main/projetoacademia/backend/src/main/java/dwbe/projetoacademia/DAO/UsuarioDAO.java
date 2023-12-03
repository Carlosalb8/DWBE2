package dwbe.projetoacademia.DAO;

import dwbe.projetoacademia.model.Aluno;
import dwbe.projetoacademia.model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Pessoa usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.execute();
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.execute();
    }

    public Pessoa buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Pessoa(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("email"),
                    resultSet.getString("senha")
            );
        } else {
            return null;
        }
    }

    public void gravar(Pessoa usuario) throws SQLException {
        Pessoa Pessoa = null;
        if (usuario.getId()) {
            inserir(Pessoa);
        } else {
            atualizar(Pessoa);
        }
    }

    private void atualizar(Pessoa usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.execute();
    }
    public void inserir(Pessoa usuario) throws SQLException;
    public void remover(int id) throws SQLException;
    public Pessoa buscarPorId(int id) throws SQLException;
    public void gravar(Pessoa usuario) throws SQLException;
}