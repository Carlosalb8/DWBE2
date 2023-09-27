package dao;

import model.Mensalidade;

public interface MensalidadeDAO {

    public Mensalidade findById(int codigo);

    public void save(Mensalidade mensalidade);

    public void update(Mensalidade mensalidade);

    public void delete(int codigo);

}