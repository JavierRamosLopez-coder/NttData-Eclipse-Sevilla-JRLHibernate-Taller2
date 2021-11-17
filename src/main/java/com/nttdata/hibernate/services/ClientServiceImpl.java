package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Cliente;
import com.nttdata.persistence.ClienteI;
import com.nttdata.persistence.ClienteImpl;

/**
 * Implementación del servicio de clientes
 * 
 * @author jramlope
 *
 */
public class ClientServiceImpl implements ClientService {

	/** DAO : ClienteI **/
	private ClienteI cliente;

	/**
	 * Método constructor.
	 */
	public ClientServiceImpl(final Session session) {
		this.cliente = new ClienteImpl(session);
	}

	@Override
	public void insertClient(Cliente insertClient) {
		// Verificación de nulidad e inexistencia.
		if (insertClient != null && insertClient.getNumericIdentifier() == null) {

			// Insercción del nuevo jugador.
			cliente.insertClient(insertClient);
		}

	}

	@Override
	public List<Cliente> showAllClients() {

		// Resultado.
		List<Cliente> clientes = new ArrayList<Cliente>();

		// Obtención de jugadores.
		clientes = cliente.showAllClients();

		return clientes;
	}

	@Override
	public Cliente searchClientById(final Long id) {
		// Resultado.
		Cliente client = null;

		// Verificación de nulidad.
		if (id != null) {

			// Obtención del cliente por ID.
			client = cliente.searchClientById(id);
		}

		return client;
	}

	@Override
	public void deleteClient(final Cliente deleteClient) {
		// Verificación de nulidad y existencia.
		if (deleteClient != null && deleteClient.getDni() != null) {

			// Eliminación del jugador.
			cliente.deleteClient(deleteClient);
		}

	}

	@Override
	public void updateClient(final Cliente updateClient) {
		// Verificación de nulidad y existencia.
		if (updateClient != null && updateClient.getDni() != null) {

			// Actualización del jugador.
			cliente.updateClient(updateClient);
		}
	}

	@Override
	public List<Cliente> searchByNameAndSurname(final String name, final String surname) {

		// Resultado.
		List<Cliente> clientes = new ArrayList<Cliente>();

		// Obtención de jugadores.
		clientes = cliente.searchByNameAndSurname(name, surname);

		return clientes;
	}

	@Override
	public List<Cliente> searchByClientName(String name) {

		// Resultado
		List<Cliente> clientes = new ArrayList<Cliente>();

		// Obtención de clientes
		clientes = cliente.searchClienteByName(name);

		return clientes;

	}

}
