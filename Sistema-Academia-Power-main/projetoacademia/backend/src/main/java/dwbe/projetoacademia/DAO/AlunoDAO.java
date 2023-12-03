package dwbe.projetoacademia.DAO;

public interface AlunoDAO {

    Aluno criar(String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone, String atestadoMedico, Integer status);

    Aluno ler(Long codigo);

    void atualizar(Aluno aluno);

    void excluir(Aluno aluno);

}

@Service
public class AlunoDAOImpl implements AlunoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Aluno criar(String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone, String atestadoMedico, Integer status) {
        Aluno aluno = new Aluno(nome, rg, cpf, dataNascimento, cep, endereco, telefone, atestadoMedico, status);

        // Salva o aluno no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();

        return aluno;
    }

    @Override
    public Aluno ler(Long codigo) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Consulta o aluno no banco de dados
        Aluno aluno = entityManager.find(Aluno.class, codigo);

        // Fecha o EntityManager
        entityManager.close();

        return aluno;
    }

    @Override
    public void atualizar(Aluno aluno) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Atualiza o aluno no banco de dados
        entityManager.getTransaction().begin();
        entityManager.merge(aluno);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }

    @Override
    public void excluir(Aluno aluno) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Exclui o aluno do banco de dados
        entityManager.getTransaction().begin();
        entityManager.remove(aluno);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }

}