package dwbe.projetoacademia.DAO;

public interface ProfessorDAO {

    Professor criar(String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone, String modalidade, Integer cargaHoraria);

    Professor ler(Long codigo);

    void atualizar(Professor professor);

    void excluir(Professor professor);

}

@Service
public class ProfessorDAOImpl implements ProfessorDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Professor criar(String nome, String rg, String cpf, Date dataNascimento, String cep, String endereco, String telefone, String modalidade, Integer cargaHoraria) {
        Professor professor = new Professor(nome, rg, cpf, dataNascimento, cep, endereco, telefone, modalidade, cargaHoraria);

        // Salva o professor no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(professor);
        entityManager.getTransaction().commit();

        return professor;
    }

    @Override
    public Professor ler(Long codigo) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Consulta o professor no banco de dados
        Professor professor = entityManager.find(Professor.class, codigo);

        // Fecha o EntityManager
        entityManager.close();

        return professor;
    }

    @Override
    public void atualizar(Professor professor) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Atualiza o professor no banco de dados
        entityManager.getTransaction().begin();
        entityManager.merge(professor);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }

    @Override
    public void excluir(Professor professor) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Exclui o professor do banco de dados
        entityManager.getTransaction().begin();
        entityManager.remove(professor);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
    }

}
