package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Mensalidade;

public class MensalidadeDAOImpl implements MensalidadeDAO {

    private Connection connection;

    public MensalidadeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Mensalidade findById(int codigo) {
        Mensalidade mensalidade = null;

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM mensalidades WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mensalidade = new Mensalidade(
                        rs.getInt("codigo"),
                        rs.getObject("aluno", Aluno.class),
                        rs.getDate("data_matricula"),
                        rs.getDouble("valor_mensalidade"),
                        rs.getDate("data_pagamento"),
                        rs.getDouble("valor_pagamento")
                );
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mensalidade;
    }

    @Override
    public void save(Mensalidade mensalidade) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO mensalidades (aluno, data_matricula, valor_mensalidade, data_pagamento, valor_pagamento) VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, mensalidade.getAluno());
            ps.setDate(2, mensalidade.getDataMatricula());
            ps.setDouble(3, mensalidade.getValorMensalidade());
            ps.setDate(4, mensalidade.getDataPagamento());
            ps.setDouble(5, mensalidade.getValorPagamento());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Mensalidade mensalidade) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE mensalidades SET aluno = ?, data_matricula = ?, valor_mensalidade = ?, data_pagamento = ?, valor_pagamento = ? WHERE codigo = ?");
            ps.setObject(1, mensalidade.getAluno());
            ps.setDate(2, mensalidade.getDataMatricula());
            ps.setDouble(3, mensalidade.getValorMensalidade());
            ps.setDate(4, mensalidade.getDataPagamento());
            ps.setDouble(5, mensalidade.getValorPagamento());
            ps.setInt(6, mensalidade.getCodigo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM mensalidades WHERE codigo = ?");
            ps.setInt(1, codigo);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}