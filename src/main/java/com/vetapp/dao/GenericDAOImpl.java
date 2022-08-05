package com.vetapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public List<T> buscarTodos(T t) {
        return this.em.createQuery("from " + type.getName()).getResultList();
    }

    @Override
    public List<T> buscarActivos(T t) {
        /*String sQuery = "from " + type.getName() + " where is_active = ?1";
        Query query=this.em.createQuery(sQuery);
        query.setParameter(1, true);
        return query.getResultList();*/
        //return this.em.createQuery("from " + type.getName() + " where is_active = " + true).getResultList();
        return this.em.createQuery("from " + type.getName() + " where is_active = ?1").setParameter(1, true).getResultList();
    }

    @Override
    public T buscarPorId(ID id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public T insertar(T t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public T actualizar(T t) {
        return this.em.merge(t);
    }

    @Override
    public void eliminarPorId(ID id) {
        this.em.remove(this.em.getReference(type, id));
    }
}
