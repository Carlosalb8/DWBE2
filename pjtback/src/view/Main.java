package view;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Aluno aluno1 = new Aluno(1, "João", "123456", "7845632",null, "5555", "Rua Marechal", "4444", "sim" );
        Mensalidade mensalidade1 = new Mensalidade(2, aluno1, null, 350.0, null, 350.0);
        List<String> periodos = new ArrayList<>();
        periodos.add("manhâ");
        periodos.add("tarde");
        Professor professor1 = new Professor(3, "Maria", "745963", "8888888", null, "4444", " Rua Halfeld", "11111", "Natação", 120, periodos);
        System.out.println(aluno1.getNome());
        System.out.println(mensalidade1.getValorMensalidade());
        System.out.println(professor1.getNome());

    }
}
