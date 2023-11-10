package dwbe.projetoacademia.model;

import java.util.Date;
import java.util.List;

public class Professor extends Pessoa {
    private String modalidade;
    private int cargaHoraria;
    private List<String> periodos;

    public Professor(int codigo, String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone,
                     String modalidade, int cargaHoraria, List<String> periodos) {
        super(codigo, nome, rg, cpf, dataNascimento, cep, endereco, telefone);
        this.modalidade = modalidade;
        this.cargaHoraria = cargaHoraria;
        this.periodos = periodos;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<String> getPeriodos() {
        return periodos;
    }

    public void adicionarPeriodo(String periodo) {
        this.periodos.add(periodo);
    }

    public void removerPeriodo(String periodo) {
        this.periodos.remove(periodo);
    }

    @Override
    public String toString() {
        return "model.Professor{" +
                "modalidade='" + modalidade + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", periodos=" + periodos +
                "} " + super.toString();
    }
}