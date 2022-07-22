package com.vetapp.dao;

import com.vetapp.model.Racion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacionRepository extends JpaRepository<Racion, Long> {

}