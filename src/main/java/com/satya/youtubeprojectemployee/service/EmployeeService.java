package com.satya.youtubeprojectemployee.service;

import org.springframework.stereotype.Service;

import com.satya.youtubeprojectemployee.Entity.Employee;
import java.util.List;

@Service
public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Employee findByID(long id); 
    public List<Employee> findAll();
    public void delete(Employee employee);
    

}
