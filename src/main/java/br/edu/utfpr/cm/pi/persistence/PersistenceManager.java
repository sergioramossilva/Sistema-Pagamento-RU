package br.edu.utfpr.cm.pi.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe utilitária para gerenciamento do JPA, tem como objetivos:
 * <ul>
 * <li>Inicializar uma única instância da EntityManagerFactory;</li>
 * <li>Criar a EntityManager;</li>
 * <li>Associar a EntityManager na ThreadLocal;</li>
 * </ul>
 *
 */
public class PersistenceManager {

    private static EntityManagerFactory entityManagerFactory;
    private static ThreadLocal<EntityManager> threadLocal;

    // Bloco estático para que EntityManagerFactory inicie apenas uma vez.
    static {

        threadLocal = new ThreadLocal<>();
        try {

            start();
            System.out.println("Persistência iniciado com sucesso!");
        } catch (Exception ex) {

            System.err.println("Falha ao iniciar a persistência!" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Inicializa a peristência.
     */
    private static void start() {

        entityManagerFactory = Persistence
                .createEntityManagerFactory("SistemaPagamentoRU");
    }

    /**
     * Cria a {@code EntityManager} e associa à ThreadLocal.
     */
    private static void createEntityManager() {

        threadLocal.set(entityManagerFactory.createEntityManager());
    }

    /**
     * Obtém a {@code EntityManager} associada à ThreadLocal.
     * 
     * @return {@link EntityManager}
     */
    public static EntityManager getEntityManager() {
        createEntityManager();
        EntityManager em = threadLocal.get();
        return em;
    }
}