package com.nttdata.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Implementación ClienteImpl
 * 
 * @author jramlope
 *
 */
public class ClienteImpl extends CommonDaoImpl<Cliente> implements ClienteI {

	/** Conexión a la BBDD **/
	private Session session;

	/**
	 * Método constructor
	 */
	public ClienteImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Cliente> searchByNameAndSurname(String name, String surname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<Cliente> clientList = session
				.createQuery("FROM Cliente WHERE NAME='" + name + "' AND FIRST_SURNAME='" + surname + "'").list();

		return clientList;

	}

	@Override
	public List<Cliente> searchClienteByName(String name) {

		// Creación de CriteriaBuilder
		final CriteriaBuilder crbu = session.getCriteriaBuilder();

		// Creación de CriteriaQuery
		final CriteriaQuery<Cliente> consultaQuery = crbu.createQuery(Cliente.class);

		final Root<Cliente> root = consultaQuery.from(Cliente.class);

		// Predicate
		final Predicate predicate1 = crbu.equal(root.<String>get("name"), name);

		// Consulta
		consultaQuery.select(root).where(predicate1);

		// Ejecución
		final List<Cliente> resultados = session.createQuery(consultaQuery).getResultList();

		return resultados;
	}

}
