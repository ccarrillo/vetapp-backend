package com.vetapp.dao;

import com.vetapp.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query(value = "SELECT u FROM UserRole u WHERE u.userId = :userId")
    List<UserRole> findByUserId(Long userId);

}