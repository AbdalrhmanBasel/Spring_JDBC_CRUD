package com.example.demo8.Controllers;

import com.example.demo8.Models.Employee;
import com.example.demo8.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/count")
    public int countEmployees() {
        return employeeRepo.count();
    };

    @GetMapping("all")
    public String AllEmployees(){
        return employeeRepo.findAll().toString();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeRepo.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
        employee.setId(id);
        int rowsAffected = employeeRepo.update(id, employee);
        if (rowsAffected > 0) {
            return ResponseEntity.ok("Employee updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update employee");
        }
    }


    @GetMapping("delete/{id}")
    public String deleteEmployeeById(@PathVariable long id) {
        int rowsAffected = employeeRepo.deleteById(id);
        if (rowsAffected > 0) {
            return "Employee deleted successfully";
        } else {
            return "Failed to delete employee";
        }
    }

    @GetMapping("/say")
    public String sayHello() {
        return "Hello bro";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        // Logic to create the employee
        int rowsAffected = employeeRepo.create(employee);

        if (rowsAffected > 0) {
            return ResponseEntity.ok("Employee created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create employee");
        }
    }


}
