package dwbe.projetoacademia.model;

import java.util.Date;

public class Mensalidade {
    private int codigo;
    private Aluno aluno;
    private Date dataMatricula;
    private double valorMensalidade;
    private Date dataPagamento;
    private double valorPagamento;

    public Mensalidade(int codigo, Aluno aluno, Date dataMatricula, double valorMensalidade,
                       Date dataPagamento, double valorPagamento) {
        this.codigo = codigo;
        this.aluno = aluno;
        this.dataMatricula = dataMatricula;
        this.valorMensalidade = valorMensalidade;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    @Override
    public String toString() {
        return "model.Mensalidade{" +
                "codigo=" + codigo +
                ", aluno=" + aluno +
                ", dataMatricula=" + dataMatricula +
                ", valorMensalidade=" + valorMensalidade +
                ", dataPagamento=" + dataPagamento +
                ", valorPagamento=" + valorPagamento +
                '}';
    }
}
