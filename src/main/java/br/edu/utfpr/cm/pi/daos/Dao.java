package br.edu.utfpr.cm.pi.daos;

import java.io.Serializable;
import java.util.List;

import br.edu.utfpr.cm.pi.beans.AbstractEntity;

/**
 * Interface genérica destinada à persistência de objetos.
 * 
 * @param <T>
 *            - Parâmetro genérico que identifica o tipo do objeto.
 * @param <I>
 *            - Parâmetro genérico que identifica o tipo do identificador do
 *            objeto. Exemplos: {@code Long}, {@code Integer}, etc.
 */
public interface Dao<T extends AbstractEntity, I extends Serializable> {

    /**
     * Salva um objeto.
     *
     * @param objeto
     *            - objeto a ser salvo.
     */
    public void save(T objeto);

    /**
     * Exclui um objeto.
     * 
     * @param objeto
     *            - objeto que será excluído.
     */
    public void delete(T objeto);

    /**
     * Obtém um objeto da base de dados com base no id.
     *
     * @param id
     *            - Identificador do objeto a ser pesquisado.
     * @return o objeto encontrado.
     */
    public T findById(I id);

    /**
     * Obtém a lista de todos os objetos.
     *
     * @return Uma lista de objetos.
     */
    public List<T> getAll();
}