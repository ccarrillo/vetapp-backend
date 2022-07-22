package com.vetapp.dao;

import com.vetapp.model.RecordatorioEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordatorioEventoRepository extends JpaRepository<RecordatorioEvento, Long> {

}