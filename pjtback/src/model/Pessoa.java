package dwbe.projetoacademia.model;

import java.util.Date;

public class Pessoa {
    private int codigo;
    private String nome;
    private String rg;
    private String cpf;
    private Date dataNascimento;
    private String cep;
    private String endereco;
    private String telefone;

    // Construtor
    public Pessoa(int codigo, String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e Setters (métodos de acesso)
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método toString para representação em string da classe
    @Override
    public String toString() {
        return "model.Pessoa [codigo=" + codigo + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
                + ", cep=" + cep + ", endereco=" + endereco + ", telefone=" + telefone + "]";
    }
}
