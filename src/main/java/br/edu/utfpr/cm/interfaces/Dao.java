package br.edu.utfpr.cm.interfaces;

import java.util.List;

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
	 * Insere ou atualiza um objeto.
	 *
	 * @param objeto
	 *            - objeto a ser inserio ou atualizado.
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
	 * @return <T>T<T> - Objeto encontrado.
	 */
	public T getById(I id);

	/**
	 * Obtém uma lista de objetos do tipo <T>T<T>.
	 *
	 * @return Uma lista de objetos.
	 */
	public List<T> getAll();
}