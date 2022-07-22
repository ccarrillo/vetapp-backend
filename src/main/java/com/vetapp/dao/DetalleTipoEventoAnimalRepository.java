package com.vetapp.dao;

import com.vetapp.model.DetalleTipoEventoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleTipoEventoAnimalRepository extends JpaRepository<DetalleTipoEventoAnimal, Long> {

}