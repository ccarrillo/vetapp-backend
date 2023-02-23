package com.vetapp.service;

import com.vetapp.dto.InventarioSemenDTO;

import java.util.ArrayList;
import java.util.List;

public interface InventarioSemenService {

    InventarioSemenDTO guardarInventarioSemen(InventarioSemenDTO inventarioSemenDto);

    ArrayList<InventarioSemenDTO> obtenerInventarioSemens();
    List<InventarioSemenDTO> obtenerInventarioSemenGrupos();

    InventarioSemenDTO obtenerInventarioSemenPorId(Long id);

    InventarioSemenDTO actualizarInventarioSemen(InventarioSemenDTO inventarioSemenDto, Long id);

    boolean eliminarInventarioSemen(Long id);

	boolean existenciainventarioDistintoId( String nombrenumero);

	boolean existenciainventarioDistintoId(Long id, String nombrenumero);


}
