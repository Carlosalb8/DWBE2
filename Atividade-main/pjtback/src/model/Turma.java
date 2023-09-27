package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Professor;
import model.Turma;

public class TurmaDAOImpl implements TurmaDAO {

    private Connection connection;

    public TurmaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Turma findById(int codigo) {
        Turma turma = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM turmas WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                turma = new Turma(
                        rs.getInt("codigo"),
                        rs.getString("descricao"),
                        rs.getString("servico_associado"),
                        rs.getInt("duracao_minutagem"),
                        List.of(AlunoDAOImpl.parse(rs.getString("alunos"))),
                        ProfessorDAOImpl.parse(rs.getString("professor"))
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turma;
    }

    @Override
    public void save(Turma turma) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO turmas (descricao, servico_associado, duracao_minutagem, alunos, professor) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, turma.getDescricao());
            ps.setString(2, turma.getServicoAssociado());
            ps.setInt(3, turma.getDuracaoMinutagem());
            ps.setString(4, TurmaDAOImpl.toJson(turma.getAlunos()));
            ps.setString(5, TurmaDAOImpl.toJson(turma.getProfessor()));

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Turma turma) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE turmas SET descricao = ?, servico_associado = ?, duracao_minutagem = ?, alunos = ?, professor = ? WHERE codigo = ?");
            ps.setString(1, turma.getDescricao());
            ps.setString(2, turma.getServicoAssociado());
            ps.setInt(3, turma.getDuracaoMinutagem());
            ps.setString(4, TurmaDAOImpl.toJson(turma.getAlunos()));
            ps.setString(5, TurmaDAOImpl.toJson(turma.getProfessor()));
            ps.setInt(6, turma.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM turmas WHERE codigo = ?");
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String toJson(List<Aluno> alunos) {
        return alunos.stream().map(Aluno::toJson).collect(Collectors.joining(", "));