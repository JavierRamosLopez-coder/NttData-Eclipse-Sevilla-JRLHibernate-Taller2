package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.persistence.Cliente;

/**
 * Interfaz de los clientes
 * @author jramlope
 *
 */
public interface ClientService {

	/**
	 * Insercción de clientes
	 * @param client
	 */
	public void insertClient(final Cliente client);
	
	/**
	 * Muestra de todos los clientes
	 * @return
	 */
	public List<Cliente> showAllClients();
	
	/**
	 * Búsqueda de clientes por su id
	 * @param id
	 * @return
	 */
	public Cliente searchClientById(final Long id);
	
	/**
	 * Eliminación de clientes
	 * @param client
	 */
	public void deleteClient(final Cliente client);
	
	/**
	 * Actualización de clientes
	 * @param client
	 */
	public void updateClient(final Cliente client);
	
	/**
	 * Búsqueda de clientes por su nombre y apellido
	 * @param name
	 * @param surname
	 * @return
	 */
	public List<Cliente> searchByNameAndSurname(final String name, final String surname);
	
	/**
	 * 
	 * Búsqueda de el nombre del cliente (Criteria)
	 * 
	 * @param name
	 * @return
	 */
	public List<Cliente> searchByClientName(final String name);
	
	
	
}
