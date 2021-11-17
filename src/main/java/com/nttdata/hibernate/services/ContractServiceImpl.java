package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Cliente;
import com.nttdata.persistence.ClienteI;
import com.nttdata.persistence.Contract;
import com.nttdata.persistence.ContractI;
import com.nttdata.persistence.ContractImpl;

public class ContractServiceImpl implements ContractService {

	/** DAO : Contract **/
	private ClienteI cliente;
	private ContractI contract;

	/**
	 * Método constructor.
	 */
	public ContractServiceImpl(final Session session) {
		this.contract = new ContractImpl(session);
	}

	@Override
	public void insertContract(Contract insertContract) {

		// Verificación de nulidad e inexistencia.
		if (insertContract != null && insertContract.getContractNumericIdentifier() == null) {

			// Insercción del nuevo jugador.
			contract.insertClient(insertContract);
		}

	}

	@Override
	public List<Contract> showAllContracts() {

		// Resultado.
		List<Contract> contratos = new ArrayList<Contract>();

		// Obtención de jugadores.
		contratos = contract.showAllClients();

		return contratos;

	}

	@Override
	public Contract searchContractById(Long id) {

		// Resultado.
		Contract contractId = null;

		// Verificación de nulidad.
		if (id != null) {

			// Obtención del cliente por ID.
			contractId = contract.searchClientById(id);
		}

		return contractId;
	}

	@Override
	public void deleteContract(Contract deleteContract) {

		// Verificación de nulidad y existencia.
		if (deleteContract != null && deleteContract.getContractNumericIdentifier() != null) {

			// Eliminación del jugador.
			contract.deleteClient(deleteContract);
		}

	}

	@Override
	public void updateContract(Contract updateContract) {

		// Verificación de nulidad y existencia.
		if (updateContract != null && updateContract.getContractNumericIdentifier() != null) {

			// Actualización del jugador.
			contract.updateClient(updateContract);
		}

	}

	@Override
	public List<Contract> searchContractByClientId(Long id) {
		// Resultado.
		List<Contract> contractId = null;

		// Verificación de nulidad.
		if (id != null) {

			// Obtención del cliente por ID.
			contractId = contract.searchByNumericIdentifier(id);
		}

		return contractId;
	}

}
