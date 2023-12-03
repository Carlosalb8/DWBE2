@Configuration
@EnableAutoConfiguration
@ComponentScan

//
public class Application extends AbstractApplicationContext implements DataSourceInitializer {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;database=projetoacademia");
        dataSource.setUsername("DESKTOP-JRKJLDL\Estudante");
        dataSource.setPassword("wallacesantos");
        return dataSource;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            try {
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetoacademia");
                EntityManager entityManager = factory.createEntityManager();
                entityManager.getTransaction().begin();

                // Crie as tabelas no banco de dados

                entityManager.createQuery("CREATE TABLE Aluno (codigo INT NOT NULL PRIMARY KEY, nome VARCHAR(255), rg VARCHAR(255), cpf VARCHAR(255), dataNascimento DATE, cep VARCHAR(255), endereco VARCHAR(255), telefone VARCHAR(255), atestadoMedico VARCHAR(255), status INT)").executeUpdate();
                entityManager.createQuery("CREATE TABLE Status (codigo INT NOT NULL PRIMARY KEY, numero int(200), status INT)").executeUpdate();
                entityManager.createQuery("CREATE TABLE Professor (codigo INT NOT NULL PRIMARY KEY, nome VARCHAR(255), rg VARCHAR(255), cpf VARCHAR(255), dataNascimento DATE, cep VARCHAR(255), endereco VARCHAR(255), telefone VARCHAR(255), modalidade VARCHAR(255), cargaHoraria INT)").executeUpdate();
                entityManager.createQuery("CREATE TABLE Turma (codigo INT NOT NULL PRIMARY KEY, descricao VARCHAR(255), servicoAssociado VARCHAR(255), duracaoMinutagem INT)").executeUpdate();
                entityManager.createQuery("CREATE TABLE Mensalidade (codigo INT NOT NULL PRIMARY KEY, valor DECIMAL(10,2), servicoAssociado VARCHAR(255), duracaoMinutagem INT)").executeUpdate();

                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                entityManager.close();
                factory.close();
            }
        }
    }
}