package dwbe.projetoacademia.model;

import java.util.Date;

public class Aluno extends Pessoa {
    private String atestadoMedico;

    //status do aluno: 0 - ativo:
    //status do aluno: 1 - cancelado:
    //status do aluno: 2 - inadimplente:
    private int status;

    public Aluno(int codigo, String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone, String atestadoMedico, int status) {
        super(codigo, nome, rg, cpf, dataNascimento, cep, endereco, telefone);
        this.atestadoMedico = atestadoMedico;
        this.status=status;
    }

    public String getAtestadoMedico() {
        return atestadoMedico;
    }

    public void setAtestadoMedico(String atestadoMedico) {
        this.atestadoMedico = atestadoMedico;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
