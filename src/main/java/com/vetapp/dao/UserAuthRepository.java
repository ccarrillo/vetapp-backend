package com.vetapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetapp.model.UserAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    UserAuth findByUsername(String userName);

}
