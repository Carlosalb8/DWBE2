package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDAOImpl implements PessoaDAO {

    private Connection connection;

    public PessoaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Pessoa findById(int codigo) {
        Pessoa pessoa = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pessoas WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pessoa;
    }

    @Override
    public void save(Pessoa pessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pessoas (nome, rg, cpf, data_nascimento, cep, endereco, telefone) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getRg());
            ps.setString(3, pessoa.getCpf());
            ps.setDate(4, pessoa.getDataNascimento());
            ps.setString(5, pessoa.getCep());
            ps.setString(6, pessoa.getEndereco());
            ps.setString(7, pessoa.getTelefone());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE pessoas SET nome = ?, rg = ?, cpf = ?, data_nascimento = ?, cep = ?, endereco = ?, telefone = ? WHERE codigo = ?");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getRg());
            ps.setString(3, pessoa.getCpf());
            ps.setDate(4, pessoa.getDataNascimento());
            ps.setString(5, pessoa.getCep());
            ps.setString(6, pessoa.getEndereco());
            ps.setString(7, pessoa.getTelefone());
            ps.setInt(8, pessoa.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pessoas WHERE codigo = ?");
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}