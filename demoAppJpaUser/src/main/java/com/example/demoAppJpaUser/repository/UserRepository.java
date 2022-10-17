package com.example.demoAppJpaUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoAppJpaUser.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
