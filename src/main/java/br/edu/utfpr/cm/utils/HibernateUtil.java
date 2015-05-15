package br.edu.utfpr.cm.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Classe utilitária para gerenciamento do Hibernate, tem como objetivos:
 * <ul>
 * <li>Inicializar uma única instância da SessionFactory do Hibernate;</li>
 * <li>Abrir Sessions do Hibernate;</li>
 * <li>Associar Sessions a ThreadsLocais;</li>
 * <li>Fechar Sessions associadas.</li>
 * </ul>
 *
 * @author Sérgio Ramos da Silva
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;
    private static Configuration config;
    private static final ThreadLocal sessionThread;
    private static Session session;

    static {

        sessionThread = new ThreadLocal();
        try {
            iniciarHibernate();
            System.out.println("Hibernate iniciado com sucesso!");
        } catch (HibernateException ex) {
            System.err.println("Falha ao iniciar Hibernate!" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Inicia o hibernate
     */
    private final static void iniciarHibernate() {

        if (sessionFactory == null || sessionFactory.isClosed()) {
            sessionFactory = configurarHibernate().buildSessionFactory(gerenciarServicos());
        }

    }

    /**
     * Retorna uma configuração do Hibernate.
     *
     * @return sessionFactory
     */
    private final static Configuration configurarHibernate() {

        if (config == null) {
            config = new Configuration();
            config.configure();
        } else {
            System.err.println("Ocorreu um erro ao configurar o Hibernate!");
        }
        return config;
    }

    /**
     * Retorna um registro de serviços.
     *
     * @return sessionFactory
     */
    private final static ServiceRegistry gerenciarServicos() {

        if (serviceRegistry == null) {
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configurarHibernate().getProperties()).build();
        }
        return serviceRegistry;

    }

    /**
     * Retorna uma fábrica de sessões.
     *
     * @return sessionFactory
     */
    protected final static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Retorna uma Session existente, ou então abre uma nova e associa a
     * ThreadLocal.
     *
     * @return session
     */
    protected static Session openSession() {

        session = (Session) sessionThread.get();

        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
            sessionThread.set(session);
        }
        return session;
    }

    /**
     * Limpa a Session corrente.
     */
    protected static void clearSession() {
        Session s = HibernateUtil.openSession();
        s.clear();
    }

    /**
     * Fecha a Session associada a ThreadLocal.
     */
    protected static void closeSession() {
        Session s = (Session) sessionThread.get();
        sessionThread.set(null);
        if (s != null && s.isOpen()) {
            s.close();
        }
    }

}
