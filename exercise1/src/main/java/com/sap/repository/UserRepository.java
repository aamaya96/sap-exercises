package com.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sap.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
