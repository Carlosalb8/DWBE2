package dao;

import model.Professor;

public interface ProfessorDAO {

    public Professor findById(int codigo);

    public void save(Professor professor);

    public void update(Professor professor);

    public void delete(int codigo);

}
