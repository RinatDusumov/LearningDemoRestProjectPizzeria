package com.learningrestprojectpizzeria.controllers.statistics;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.learningrestprojectpizzeria.model.entity.Employees;
import com.learningrestprojectpizzeria.service.statistics.accounts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Employee {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/manage/employees")
    public List<Employees> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/manage/employees/{id}")
    public Employees getEmployee(@PathVariable int id) {

        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/manage/employees")
    public Employees addNewEmployee (@RequestBody Employees employee) {
        employee.getLogin().setPassword("{bcrypt}" + BCrypt.withDefaults().hashToString(12,
                employee.getLogin().getPassword().toCharArray()));
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/manage/employees")
    public Employees updateEmployee (@RequestBody Employees employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/manage/employees/{id}")
    public String deleteEmployee (@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return "Employee with ID = " + id + " was deleted.";
    }

//    @GetMapping("/manage/accounts/name/{name}")
//    public List<EmployeeService> getAllAccountsByFirstName (@PathVariable String firstName) {
//        List<EmployeeService> accounts = accountService.findAllByFirstName(firstName);
//        return accounts;
//    }
}