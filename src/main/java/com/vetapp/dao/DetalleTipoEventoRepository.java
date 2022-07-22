package com.vetapp.dao;

import com.vetapp.model.DetalleTipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleTipoEventoRepository extends JpaRepository<DetalleTipoEvento, Long> {

}