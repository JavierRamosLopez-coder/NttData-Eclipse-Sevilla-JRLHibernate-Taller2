package com.nttdata.ejecucion;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.services.ClientService;
import com.nttdata.hibernate.services.ClientServiceImpl;
import com.nttdata.hibernate.services.ContractService;
import com.nttdata.hibernate.services.ContractServiceImpl;
import com.nttdata.persistence.Cliente;
import com.nttdata.persistence.Contract;

/**
 * Clase NttdataHibernateTest
 * 
 * @author jramlope
 *
 */
public class NttdataHibernateTest {

	/**
	 * Método main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Session
		final Session session = NttdataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios
		final ClientService clientService = new ClientServiceImpl(session);
		final ContractService contractService = new ContractServiceImpl(session);

		final String updatedUser = "NTTDATA_SYS";
		final Date updatedDate = new Date();

		// Creación de cliente
		Cliente c1 = new Cliente();

		c1.setName("Javier");
		c1.setFirstSurname("Ramos");
		c1.setSecondSurname("López");
		c1.setDni("21016078N");
		c1.setUpdatedDate(updatedDate);
		c1.setUpdatedUser(updatedUser);

		clientService.insertClient(c1);

		// Creación de cliente
		Cliente c2 = new Cliente();

		c2.setName("Alonso");
		c2.setFirstSurname("Ramos");
		c2.setSecondSurname("López");
		c2.setDni("21016078N");
		c2.setUpdatedDate(updatedDate);
		c2.setUpdatedUser(updatedUser);

		clientService.insertClient(c2);

		// Creación de contrato
		Contract cc1 = new Contract();

		cc1.setEffectiveDate(new Date());
		cc1.setExpiryDate(new Date());
		cc1.setMonthlyPrice(1200.8);
		cc1.setUpdatedDate(updatedDate);
		cc1.setUpdatedUser(updatedUser);
		cc1.setCustomer(c1);

		contractService.insertContract(cc1);

		// Creación de contrato
		Contract cc2 = new Contract();

		cc2.setEffectiveDate(new Date());
		cc2.setExpiryDate(new Date());
		cc2.setMonthlyPrice(1339.6);
		cc2.setUpdatedDate(updatedDate);
		cc2.setUpdatedUser(updatedUser);
		cc2.setCustomer(c1);

		contractService.insertContract(cc2);

		// Eliminación de un cliente
//		clientService.deleteClient(c1);

		// Eliminación de un contrato
//		contractService.deleteContract(cc1);

		// Actualización de un cliente
		c2.setName("Inmaculada");
		clientService.updateClient(c2);

		// Actualización de un contrato
		cc2.setMonthlyPrice(2005.6);
		contractService.updateContract(cc2);

		// Consultar todos los clientes
		System.out.println("------- TODOS LOS CLIENTES -------");
		List<Cliente> client = clientService.showAllClients();

		for (final Cliente allClient : client) {

			System.out.println(allClient.getNumericIdentifier() + " | " + allClient.getName() + " | "
					+ allClient.getFirstSurname() + " | " + allClient.getSecondSurname() + " | " + allClient.getDni());

		}

		// Búsqueda de un cliente por id
		System.out.println("\n");
		System.out.println("------- CONSULTA DE CLIENTES POR SU ID -------");
		Cliente listado = clientService.searchClientById(2L);

		System.out.println(listado.toString());

		// Búsqueda de un cliente por el nombre y el primer apellido
		System.out.println("\n");
		System.out.println("------- CONSULTA DE CLIENTE POR SU NOMBRE Y EL PRIMER APELLIDO -------");
		List<Cliente> clientes = clientService.searchByNameAndSurname("Inmaculada", "Ramos");

		for (final Cliente clientee : clientes) {
			System.out.println(
					clientee.getNumericIdentifier() + " | " + clientee.getDni() + " | " + clientee.getSecondSurname());
		}

		// Búsqueda de un contrato por id
		System.out.println("\n");
		System.out.println("------- CONSULTA DE CONTRATOS POR SU ID -------");
		Contract contrat = contractService.searchContractById(4L);

		System.out.println(contrat.toString());

		// Muestra de los contratos que pertenezcan a la id de ese cliente
		System.out.println("\n");
		System.out.println("------- CONSULTA DE CONTRATOS PERTENECIENTES A UNA ID -------");
		List<Contract> contrato = contractService.searchContractByClientId(1L);

		System.out.println(contrato.toString());

		// Consultar todos los contratos
		System.out.println("\n");
		System.out.println("------- TODOS LOS CONTRATOS -------");
		List<Contract> contratos = contractService.showAllContracts();

		for (final Contract allContract : contratos) {

			System.out.println(allContract.getContractNumericIdentifier() + " | " + allContract.getEffectiveDate()
					+ " | " + allContract.getExpiryDate() + " | " + allContract.getMonthlyPrice());

		}

		// Consultar nombre (Criteria)
		System.out.println("\n");
		System.out.println("------- (CRITERIA) -------");
		List<Cliente> clientess = clientService.searchByClientName("Javier");

		for (final Cliente clientt : clientess) {

			System.out.println(clientt.getDni() + " | " + clientt.getName());

		}

		// Cierre
		session.close();

	}

}
