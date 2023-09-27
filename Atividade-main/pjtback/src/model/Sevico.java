package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Servico;

public class ServicoDAOImpl implements ServicoDAO {

    private Connection connection;

    public ServicoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Servico findById(int codigo) {
        Servico servico = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM servicos WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                servico = new Servico(
                        rs.getInt("codigo"),
                        rs.getString("tipo"),
                        rs.getDouble("valor"),
                        rs.getInt("duracao"),
                        rs.getInt("quantidade_de_alunos"),
                        rs.getString("plano")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servico;
    }

    @Override
    public void save(Servico servico) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO servicos (tipo, valor, duracao, quantidade_de_alunos, plano) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, servico.getTipo());
            ps.setDouble(2, servico.getValor());
            ps.setInt(3, servico.getDuracao());
            ps.setInt(4, servico.getQuantidadeDeAlunos());
            ps.setString(5, servico.getPlano());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Servico servico) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE servicos SET tipo = ?, valor = ?, duracao = ?, quantidade_de_alunos = ?, plano = ? WHERE codigo = ?");
            ps.setString(1, servico.getTipo());
            ps.setDouble(2, servico.getValor());
            ps.setInt(3, servico.getDuracao());
            ps.setInt(4, servico.getQuantidadeDeAlunos());
            ps.setString(5, servico.getPlano());
            ps.setInt(6, servico.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM servicos WHERE codigo = ?");
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}