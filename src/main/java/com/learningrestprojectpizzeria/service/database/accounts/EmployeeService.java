package com.learningrestprojectpizzeria.service.database.accounts;

import com.learningrestprojectpizzeria.model.entity.Employees;

import java.util.List;

public interface EmployeeService {

    public List<Employees> getAllEmployees();
    public void saveEmployee (Employees employee);
    public Employees getEmployeeById (int id);
    public void deleteEmployeeById (int id);
}