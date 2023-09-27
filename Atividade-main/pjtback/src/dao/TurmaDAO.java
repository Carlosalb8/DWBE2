package dao;

import model.Turma;

public interface TurmaDAO {

    public Turma findById(int codigo);

    public void save(Turma turma);

    public void update(Turma turma);

    public void delete(int codigo);

}
