package com.learningrestprojectpizzeria.dao.kitchen;

import com.learningrestprojectpizzeria.modelEntity.kitchen.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}
