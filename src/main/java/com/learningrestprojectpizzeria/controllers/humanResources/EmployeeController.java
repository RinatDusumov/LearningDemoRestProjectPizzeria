package com.learningrestprojectpizzeria.controllers.humanResources;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.learningrestprojectpizzeria.models.hrEntity.Employee;
import com.learningrestprojectpizzeria.service.database.hrData.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee (@RequestBody Employee employee) {
        employee.getLoginInput().setPassword("{bcrypt}" + BCrypt.withDefaults().hashToString(12,
                employee.getLoginInput().getPassword().toCharArray()));
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee (@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getAllEmployeesByFirstName (@PathVariable String firstName) {
        List<Employee> employees = employeeService.findAllByFirstName(firstName);
        return employees;
    }
}