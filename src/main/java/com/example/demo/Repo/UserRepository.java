package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository < User, Long > {
    User findByEmailAddress(String emailAddress);

    List < User > findByLastname(String lastname);
}