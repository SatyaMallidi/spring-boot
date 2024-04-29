package com.satya.youtubeprojectemployee.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.youtubeprojectemployee.Entity.Employee;
import com.satya.youtubeprojectemployee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
       
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
        
        
    }

    @Override
    public Employee findByID(long id) {
        return employeeRepository.findById(id).get();
       
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
        
    }

    @Override
    public void delete(Employee employee) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

   }
