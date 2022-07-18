package com.vetapp.dao;

import com.vetapp.model.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
	@Query(value = "SELECT o FROM Animal o WHERE o.sexo = :sexo ")
	List<Animal> obtenerAnimalBySexes(@Param("sexo") String sexo);
}
