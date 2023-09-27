package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Professor;

public class ProfessorDAOImpl implements ProfessorDAO {

    private Connection connection;

    public ProfessorDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Professor findById(int codigo) {
        Professor professor = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM professores WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                professor = new Professor(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getDate("data_nascimento"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("modalidade"),
                        rs.getInt("carga_horaria"),
                        List.of(rs.getString("periodos").split(","))
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professor;
    }

    @Override
    public void save(Professor professor) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO professores (pessoa, modalidade, carga_horaria, periodos) VALUES (?, ?, ?, ?)");
            ps.setObject(1, professor);
            ps.setString(2, professor.getModalidade());
            ps.setInt(3, professor.getCargaHoraria());
            ps.setString(4, String.join(",", professor.getPeriodos()));

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Professor professor) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE professores SET pessoa = ?, modalidade = ?, carga_horaria = ?, periodos = ? WHERE codigo = ?");
            ps.setObject(1, professor);
            ps.setString(2, professor.getModalidade());
            ps.setInt(3, professor.getCargaHoraria());
            ps.setString(4, String.join(",", professor.getPeriodos()));
            ps.setInt(5, professor.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM professores WHERE codigo = ?");
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}