package com.vetapp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    List<T> buscarTodos(T t);

    List<T> buscarActivos(T t);
    T buscarPorId(ID id);

    T insertar(T t);

    T actualizar(T t);

    void eliminarPorId(ID id);
}
