package com.vetapp.service;

import com.vetapp.dto.DetalleTipoEventoAnimalDto;

import java.util.ArrayList;

public interface DetalleTipoEventoAnimalService {

    DetalleTipoEventoAnimalDto guardarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto);

    ArrayList<DetalleTipoEventoAnimalDto> obtenerDetalleTipoEventoAnimals();

    DetalleTipoEventoAnimalDto obtenerDetalleTipoEventoAnimalPorId(Long id);

    DetalleTipoEventoAnimalDto actualizarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto, Long id);

    boolean eliminarDetalleTipoEventoAnimal(Long id);
}
