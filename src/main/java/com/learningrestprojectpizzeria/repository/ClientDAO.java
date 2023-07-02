package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDAO extends JpaRepository<Clients, Integer> { }