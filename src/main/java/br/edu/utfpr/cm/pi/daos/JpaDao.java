package br.edu.utfpr.cm.pi.daos;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.edu.utfpr.cm.pi.beans.AbstractEntity;
import br.edu.utfpr.cm.pi.persistence.PersistenceManager;

public class JpaDao<T extends AbstractEntity, I extends Serializable>
        implements Dao<T, I> {

    protected EntityManager manager;
    protected Class<T> entityClass;

    public JpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T objeto) {

        try {

            Field chave = objeto.getClass().getDeclaredField("id");
            chave.setAccessible(true);

            Object valorChave = chave.get(objeto);

            if (valorChave == null) {

                try {

                    manager = PersistenceManager.getEntityManager();
                    manager.getTransaction().begin();
                    manager.persist(objeto);
                    manager.getTransaction().commit();
                } catch (Exception ex) {

                    manager.getTransaction().rollback();
                    ex.getMessage();
                } finally {
                    manager.close();
                }
            } else {
                try {

                    manager = PersistenceManager.getEntityManager();
                    manager.getTransaction().begin();
                    manager.merge(objeto);
                    manager.getTransaction().commit();
                } catch (Exception ex) {

                    manager.getTransaction().rollback();
                    ex.getMessage();
                } finally {
                    manager.close();
                }
            }

        } catch (Exception ex) {

            ex.getMessage();

        }
    }

    @Override
    public void delete(T objeto) {

        try {

            manager = PersistenceManager.getEntityManager();
            manager.getTransaction().begin();
            objeto = manager.merge(objeto);
            manager.remove(objeto);
            manager.getTransaction().commit();
        } catch (Exception ex) {

            manager.getTransaction().rollback();
            ex.getMessage();

        } finally {

            manager.close();
        }
    }

    @Override
    public T findById(I id) {

        T objeto = null;

        try {

            manager = PersistenceManager.getEntityManager();
            objeto = manager.find(entityClass, id);
        } catch (Exception ex) {

            ex.getMessage();
        } finally {

            manager.close();
        }

        return objeto;
    }

    public List<T> getAll() {

        List<T> results = null;

        try {

            manager = PersistenceManager.getEntityManager();
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);
            query.select(root);
            TypedQuery<T> typedQuery = manager.createQuery(query);
            results = typedQuery.getResultList();
        } catch (Exception ex) {

            ex.getMessage();
        } finally {
            manager.close();
        }

        return results;

    }
}