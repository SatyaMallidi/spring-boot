package com.satya.youtubeprojectemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satya.youtubeprojectemployee.Entity.Employee;
import com.satya.youtubeprojectemployee.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/")
    public ResponseEntity<String> newEmployee(@RequestBody Employee employee) {
        if (employee != null) {
            employeeService.saveEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("New Employee saved successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid employee data");
        }
    }
    

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployee(){
            List<Employee> employee=employeeService.findAll();
            return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
     Employee employee = employeeService.findByID(id);
     if(employee!=null){
        return ResponseEntity.ok(employee);
     }
     else {
        return ResponseEntity.notFound().build();
     }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee emp){
        Employee employee = employeeService.findByID(id);
        if(employee!=null){
            employee.setName(emp.getName());
            employeeService.saveEmployee(employee);

            return ResponseEntity.ok(emp);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        Employee employee = employeeService.findByID(id);
        if (employee != null) {
            employeeService.deleteEmployee(employee);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
