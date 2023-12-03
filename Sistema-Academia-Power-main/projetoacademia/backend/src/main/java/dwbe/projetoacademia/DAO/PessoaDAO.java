package dwbe.projetoacademia.DAO;

//Criar a nova instânciada entidade Pessoa e salvar no banco de dados.
public Pessoa criar(String nome, String rg, String cpf, Date dataNascimento) {
        Pessoa pessoa = new Pessoa(nome, rg, cpf, dataNascimento);

        // Salva a pessoa no banco de dados
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();

        return pessoa;
        }

//Ler deve consultar a entidade Pessoa no banco de dados pelo código.

public Pessoa ler(Long codigo) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Consulta a pessoa no banco de dados
        Pessoa pessoa = entityManager.find(Pessoa.class, codigo);

        // Fecha o EntityManager
        entityManager.close();

        return pessoa;
        }

//atualizar a entidade Pessoa no banco de dados.
public void atualizar(Pessoa pessoa) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Atualiza a pessoa no banco de dados
        entityManager.getTransaction().begin();
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
        }

//
public void excluir(Pessoa pessoa) {
        // Obtém o EntityManager
        EntityManager entityManager = Persistence.createEntityManagerFactory("academia").createEntityManager();

        // Exclui a pessoa do banco de dados
        entityManager.getTransaction().begin();
        entityManager.remove(pessoa);
        entityManager.getTransaction().commit();

        // Fecha o EntityManager
        entityManager.close();
        }
