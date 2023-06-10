package com.learningrestprojectpizzeria.service.database.hrData;

import com.learningrestprojectpizzeria.dao.hr.EmployeeRepository;
import com.learningrestprojectpizzeria.modelEntity.hrEntity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeDAO;
    private Employee employee = null;
    @Override
    public List<Employee> getAllEmployees() {

        return employeeDAO.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {

        employeeDAO.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> optional = employeeDAO.findById(id);
        if(optional.isPresent()) {
            employee = optional.get();
            // если optional пуст можно выбрасывать исключение
        }

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Optional<Employee> optional = employeeDAO.findById(id);
        if (optional.isPresent()) {
            employeeDAO.deleteById(id);
        }
    }

    @Override
    public List<Employee> findAllByFirstName(String firstName) {
        List<Employee> employees = employeeDAO.findAllByFirstName(firstName);
        return employees;
    }
}