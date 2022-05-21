package com.vetapp.dao;

import com.vetapp.model.ParList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParListRepository extends JpaRepository<ParList, Long> {

}