package com.example.demo8.Repositories;

import com.example.demo8.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {

    int count();

    // Select spacific employee
    Employee findById(long id);

    // List all Employees
    List<Employee> findAll();

    // CRUD Operations
    int create(Employee employee); // Create
    Employee findById (); // Read
    int update(long id, Employee employee); // Update
    int deleteById(long id); // Delete
}
