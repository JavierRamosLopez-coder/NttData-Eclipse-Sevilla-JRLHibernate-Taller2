package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.persistence.Cliente;
import com.nttdata.persistence.Contract;

public interface ContractService {

	/**
	 * Insercción de contratos
	 * 
	 * @param client
	 */
	public void insertContract(final Contract contract);

	/**
	 * Muestra de todos los contratos
	 * 
	 * @return
	 */
	public List<Contract> showAllContracts();

	/**
	 * Búsqueda de contratos por su id
	 * 
	 * @param id
	 * @return
	 */
	public Contract searchContractById(final Long id);

	/**
	 * Eliminación de contratos
	 * 
	 * @param client
	 */
	public void deleteContract(final Contract contract);

	/**
	 * Actualización de contratos
	 * 
	 * @param contract
	 */
	public void updateContract(final Contract contract);

	/**
	 * Búsqueda de los contratos de un cliente dada la ID
	 * 
	 * @param id
	 * @return
	 */
	public List<Contract> searchContractByClientId(final Long id);

}
