package dao;

import model.Aluno;

public interface AlunoDAO {

    public Aluno findById(int codigo);

    public void save(Aluno aluno);

    public void update(Aluno aluno);

    public void delete(int codigo);

}