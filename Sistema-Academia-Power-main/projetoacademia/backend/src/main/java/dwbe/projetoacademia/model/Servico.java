package dwbe.projetoacademia.model;

class Servico {
    private int codigo;
    private String tipo;
    private double valor;
    private int duracao;
    private int quantidadeDeAlunos;
    private String plano;

    public Servico(int codigo, String tipo, double valor, int duracao, int quantidadeDeAlunos, String plano) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.valor = valor;
        this.duracao = duracao;
        this.quantidadeDeAlunos = quantidadeDeAlunos;
        this.plano = plano;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getQuantidadeDeAlunos() {
        return quantidadeDeAlunos;
    }

    public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigo=" + codigo +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", duracao=" + duracao +
                ", quantidadeDeAlunos=" + quantidadeDeAlunos +
                ", plano='" + plano + '\'' +
                '}';
    }
}
