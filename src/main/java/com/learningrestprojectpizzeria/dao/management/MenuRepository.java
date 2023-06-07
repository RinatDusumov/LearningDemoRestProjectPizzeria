package com.learningrestprojectpizzeria.dao.management;

import com.learningrestprojectpizzeria.models.management.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
