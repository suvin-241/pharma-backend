package com.pharma.itsmypharma.common;


import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {

	T find(Object id);

	T save(T t);

	void delete(Object id);

	T update(T t);

	List<T> findAllAsList();

	void batchSave(List<T> list);

	void bacthupdate(List<T> list);

	void batchDelete(List<T> list);


}
