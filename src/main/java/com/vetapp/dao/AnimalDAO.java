package com.vetapp.dao;

import com.vetapp.model.Animal;

import java.util.List;

public interface AnimalDAO extends GenericDAO<Animal, Long> {
	List<Animal> obtenerAnimalBySexes(String sexo);

}
