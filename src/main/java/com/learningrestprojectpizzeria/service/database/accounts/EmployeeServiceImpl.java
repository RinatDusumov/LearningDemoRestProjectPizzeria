package com.learningrestprojectpizzeria.service.database.accounts;

import com.learningrestprojectpizzeria.model.entity.Employees;
import com.learningrestprojectpizzeria.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employees> getAllEmployees() {

        return employeeDAO.findAll();
    }

    @Override
    public void saveEmployee(Employees employee) {

        Employees newEmployee = employeeDAO.save(employee);
    }

    @Override
    public Employees getEmployeeById(int id) {
        Employees employee = null;
        Optional<Employees> optional = employeeDAO.findById(id);
        if(optional.isPresent()) {
            employee = optional.get();
            // если optional пуст можно выбрасывать исключение
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        Optional<Employees> optional = employeeDAO.findById(id);
        if (optional.isPresent()) {
            employeeDAO.deleteById(id);
        }
        //TODO если optional пуст можно выбрасывать исключение

    }
}
