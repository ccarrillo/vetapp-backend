package com.vetapp.dao;

import com.vetapp.model.Animal;
import com.vetapp.vo.AnimalVO;

import java.util.List;

public interface AnimalDAO extends GenericDAO<Animal, Long> {
	List<Animal> obtenerAnimalBySexes(String sexo);
	List<AnimalVO> obtenerAnimalesVO(Boolean estado);
	boolean existenciaAnimal(String areteNombre);
	boolean existenciaAnimalDistintoId(Long id, String arete);
	

}
