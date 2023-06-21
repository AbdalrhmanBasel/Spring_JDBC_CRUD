package com.example.demo8.Repositories.implemmentation;

import com.example.demo8.Models.Employee;
import com.example.demo8.Repositories.EmployeeRepo;

import java.util.List;

public class EmployeJDBCRepo implements EmployeeRepo {
    

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Employee findById() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public int insert(Employee employee) {
        return 0;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public int delete(long id) {
        return 0;
    }
}
