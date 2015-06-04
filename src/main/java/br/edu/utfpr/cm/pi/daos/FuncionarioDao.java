package br.edu.utfpr.cm.pi.daos;

import javax.persistence.Query;

import br.edu.utfpr.cm.pi.beans.Funcionario;
import br.edu.utfpr.cm.pi.persistence.PersistenceManager;

public class FuncionarioDao extends JpaDao<Funcionario, Long> {

    public FuncionarioDao() {
        super(Funcionario.class);
    }

    public Funcionario getLogin(String login, String senha) {

        Funcionario funcionario = null;

        try {

            em = PersistenceManager.getEntityManager();
            Query query = em
                    .createQuery("SELECT f FROM funcionario as f WHERE f.login = :login AND f.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            funcionario = (Funcionario) query.getSingleResult();
        } catch (Exception e) {

            System.err.println("Ocorreu um erro ao localizar o objeto. \n"
                    + e.fillInStackTrace());
        } finally {
            em.close();
        }
        return funcionario;
    }
}