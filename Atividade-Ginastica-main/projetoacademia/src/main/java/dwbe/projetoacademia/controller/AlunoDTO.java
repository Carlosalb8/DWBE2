package dwbe.projetoacademia.controller;

import java.util.Date;

public class AlunoDTO {
    private int codigo;
    private String nome;
    private String rg;
    private String cpf;
    private String cep;
    private String endereco;
    private String telefone;
    private String atestadoMedico;

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getAtestadoMedico() {
        return atestadoMedico;
    }

    // Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAtestadoMedico(String atestadoMedico) {
        this.atestadoMedico = atestadoMedico;
    }
}
