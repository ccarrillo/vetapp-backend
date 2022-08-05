package com.vetapp.service;

import com.vetapp.dto.InventarioSemenDto;

import java.util.ArrayList;

public interface InventarioSemenService {

    InventarioSemenDto guardarInventarioSemen(InventarioSemenDto inventarioSemenDto);

    ArrayList<InventarioSemenDto> obtenerInventarioSemens();

    InventarioSemenDto obtenerInventarioSemenPorId(Long id);

    InventarioSemenDto actualizarInventarioSemen(InventarioSemenDto inventarioSemenDto, Long id);

    boolean eliminarInventarioSemen(Long id);

}
