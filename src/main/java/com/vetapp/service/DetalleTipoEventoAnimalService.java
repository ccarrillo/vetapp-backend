package com.vetapp.service;

import com.vetapp.dto.DetalleTipoEventoAnimalDTO;
import com.vetapp.dto.EventoAnimalDTO;

import java.util.ArrayList;
import java.util.List;

public interface DetalleTipoEventoAnimalService {

    DetalleTipoEventoAnimalDTO guardarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto);
    

    ArrayList<DetalleTipoEventoAnimalDTO> obtenerDetalleTipoEventoAnimals();

    DetalleTipoEventoAnimalDTO obtenerDetalleTipoEventoAnimalPorId(Long id);
    
    List<DetalleTipoEventoAnimalDTO>  obtenerListaDetallePorIdEventoAnimal(Long id);

    DetalleTipoEventoAnimalDTO actualizarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto, Long id);
    
    DetalleTipoEventoAnimalDTO guardarDetalleTipoEventoAnimal(EventoAnimalDTO evento,DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto);
    DetalleTipoEventoAnimalDTO actualizarDetalleTipoEventoAnimal(EventoAnimalDTO evento,DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto, Long id);

    boolean eliminarDetalleTipoEventoAnimal(Long id);
}
