package br.edu.utfpr.cm.pi.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe utilit�ria para gerenciamento do JPA, tem como objetivos:
 * <ul>
 * <li>Inicializar uma �nica inst�ncia da EntityManagerFactory;</li>
 * <li>Criar a EntityManager;</li>
 * <li>Associar a EntityManager na ThreadLocal;</li>
 * </ul>
 *
 */
public class PersistenceManager {

    private static EntityManagerFactory entityManagerFactory;
    private static ThreadLocal<EntityManager> threadLocal;

    // Bloco est�tico para que EntityManagerFactory inicie apenas uma vez.
    static {

        threadLocal = new ThreadLocal<>();
        try {

            start();
            System.out.println("Persist�ncia iniciado com sucesso!");
        } catch (Exception ex) {

            System.err.println("Falha ao iniciar a persist�ncia!");
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Inicializa a perist�ncia.
     */
    private static void start() {

        entityManagerFactory = Persistence
                .createEntityManagerFactory("SistemaPagamentoRU");
    }

    /**
     * Cria a {@code EntityManager} e associa � ThreadLocal.
     */
    private static void createEntityManager() {

        threadLocal.set(entityManagerFactory.createEntityManager());
    }

    /**
     * Obt�m a {@code EntityManager} associada � ThreadLocal.
     * 
     * @return {@link EntityManager}
     */
    public static EntityManager getEntityManager() {
        createEntityManager();
        EntityManager em = threadLocal.get();
        return em;
    }
}