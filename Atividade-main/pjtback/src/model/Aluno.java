package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Pessoa;

public class AlunoDAOImpl implements AlunoDAO {

    private Connection connection;

    public AlunoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Aluno findById(int codigo) {
        Aluno aluno = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM alunos WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                aluno = new Aluno(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("atestado_medico")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aluno;
    }

    @Override
    public void save(Aluno aluno) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO alunos (pessoa, atestado_medico) VALUES (?, ?)");
            ps.setObject(1, aluno);
            ps.setString(2, aluno.getAtestadoMedico());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Aluno aluno) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE alunos SET pessoa = ?, atestado_medico = ? WHERE codigo = ?");
            ps.setObject(1, aluno);
            ps.setString(2, aluno.getAtestadoMedico());
            ps.setInt(3, aluno.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM alunos WHERE codigo = ?");
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}