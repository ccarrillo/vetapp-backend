package com.vetapp.service;

import java.util.ArrayList;
import java.util.List;

import com.vetapp.dto.MedicionDTO;

public interface MedicionService {
	
	    MedicionDTO guardarMedicion(MedicionDTO medicionDto);

	    ArrayList<MedicionDTO> obtenerMediciones();

	    MedicionDTO obtenerMedicionPorId(Long id);
	    

	    MedicionDTO actualizarMedicion(MedicionDTO employeeDto, Long id);

	    boolean eliminarMedicion(Long id);

		List<MedicionDTO> buscarMedicionesPorAnimal(Long id);

}
