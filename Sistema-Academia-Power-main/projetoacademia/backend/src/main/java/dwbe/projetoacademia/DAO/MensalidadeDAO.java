package dwbe.projetoacademia.DAO;

public interface MensalidadeDAO {

    Mensalidade criar(Long codigo, LocalDate dataVencimento, LocalDate dataPagamento, Double valor, Boolean paga);

    Mensalidade ler(Long codigo);

    void atualizar(Mensalidade mensalidade);

    void excluir(Mensalidade mensalidade);
}

@Service
public class MensalidadeDAOImpl implements MensalidadeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Mensalidade criar(Long codigo, LocalDate dataVencimento, LocalDate dataPagamento, Double valor, Boolean paga) {
        Mensalidade mensalidade = new Mensalidade(codigo, dataVencimento, dataPagamento, valor, paga);

        // Salva a mensalidade no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(mensalidade);
        entityManager.getTransaction().commit();

        return mensalidade;
    }

    @Override
    public Mensalidade ler(Long codigo) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Consulta a mensalidade no banco de dados
        Mensalidade mensalidade = entityManager.find(Mensalidade.class, codigo);

        // Fecha o EntityManager
        entityManager.close();

        return mensalidade;
    }

    @Override
    public void atualizar(Mensalidade mensalidade) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Atualiza a mensalidade no banco de dados
        entityManager.getTransaction().begin();
        entityManager.merge(mensalidade);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }

    @Override
    public void excluir(Mensalidade mensalidade) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Exclui a mensalidade do banco de dados
        entityManager.getTransaction().begin();
        entityManager.remove(mensalidade);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }
}
