package br.edu.utfpr.cm.pi.daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.utfpr.cm.pi.beans.AbstractEntity;
import br.edu.utfpr.cm.pi.persistence.PersistenceManager;

public class JpaDao<T extends AbstractEntity, I extends Serializable> implements Dao<T, I> {

    protected EntityManager em;
    protected Class<T> entityClass;

    public JpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T objeto) {

        try {

            em = PersistenceManager.getEntityManager();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();
            System.err.println("Ocorreu um erro ao salvar o objeto. \n"
                    + e.fillInStackTrace());
        } finally {

            em.close();
        }
    }

    public void delete(T objeto) {

        try {

            em = PersistenceManager.getEntityManager();
            em.getTransaction().begin();
            objeto=em.merge(objeto);
            em.remove(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {

            em.getTransaction().rollback();
            System.err.println("Ocorreu um erro ao excluir o objeto. \n"
                    + e.fillInStackTrace());
        } finally {

            em.close();
        }
    }

    @Override
    public T findById(I id) {

        T objeto = null;

        try {

            em = PersistenceManager.getEntityManager();
            objeto = em.find(entityClass, id);
        } catch (Exception e) {

            System.err.println("Ocorreu um erro ao localizar o objeto. \n"
                    + e.fillInStackTrace());
        } finally {

            em.close();
        }

        return objeto;
    }

    @Override
    public List<T> getAll() {

        List<T> results = null;

        try {

            em = PersistenceManager.getEntityManager();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            query.select(root);
            TypedQuery<T> typedQuery = em.createQuery(query);
            results = typedQuery.getResultList();
        } catch (Exception e) {

            System.err.println("Ocorreu um erro para retornar os objetos. \n"
                    + e.fillInStackTrace());
        } finally {
            em.close();
        }

        return results;

    }

}