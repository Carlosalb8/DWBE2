package dwbe.projetoacademia.view;

import dwbe.projetoacademia.model.Aluno;
import dwbe.projetoacademia.model.Professor;
import dwbe.projetoacademia.model.Turma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
@ComponentScan
public class Main {
    // Listas para armazenar alunos, professores e turmas cadastrados
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); {
            SpringApplication.run(Main.class, args);
        }

        Scanner scanner = new Scanner(System.in);

        Turma turma1 = new Turma(1, "Turma de Yoga", "Yoga", 60);
        Turma turma2 = new Turma(2, "Turma de Pilates", "Pilates", 40);
        Turma turma3 = new Turma(3, "Turma de Zumba", "Zumba", 60);
        Turma turma4 = new Turma(4, "Turma de Musculação", "Musculação", 90);
        Turma turma5 = new Turma(5, "Turma de Ginástica", "Ginástica", 60);
        Turma turma6 = new Turma(6, "Turma de Funcional", "Funcional", 40);
        Turma turma7 = new Turma(7, "Turma de Personalizado", "Personalizado", 60);
        Turma turma8 = new Turma(8, "Turma de Alongamento", "Alongamento", 30);
        Turma turma9 = new Turma(9, "Turma de Dança - Adultos", "Dança Adulto", 60);
        Turma turma10 = new Turma(10, "Turma de Dança - Idosos", "Dança Idoso", 30);
        Turma turma11 = new Turma(11, "Turma de Artes Marciais", "Artes Marciais", 90);
        Turma turma12 = new Turma(12, "Turma de Hidroginástica - Adultos", "Hidroginástica - Adultos", 60);
        Turma turma13 = new Turma(13, "Turma de Hidroginástica - Idosos", "Hidroginástica - Idosos", 30);
        Turma turma14 = new Turma(14, "Turma de Spinning", "Spinning", 40);

        turmas.add(turma1);
        turmas.add(turma2);
        turmas.add(turma3);
        turmas.add(turma4);
        turmas.add(turma5);
        turmas.add(turma6);
        turmas.add(turma7);
        turmas.add(turma8);
        turmas.add(turma9);
        turmas.add(turma10);
        turmas.add(turma11);
        turmas.add(turma12);
        turmas.add(turma13);
        turmas.add(turma14);

        while (true) {
            System.out.println("------------------------------------- SISTEMA DA ACADEMIA ----------------------------------");
            System.out.println("1. Cadastrar Aluno(a) na academia (Alunos cadastrados na academia podem usar os aparelhos)" );
            System.out.println("2. Cadastrar Professor(a)");
            System.out.println("3. Cadastrar uma nova turma");
            System.out.println("4. Excluir aluno(a)");
            System.out.println("5. Excluir Professor(a)");
            System.out.println("6. Excluir turma");
            System.out.println("7. Lista de Alunos");
            System.out.println("8. Lista de Professores");
            System.out.println("9. Lista de Turmas");
            System.out.println("10. Matricular Aluno em turma (Alunos devem estar cadastrados na academia para fazer parte de uma turma) ");
            System.out.println("11. Listar alunos de uma turma");
            System.out.println("12. Cancelar matricula do aluno(a)");
            System.out.println("13. Marcar aluno como inadimplente");
            System.out.println("14. Marcar mensalidade ativa");
            System.out.println("15. Sair");
            System.out.println();

            System.out.print("Selecione uma opção:");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1: // Cadastrar aluno
                    cadastrarAluno();
                    break;
                case 2: // Cadastrar professor
                    cadastrarProfessor();
                    break;
                case 3: // Cadastrar turma
                    cadastrarTurma();
                    break;
                case 4: // Excluir aluno
                    System.out.print("Informe o código do aluno a ser excluído: ");
                    int codigoAlunoParaExcluir = scanner.nextInt();
                    excluirAlunoSeNaoInadimplente(codigoAlunoParaExcluir);
                    break;
                case 5: // Excluir professor
                    System.out.print("Informe o código do professor a ser excluído: ");
                    int codigoProfessorParaExcluir = scanner.nextInt();
                    excluirProfessor(codigoProfessorParaExcluir); // Adicione esta chamada
                    break;
                case 6: // Excluir turma
                    System.out.print("Informe o código da turma a ser excluída: ");
                    int codigoTurmaParaExcluir = scanner.nextInt();
                    excluirTurma(codigoTurmaParaExcluir); // Adicione esta chamada
                    break;
                case 7: // Lista de alunos
                    listarAlunos();
                    break;
                case 8: // Listar de Professores
                    listarProfessores();
                    break;
                case 9: // Lista de turmas
                    listarTurmas();
                    break;
                case 10: // Matricular aluno em uma turma
                    matricularAlunoNaTurma();
                    break;
                case 11: // Listar alunos de uma turma
                    listarAlunosDeTurma();
                    break;
                case 12: // Cancelar aluno
                    cancelarAluno();
                    break;
                case 13: // Marcar aluno como inadimplente
                    marcarAlunoComoInadimplente();
                    break;
                case 14: // Pagar mensalidade e marcar aluno como ativo
                    pagarMensalidadeEAtivarAluno();
                    break;
                case 15: //Sair do sistema
                    System.out.println("Saindo do sistema da academia de ginástica.");
                    scanner.close();
                    System.exit(0);
                    break;
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
        Aluno aluno = new Aluno(codigo, nome, rg, cpf, dataNascimento, cep, endereco, telefone, atestadoMedico,  0);

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

    private static void excluirAlunoSeNaoInadimplente(int codigoAluno) {
        // Encontre o aluno pelo código
        Aluno alunoParaExcluir = null;
        for (Aluno aluno : alunos) {
            if (aluno.getCodigo() == codigoAluno) {
                alunoParaExcluir = aluno;
                break;
            }
        }

        if (alunoParaExcluir == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (alunoParaExcluir.getStatus() != 2) { // Verifica se o aluno não está inadimplente (status 2)
            alunos.remove(alunoParaExcluir); // Remove o aluno se não estiver inadimplente
            System.out.println("Aluno excluído com sucesso.");
        } else {
            System.out.println("Não é possível excluir um aluno inadimplente.");
        }
    }

    private static void listarAlunos() {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("Código: " + aluno.getCodigo() + ", Nome: " + aluno.getNome() + ", Status: " + aluno.getStatus());
        }
    }

    private static void excluirProfessor(int codigoProfessor) {
        // Encontre o professor pelo código
        Professor professorParaExcluir = null;
        for (Professor professor : professores) {
            if (professor.getCodigo() == codigoProfessor) {
                professorParaExcluir = professor;
                break;
            }
        }

        if (professorParaExcluir == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        professores.remove(professorParaExcluir);
        System.out.println("Professor excluído com sucesso.");
    }

    private static void excluirTurma(int codigoTurma) {
        // Encontre a turma pelo código
        Turma turmaParaExcluir = null;
        for (Turma turma : turmas) {
            if (turma.getCodigo() == codigoTurma) {
                turmaParaExcluir = turma;
                break;
            }
        }

        if (turmaParaExcluir == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        turmas.remove(turmaParaExcluir);
        System.out.println("Turma excluída com sucesso.");
    }

    private static void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            System.out.println("Lista de Professores:");
            for (Professor professor : professores) {
                System.out.println("Código: " + professor.getCodigo());
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Modalidade: " + professor.getModalidade());
                System.out.println("Carga Horária: " + professor.getCargaHoraria());
                System.out.println("------------------------------------");
            }
        }
    }

    private static void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            System.out.println("Lista de Turmas:");
            for (Turma turma : turmas) {
                System.out.println("Código: " + turma.getCodigo());
                System.out.println("Descrição: " + turma.getDescricao());
                System.out.println("Serviço Associado: " + turma.getServicoAssociado());
                System.out.println("Duração (minutos): " + turma.getDuracaoMinutagem());
                System.out.println("------------------------------------");
            }
        }
    }

    private static void matricularAlunoNaTurma() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do aluno que deseja inscrever: ");
        int codigoAlunoParaInscricao = scanner.nextInt();

        Aluno alunoParaInscricao = encontrarAlunoPorCodigo(codigoAlunoParaInscricao);

        if (alunoParaInscricao != null) {
            if (alunoParaInscricao.getStatus() == 0) { // Verifica se o status do aluno é ativo
                listarTurmas();

                System.out.print("Informe o código da turma em que deseja inscrever o aluno: ");
                int codigoTurmaEscolhida = scanner.nextInt();

                Turma turmaEscolhida = encontrarTurmaPorCodigo(codigoTurmaEscolhida);

                if (turmaEscolhida != null) {
                    turmaEscolhida.adicionarAluno(alunoParaInscricao);
                    System.out.println("Aluno inscrito na turma com sucesso.");
                } else {
                    System.out.println("Turma não encontrada. Inscrição não realizada.");
                }
            } else {
                System.out.println("O aluno não pode ser inscrito na turma porque o status não é ativo.");
            }
        } else {
            System.out.println("Aluno não encontrado. Inscrição não realizada.");
        }
    }


    private static Aluno encontrarAlunoPorCodigo(int codigo) {
        for (Aluno aluno : alunos) {
            if (aluno.getCodigo() == codigo) {
                return aluno;
            }
        }
        return null; // Retorna null se o aluno não for encontrado
    }

    private static Turma encontrarTurmaPorCodigo(int codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo() == codigo) {
                return turma;
            }
        }
        return null; // Retorna null se a turma não for encontrada
    }

    private static void listarAlunosDeTurma() {
        listarTurmas();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código da turma para listar os alunos: ");
        int codigoTurmaParaListarAlunos = scanner.nextInt();

        Turma turmaParaListarAlunos = encontrarTurmaPorCodigo(codigoTurmaParaListarAlunos);

        if (turmaParaListarAlunos != null) {
            List<Aluno> alunosDaTurma = turmaParaListarAlunos.getAlunos();

            if (!alunosDaTurma.isEmpty()) {
                System.out.println("Alunos na turma " + turmaParaListarAlunos.getDescricao() + ":");
                for (Aluno aluno : alunosDaTurma) {
                    System.out.println("Código: " + aluno.getCodigo() + ", Nome: " + aluno.getNome());
                }
            } else {
                System.out.println("Nenhum aluno está inscrito nesta turma.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void cancelarAluno() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do aluno a ser cancelado: ");
        int codigoAlunoParaCancelar = scanner.nextInt();

        Aluno alunoParaCancelar = encontrarAlunoPorCodigo(codigoAlunoParaCancelar);

        if (alunoParaCancelar != null) {
            // Atualize o status do aluno para "cancelado" (status 1)
            alunoParaCancelar.setStatus(1);

            // Remova o aluno das turmas em que estiver inscrito9

            for (Turma turma : turmas) {
                if (turma.getAlunos().contains(alunoParaCancelar)) {
                    turma.removerAluno(alunoParaCancelar);
                }
            }

            System.out.println("Aluno cancelado com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void marcarAlunoComoInadimplente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do aluno a ser marcado como inadimplente: ");
        int codigoAlunoParaMarcarComoInadimplente = scanner.nextInt();

        Aluno alunoParaMarcarComoInadimplente = encontrarAlunoPorCodigo(codigoAlunoParaMarcarComoInadimplente);

        if (alunoParaMarcarComoInadimplente != null) {
            // Atualize o status do aluno para "inadimplente" (status 2)
            alunoParaMarcarComoInadimplente.setStatus(2);

            System.out.println("Aluno marcado como inadimplente com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void pagarMensalidadeEAtivarAluno() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o código do aluno que deseja marcar como ativo ao pagar a mensalidade: ");
        int codigoAlunoParaAtivar = scanner.nextInt();

        Aluno alunoParaAtivar = encontrarAlunoPorCodigo(codigoAlunoParaAtivar);

        if (alunoParaAtivar != null) {
            // Verifique se o status do aluno é inadimplente (status 2)
            if (alunoParaAtivar.getStatus() == 2) {
                // Atualize o status do aluno para ativo (status 0)
                alunoParaAtivar.setStatus(0);
                System.out.println("Mensalidade paga e aluno marcado como ativo com sucesso.");
            } else {
                System.out.println("O aluno já está com o status ativo ou cancelado.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
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