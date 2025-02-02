package com.springboot.restcruddemo.service;

import com.springboot.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAll();

     Employee findById(int theId);

     Employee save(Employee theEmployee);

     void deleteById(int theId);
}
