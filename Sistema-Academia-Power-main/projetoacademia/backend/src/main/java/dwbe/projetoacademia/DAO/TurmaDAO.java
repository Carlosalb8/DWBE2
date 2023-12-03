package dwbe.projetoacademia.DAO;

public interface TurmaDAO {

    Turma criar(String descricao, String servicoAssociado, Integer duracaoMinutagem);

    Turma ler(Long codigo);

    void atualizar(Turma turma);

    void excluir(Turma turma);
}

@Service
public class TurmaDAOImpl implements TurmaDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Turma criar(String descricao, String servicoAssociado, Integer duracaoMinutagem) {
        Turma turma = new Turma(descricao, servicoAssociado, duracaoMinutagem);

        // Salva a turma no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(turma);
        entityManager.getTransaction().commit();

        return turma;
    }

    @Override
    public Turma ler(Long codigo) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Consulta a turma no banco de dados
        Turma turma = entityManager.find(Turma.class, codigo);

        // Fecha o EntityManager
        entityManager.close();

        return turma;
    }

    @Override
    public void atualizar(Turma turma) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Atualiza a turma no banco de dados
        entityManager.getTransaction().begin();
        entityManager.merge(turma);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }

    @Override
    public void excluir(Turma turma) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Exclui a turma do banco de dados
        entityManager.getTransaction().begin();
        entityManager.remove(turma);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }
}
