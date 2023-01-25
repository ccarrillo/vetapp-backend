package com.vetapp.dao;
import java.util.List;

import com.vetapp.dto.MedicionDTO;
import com.vetapp.model.Medicion;

public interface MedicionDAO extends GenericDAO<Medicion, Long> {

	List<Medicion> buscarMedicionesPorAnimal(Long id);

}
