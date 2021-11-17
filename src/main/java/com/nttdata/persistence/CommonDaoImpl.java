package com.nttdata.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * 
 * @author jramlope
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Clase **/
	private Class<T> entityClass;

	/** Conexión a la BBDD **/
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	/** IMPLEMENTACIÓN DE LOS MÉTODOS DE LA INTERFAZ **/
	@Override
	public void insertClient(final T parametro) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(parametro);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public List<T> showAllClients() {
		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;
	}

	@Override
	public T searchClientById(final Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		T result = session.get(this.entityClass, id);

		return result;

	}


	@Override
	public void deleteClient(final T parametro) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(parametro);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public void updateClient(final T parametro) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(parametro);

		// Commit.
		session.getTransaction().commit();

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
