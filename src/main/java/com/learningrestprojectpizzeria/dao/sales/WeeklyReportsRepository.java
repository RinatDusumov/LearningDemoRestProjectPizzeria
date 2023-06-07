package com.learningrestprojectpizzeria.dao.sales;

import com.learningrestprojectpizzeria.models.salesEntity.WeeklyReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeeklyReportsRepository extends JpaRepository<WeeklyReports, Integer> {
}