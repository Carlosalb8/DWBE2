package dwbe.projetoacademia;


import dwbe.projetoacademia.model.Aluno;
import dwbe.projetoacademia.model.Mensalidade;
import dwbe.projetoacademia.model.Professor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProjetoacademiaApplicationTests {

	public static void main(String[] args) {


		Aluno aluno1 = new Aluno(1, "João", "123456", "7845632",null, "5555", "Rua Marechal", "4444", "sim", 0 );
		Mensalidade mensalidade1 = new Mensalidade(2, aluno1, null, 120.0, null, 120.0);
		List<String> periodos = new ArrayList<>();
		periodos.add("Manhâ");
		periodos.add("Tarde");
		periodos.add("Noite");
		Professor professor1 = new Professor(3, "Maria", "745963", "8888888", null, "4444", " Rua Halfeld", "11111", "Natação", 120, periodos);
		System.out.println(aluno1.getNome());
		System.out.println(mensalidade1.getValorMensalidade());
		System.out.println(professor1.getNome());

	}
}
