package com.vetapp.dao;


import com.vetapp.model.ParListValue;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParListValueRepository extends JpaRepository<ParListValue, Long> {
	
	
	

}