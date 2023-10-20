package dwbe.projetoacademia.view;

import dwbe.projetoacademia.model.Aluno;
import dwbe.projetoacademia.model.Professor;
import dwbe.projetoacademia.model.Turma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import model.*; - verificar o model

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Listas para armazenar alunos, professores e turmas cadastrados

    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Turma");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarTurma();
                    break;
                case 4:
                    System.out.println("Saindo do sistema da academia de ginástica.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inserida está inválida. Tente novamente, por favor.");
            }
        }
    }

    private static void cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);

        // Coleta informações do aluno
        System.out.println("Cadastrar Aluno:");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do teclado
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("RG: ");
        String rg = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = parseDate(dataNascimentoStr);
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Atestado Médico: ");
        String atestadoMedico = scanner.nextLine();

        // Criar instância de Aluno
        Aluno aluno = new Aluno(codigo, nome, rg, cpf, dataNascimento, cep, endereco, telefone, atestadoMedico);

        // Adicionar o aluno à lista de alunos
        alunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);

        // Coleta informações do professor
        System.out.println("Cadastrar Professor:");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do teclado
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("RG: ");
        String rg = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = parseDate(dataNascimentoStr);
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Modalidade: ");
        String modalidade = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();

        // Criar instância de Professor
        Professor professor = new Professor(codigo, nome, rg, cpf, dataNascimento, cep, endereco, telefone, modalidade, cargaHoraria, new ArrayList<>());

        // Adicionar o professor à lista de professores
        professores.add(professor);

        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarTurma() {
        Scanner scanner = new Scanner(System.in);

        // Coleta informações da turma
        System.out.println("Cadastrar Turma:");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer do teclado
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Serviço Associado: ");
        String servicoAssociado = scanner.nextLine();
        System.out.print("Duração (minutos): ");
        int duracaoMinutagem = scanner.nextInt();

        // Criar instância de Turma
        Turma turma = new Turma(codigo, descricao, servicoAssociado, duracaoMinutagem);

        // Adicionar a turma à lista de turmas
        turmas.add(turma);

        System.out.println("Turma cadastrada com sucesso!");
    }

    private static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}