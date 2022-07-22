package com.vetapp.dao;

import com.vetapp.model.InventarioSemen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioSemenRepository extends JpaRepository<InventarioSemen, Long> {

}