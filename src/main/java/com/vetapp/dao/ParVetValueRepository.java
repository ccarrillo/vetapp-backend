package com.vetapp.dao;

import com.vetapp.model.ParVetValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParVetValueRepository extends JpaRepository<ParVetValue, Long> {

}