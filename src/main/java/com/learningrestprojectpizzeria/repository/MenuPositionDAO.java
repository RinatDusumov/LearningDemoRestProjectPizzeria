package com.learningrestprojectpizzeria.repository;

import com.learningrestprojectpizzeria.model.entity.MenuPositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPositionDAO extends JpaRepository<MenuPositions, Integer> {

}