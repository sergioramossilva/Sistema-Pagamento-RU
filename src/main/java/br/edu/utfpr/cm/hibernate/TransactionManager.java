package br.edu.utfpr.cm.hibernate;


import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe utilitária para gerenciamento de transações do Hibernate, tem como objetivos:
 * <ul>
 * <li>Obter uma session;</li>
 * <li>Iniciar uma transação;</li>
 * <li>Fechar uma session;</li>
 * </ul>
 *
 * @author Sérgio Ramos da Silva
 */
public abstract class TransactionManager {

    private static Transaction transacao;
    private static Session sessao;

    /**
     * Obtém uma session
         *
         * @return session
     */
    public static Session getSession() {

        sessao = HibernateUtil.openSession();
        return sessao;
    }

    /**
     * Inicia uma transação
         *
         * @return transaction
     */
    public static Transaction beginTransaction(Session session) {

        transacao = sessao.beginTransaction();
        return transacao;
    }

    /**
     * Fecha uma session
         *
     */
    public static void closeSession() {

        HibernateUtil.closeSession();
    }

}