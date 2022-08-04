package com.example.carsystemproject.service.employee;

import com.example.carsystemproject.model.entity.Employee;

import java.util.List;


public interface IEmployeeService  {
    Iterable<Employee> findAll();

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees(int pageNum, int pageSize);

    Employee getEmployeeById(Long id);
}
