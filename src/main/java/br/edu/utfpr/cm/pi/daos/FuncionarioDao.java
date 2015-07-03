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

            manager = PersistenceManager.getEntityManager();
            Query query = manager
                    .createQuery("SELECT f FROM funcionario as f WHERE f.login = :login AND f.senha = :senha");
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            funcionario = (Funcionario) query.getSingleResult();
        } catch (Exception ex) {

            ex.getMessage();
        } finally {

            manager.close();
        }

        return funcionario;
    }

}