SEpackage dwbe.projetoacademia.DAO;

//criar uma nova instância da entidade Servico e salvar no banco de dados.
public Servico criar(String descricao, Double valor) {
        Servico servico = new Servico(descricao, valor);

        // Salva o serviço no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(servico);
        entityManager.getTransaction().commit();

        return servico;
        }

//Consultar a entidade Servico no banco de dados pelo código.
public Servico ler(Long codigo) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Consulta o serviço no banco de dados
        Servico servico = entityManager.find(Servico.class, codigo);

        // Fecha o EntityManager
        entityManager.close();

        return servico;
        }

//Atualizar a entidade Servico no banco de dados.

public void atualizar(Servico servico) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Atualiza o serviço no banco de dados
        entityManager.getTransaction().begin();
        entityManager.merge(servico);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
        }

//excluir a entidade Servico do banco de dados.

public void excluir(Servico servico) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Exclui o serviço do banco de dados
        entityManager.getTransaction().begin();
        entityManager.remove(servico);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
        }