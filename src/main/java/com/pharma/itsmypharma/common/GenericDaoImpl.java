package com.pharma.itsmypharma.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


public abstract class GenericDaoImpl<T extends Serializable> implements GenericDao<T> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public EntityManager getEntityManger() {
		return this.entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public T save(T entity) {
		this.getEntityManager().persist(entity);
		this.getEntityManager().flush();
		return entity;
	}

	public T update(T entity) {

		T updateEntity = this.getEntityManager().merge(entity);
		this.getEntityManager().flush();
		return updateEntity;
	}

	public T find(Object id) {
		return this.getEntityManager().find(type, id);
	}

	public void delete(final Object id) {
		this.getEntityManager().remove(id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAllAsList() {
		return this.getEntityManager().createQuery(" from " + type.getName()).getResultList();
	}

	public void batchSave(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			this.getEntityManager().persist(list.get(i));
			this.commitBatchTransation(i);
		}

		this.getEntityManager().clear();
	}

	public void bacthupdate(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			this.getEntityManager().merge(list.get(i));
			this.commitBatchTransation(i);
		}

		this.getEntityManager().clear();
	}

	public void batchDelete(List<T> list) {
		for (int i = 0; i < list.size(); i++) {
			this.getEntityManager().remove(list.get(i));
			this.commitBatchTransation(i);
		}

		this.getEntityManager().clear();
	}

	private void commitBatchTransation(Integer i) {
		if (i % 2 == 0) {
			this.getEntityManager().flush();
		}
	}

}
