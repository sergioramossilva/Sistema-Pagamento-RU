package br.edu.utfpr.cm.pi.daos;

import org.hibernate.Query;

import br.edu.utfpr.cm.pi.beans.UsuarioSistema;
import br.edu.utfpr.cm.pi.persistence.PersistenceManager;
import br.edu.utfpr.cm.saa.entidades.Usuario;

public class UsuarioDao extends JpaDao<UsuarioSistema, Long> {

    public UsuarioDao() {
        super(UsuarioSistema.class);
    }

    public UsuarioSistema retornaUsuarioDoSistemaAPartirDeUsuarioDoLdap(
            Usuario ul) {
        try {
            manager = PersistenceManager.getEntityManager();
            Query query = manager.createQuery(
                    "select u from UsuarioSistema u where login = :login",
                    UsuarioSistema.class);
            query.setParameter("login", ul.getLogin());

            return (UsuarioSistema) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
        return null;
    }

}