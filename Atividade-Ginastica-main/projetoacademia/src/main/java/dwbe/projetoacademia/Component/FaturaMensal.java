package dwbe.projetoacademia.Component;

import dwbe.projetoacademia.model.Aluno;

import java.util.Date;

import org.springframework.stereotype.Component; // Importe a anotação do componente

//Classe da Fatura Mensal
@Component
public class FaturaMensal {
    private int numeroFatura;
    private Aluno aluno;
    private Date dataVencimento;
    private double valor;

    public FaturaMensal(int numeroFatura, Aluno aluno, Date dataVencimento, double valor) {
        this.numeroFatura = numeroFatura;
        this.aluno = aluno;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public int getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(int numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "component.FaturaMensal{" +
                "numeroFatura=" + numeroFatura +
                ", aluno=" + aluno +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                '}';
    }
}