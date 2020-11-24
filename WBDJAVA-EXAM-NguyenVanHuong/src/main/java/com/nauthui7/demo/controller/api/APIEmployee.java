package com.nauthui7.demo.controller.api;

import com.nauthui7.demo.model.Employee;
import com.nauthui7.demo.service.Implement.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIEmployee {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> allEmployees = employeeService.findAll();
        if (allEmployees == null) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> delete(@PathVariable("id") int id) {
        Employee employee = employeeService.remove(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.save(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}
