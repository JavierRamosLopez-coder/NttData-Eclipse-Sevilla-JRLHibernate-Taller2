package com.nttdata.persistence;

import java.util.List;

/**
 * Interfaz ClienteI
 * @author jramlope
 *
 */
public interface ClienteI extends CommonDaoI<Cliente>{

	/***
	 * 
	 * Búsqueda de un cliente por su nombre y apellido
	 * 
	 * @param name
	 * @param surname
	 * @return
	 */
	public List<Cliente> searchByNameAndSurname(final String name, final String surname);
	
	/**
	 * 
	 * Búsqueda de un cliente por su nombre (consulta Criteria)
	 * 
	 * @param name
	 * @return
	 */
	public List<Cliente> searchClienteByName(final String name);
	
}
