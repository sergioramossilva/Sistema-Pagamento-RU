package br.edu.utfpr.cm.pi.interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.utfpr.cm.pi.daos.JpaDao;

/**
 * Interface genérica destinada à persistência de objetos.
 * 
 * @param <T>
 *            - Parâmetro genérico que identifica o tipo do objeto.
 * @param <I>
 *            - Parâmetro genérico que identifica o tipo do identificador do
 *            objeto. Exemplos: {@code Long}, {@code Integer}, etc.
 */
public interface Dao<T, I> {

	/**
	 * Salva um objeto.
	 *
	 * @param objeto
	 *            - objeto a ser salvo.
	 */
	public void save(T objeto);

	/**
	 * Atualiza um objeto.
	 * 
	 * @param objeto
	 *            - objeto a ser atualizado.
	 */
	public void update(T objeto);

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
	 * @return <T>T<T> - Objeto encontrado.
	 */
	public T findById(T objeto, I id);

	/**
	 * Obtém a lista de objetos do tipo <T>T<T>.
	 *
	 * @return Uma lista de objetos.
	 */
	
	 public List<T> getAll();
}