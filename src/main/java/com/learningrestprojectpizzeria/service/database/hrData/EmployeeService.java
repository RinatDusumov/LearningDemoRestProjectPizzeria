package com.learningrestprojectpizzeria.service.database.hrData;

import com.learningrestprojectpizzeria.models.hrEntity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee (Employee employee);
    public Employee getEmployee (int id);
    public void deleteEmployee (int id);
    public List<Employee> findAllByFirstName(String firstName);

}