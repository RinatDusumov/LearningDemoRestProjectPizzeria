package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.models.management.Remains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemainedRepository extends JpaRepository<Remains, Integer> {
}