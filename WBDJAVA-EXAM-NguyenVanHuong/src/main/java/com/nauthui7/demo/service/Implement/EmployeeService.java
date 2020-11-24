package com.nauthui7.demo.service.Implement;

import com.nauthui7.demo.model.Employee;
import com.nauthui7.demo.repository.EmployeeRepository;
import com.nauthui7.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements BaseService<Employee> {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee remove(int id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
        return employee;
    }
}
