package com.vetapp.dao;

import com.vetapp.model.ParVet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParVetRepository extends JpaRepository<ParVet, Long> {

}