package com.vetapp.service;

import com.vetapp.dto.AnimalDTO;
import com.vetapp.vo.AnimalVO;

import java.util.ArrayList;

public interface AnimalService {

    AnimalDTO guardarAnimal(AnimalDTO animalDto);

    ArrayList<AnimalDTO> obtenerAnimals();
    ArrayList<AnimalVO> obtenerAnimalesVO();

    ArrayList<AnimalDTO> obtenerAnimalBySexes(String sexo);

    AnimalDTO obtenerAnimalPorId(Long id);
    
    AnimalDTO buscarAnimalPorId(Long id);

    AnimalDTO actualizarAnimal(AnimalDTO employeeDto, Long id);
    
    boolean existenciaAnimal(String areteNombre);
    
    boolean existenciaAnimalDistintoId(Long id,String arete);

    boolean eliminarAnimal(Long id);
}
