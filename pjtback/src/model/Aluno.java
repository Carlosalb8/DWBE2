package dwbe.projetoacademia.model;

import java.util.Date;

public class Aluno extends Pessoa {
    private String atestadoMedico;

    public Aluno(int codigo, String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone, String atestadoMedico) {
        super(codigo, nome, rg, cpf, dataNascimento, cep, endereco, telefone);
        this.atestadoMedico = atestadoMedico;
    }

    public String getAtestadoMedico() {
        return atestadoMedico;
    }

    public void setAtestadoMedico(String atestadoMedico) {
        this.atestadoMedico = atestadoMedico;
    }

}
