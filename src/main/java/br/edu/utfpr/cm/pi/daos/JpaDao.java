package br.edu.utfpr.cm.pi.daos;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.utfpr.cm.pi.persistence.PersistenceManager;

public class JpaDao<T, I> {

    private Class<T> entityClass;
    protected EntityManager manager;

    public JpaDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

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

    public List<?> getAll() {

        List<?> lista = null;

        try {

            manager = PersistenceManager.getEntityManager();
            Query query = manager.createQuery("FROM "
                    + entityClass.getSimpleName());
            lista = query.getResultList();
        } catch (Exception ex) {

            ex.getMessage();
        } finally {

            manager.close();
        }

        return lista;
    }
}