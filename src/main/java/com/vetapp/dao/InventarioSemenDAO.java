package com.vetapp.dao;


import java.util.List;

import com.vetapp.dto.InventarioSemenDTO;
import com.vetapp.model.InventarioSemen;

public interface InventarioSemenDAO extends GenericDAO<InventarioSemen, Long> {

	List<InventarioSemenDTO> obtenerInventarioSemenGrupos(boolean b);

	boolean existenciainventarioDistintoId(String nombrenumero);

	boolean existenciainventarioDistintoId(Long id, String nombrenumero);

}