package dwbe.projetoacademia.Service;

import dwbe.projetoacademia.model.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Importação da anotação do service

@Service // Adicione a anotação do service
public class CadastroAlunoService {
    // Lista para armazenar os alunos cadastrados
    private List<Aluno> alunos = new ArrayList<>();

    // Método para cadastrar um novo aluno
    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno cadastrado no sistema com sucesso!");
    }

    // Método para remover um aluno existente
    public void removeAluno(Aluno aluno) {
        alunos.remove(aluno);
        System.out.println("Aluno existente no sistema foi removido com sucesso!");
    }

    // Método para listar todos os alunos cadastrados
    public List<Aluno> listarAlunos() {

        return alunos;
    }

    // Método para buscar um aluno por código
    public Aluno buscarAlunoPorCodigo(int codigo) {
        for (Aluno aluno : alunos) {
            if (aluno.getCodigo() == codigo) {
                return aluno;
            }
        }
        return null; // Retorna "null" se o aluno não for encontrado
    }

    // Método para remover um aluno
    public void removerAluno(int codigo) {
        Aluno aluno = buscarAlunoPorCodigo(codigo);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado :(");
        }
    }

    @Autowired
    private CadastroAlunoService cadastroAlunoService;

    public void gravar(Aluno aluno) throws SQLException {
        cadastroAlunoService.cadastrarAluno(aluno);
    }

    public class ListarCadastroAlunoService {

        @Autowired
        private CadastroAlunoService cadastroAlunoService;

        public List<Aluno> listar() {
            return cadastroAlunoService.listarAlunos();
        }
    }
}