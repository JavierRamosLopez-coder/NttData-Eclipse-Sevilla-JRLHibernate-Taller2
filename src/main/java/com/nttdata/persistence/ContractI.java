package com.nttdata.persistence;

import java.util.List;

public interface ContractI extends CommonDaoI<Contract> {

	/**
	 * Búsqueda de un cliente por su identificador
	 * 
	 * @return
	 */
	public List<Contract> searchByNumericIdentifier(final Long id);

}
