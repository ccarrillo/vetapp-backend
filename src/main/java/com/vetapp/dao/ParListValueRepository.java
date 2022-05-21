package com.vetapp.dao;

import com.vetapp.model.ParListValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParListValueRepository extends JpaRepository<ParListValue, Long> {

}