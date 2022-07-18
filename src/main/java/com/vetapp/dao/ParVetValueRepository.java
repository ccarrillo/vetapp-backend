package com.vetapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetapp.model.ParVetValue;

@Repository
public interface ParVetValueRepository extends JpaRepository<ParVetValue, Long> {
      
	@Query(value = "SELECT o FROM ParVetValue o WHERE o.parvetId = :idParVet ")
	List<ParVetValue> findParVetValueByParvetId(@Param("idParVet") Long idParVet);

}