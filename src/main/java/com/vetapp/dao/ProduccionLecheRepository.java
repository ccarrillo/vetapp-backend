package com.vetapp.dao;

import com.vetapp.model.ProduccionLeche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduccionLecheRepository extends JpaRepository<ProduccionLeche, Long> {

}