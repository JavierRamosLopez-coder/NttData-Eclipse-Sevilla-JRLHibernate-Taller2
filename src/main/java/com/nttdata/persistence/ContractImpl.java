package com.nttdata.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class ContractImpl extends CommonDaoImpl<Contract> implements ContractI {

	/** Conexión a la BBDD **/
	private Session session;

	/**
	 * Método constructor
	 */
	public ContractImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Contract> searchByNumericIdentifier(Long id) {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<Contract> contractList = session
				.createQuery("FROM Contract WHERE customer.numericIdentifier='" + id + "'").list();

		return contractList;

	}

}
