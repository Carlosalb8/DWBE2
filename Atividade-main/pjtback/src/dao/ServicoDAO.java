package dao;

import model.Servico;

public interface ServicoDAO {

    public Servico findById(int codigo);

    public void save(Servico servico);

    public void update(Servico servico);

    public void delete(int codigo);

}
