package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.Logins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO extends JpaRepository<Logins, Integer> {
}