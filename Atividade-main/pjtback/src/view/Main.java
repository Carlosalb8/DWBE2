import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import dao.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        // Substitua-os por suas credenciais reais de banco de dados
        String dbURL = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "your_username";
        String dbPassword = "your_password";

        try {
            // Criar uma conexão de banco de dados
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // Criar instâncias DAO para diferentes entidades
            AlunoDAO alunoDAO = new AlunoDAOImpl(connection);
            ProfessorDAO professorDAO = new ProfessorDAOImpl(connection);
            ServicoDAO servicoDAO = new ServicoDAOImpl(connection);
            TurmaDAO turmaDAO = new TurmaDAOImpl(connection);

            //Executar operações usando os DAOs
            //Exemplo: Buscar um Aluno por ID
            Aluno aluno = alunoDAO.findById(1);
            System.out.println("Fetched Aluno: " + aluno);

            // Exemplo: Buscar um professor por ID
            Professor professor = professorDAO.findById(1);
            System.out.println("Fetched Professor: " + professor);

            // Exemplo: Buscar um serviço por ID
            Servico servico = servicoDAO.findById(1);
            System.out.println("Fetched Servico: " + servico);

            // Exemplo: Buscar uma Turma por ID
            Turma turma = turmaDAO.findById(1);
            System.out.println("Fetched Turma: " + turma);

            // Você pode executar outras operações CRUD usando os DAOs conforme necessário

            // Feche a conexão com o banco de dados quando terminar
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}