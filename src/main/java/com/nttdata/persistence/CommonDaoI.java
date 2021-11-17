package com.nttdata.persistence;

import java.util.List;

/**
 * Interfaz CommonDao
 * 
 * @author jramlope
 *
 */
public interface CommonDaoI<T> {

	/**
	 * Insercción de clientes
	 * 
	 * @param <T>
	 * 
	 * @param parametro
	 */
	public void insertClient(final T parametro);

	/**
	 * Listado de todos los clientes
	 * 
	 * @return
	 */
	public List<T> showAllClients();

	/**
	 * Búsqueda de clientes por ID
	 * 
	 * @return
	 */
	public T searchClientById(final Long id);

	/**
	 * Eliminación de clientes
	 * 
	 * @param parametro
	 */
	public void deleteClient(final T parametro);

	/**
	 * Actualización de clientes
	 * 
	 * @param parametro
	 */
	public void updateClient(final T parametro);

}
