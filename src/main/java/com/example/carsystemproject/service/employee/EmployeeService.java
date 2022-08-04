package com.example.carsystemproject.service.employee;

import com.example.carsystemproject.service.exception.ExistedException;
import com.example.carsystemproject.service.exception.NotFoundException;
import com.example.carsystemproject.model.entity.Employee;
import com.example.carsystemproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employeeRepository.findEmployeeByAccount(employee.getAccount()).isPresent()) {
            throw new ExistedException("This account: " + employee.getAccount() + "existed");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(int pageNum, int pageSize) {
        return employeeRepository.findAll(PageRequest.of(pageNum, pageSize)).getContent();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("This id: " + id + "not found"));
    }
}
