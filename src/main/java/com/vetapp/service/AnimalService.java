package com.vetapp.service;

import com.vetapp.dto.AnimalDTO;

import java.util.ArrayList;

public interface AnimalService {

    AnimalDTO guardarAnimal(AnimalDTO animalDto);

    ArrayList<AnimalDTO> obtenerAnimals();

    ArrayList<AnimalDTO> obtenerAnimalBySexes(String sexo);

    AnimalDTO obtenerAnimalPorId(Long id);

    AnimalDTO actualizarAnimal(AnimalDTO employeeDto, Long id);

    boolean eliminarAnimal(Long id);
}
