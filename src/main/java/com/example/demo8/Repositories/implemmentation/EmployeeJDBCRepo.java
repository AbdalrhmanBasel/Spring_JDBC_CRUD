package com.example.demo8.Repositories.implemmentation;

import com.example.demo8.Models.Employee;
import com.example.demo8.Repositories.EmployeeRepo;
import com.example.demo8.Repositories.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJDBCRepo implements EmployeeRepo {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeJDBCRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) FROM employees";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public Employee findById(long id) {
        String query = "SELECT * FROM employees Where id = ?";
        return jdbcTemplate.queryForObject(query, new Object[] {id}, new EmployeeMapper());
    }

    @Override
    public Employee findById() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        String query = "SELECT * FROM employees";
        return jdbcTemplate.query(query, (resultSet, rowNum) -> {
            Employee employee = new Employee();
            // Insert data to bean using setters instead of constructors.
            employee.setId(resultSet.getLong("id"));
            employee.setFirst_name(resultSet.getString("first_name"));
            employee.setLast_name(resultSet.getString("last_name"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setAge(resultSet.getInt("age"));
            return employee;
        });
    }


    @Override
    public int create(Employee employee) {
        String query = "INSERT INTO employees (id, first_name, last_name, age, salary) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(query, new Object[] {
                employee.getId(),
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getAge(),
                employee.getSalary()
        });
    }

    @Override
    public int update(long id, Employee employee) {
        String query = "UPDATE employees SET first_name=?, last_name=?, age=?, salary=? WHERE id=?";
        return jdbcTemplate.update(query, new Object[] {
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getAge(),
                employee.getSalary(),
                employee.getId()
        });
    }

    @Override
    public int deleteById(long id) {
        String query = "DELETE FROM employees WHERE id=?";
        return jdbcTemplate.update(query, id);
    }
}
