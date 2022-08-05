package com.vetapp.service;

import com.vetapp.dto.DetalleTipoEventoAnimalDTO;

import java.util.ArrayList;

public interface DetalleTipoEventoAnimalService {

    DetalleTipoEventoAnimalDTO guardarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto);

    ArrayList<DetalleTipoEventoAnimalDTO> obtenerDetalleTipoEventoAnimals();

    DetalleTipoEventoAnimalDTO obtenerDetalleTipoEventoAnimalPorId(Long id);

    DetalleTipoEventoAnimalDTO actualizarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto, Long id);

    boolean eliminarDetalleTipoEventoAnimal(Long id);
}
