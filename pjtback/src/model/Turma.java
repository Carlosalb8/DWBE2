package dwbe.projetoacademia.model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codigo;
    private String descricao;
    private String servicoAssociado;
    private int duracaoMinutagem;
    private List<Aluno> alunos;
    private Professor professor;

    public Turma(int codigo, String descricao, String servicoAssociado, int duracaoMinutagem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.servicoAssociado = servicoAssociado;
        this.duracaoMinutagem = duracaoMinutagem;
        this.alunos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getServicoAssociado() {
        return servicoAssociado;
    }

    public void setServicoAssociado(String servicoAssociado) {
        this.servicoAssociado = servicoAssociado;
    }

    public int getDuracaoMinutagem() {
        return duracaoMinutagem;
    }

    public void setDuracaoMinutagem(int duracaoMinutagem) {
        this.duracaoMinutagem = duracaoMinutagem;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "model.Turma{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", servicoAssociado='" + servicoAssociado + '\'' +
                ", duracaoMinutagem=" + duracaoMinutagem +
                ", alunos=" + alunos +
                ", professor=" + professor +
                '}';
    }
}
