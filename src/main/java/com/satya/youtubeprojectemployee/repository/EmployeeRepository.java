package com.satya.youtubeprojectemployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satya.youtubeprojectemployee.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
     
}
