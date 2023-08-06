package com.example.ind11collections.service;

import com.example.ind11collections.exceptions.EmployeeAlreadyAddedException;
import com.example.ind11collections.exceptions.EmployeeNotFoundException;
import com.example.ind11collections.exceptions.EmployeeStorageIsFullException;
import com.example.ind11collections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int SIZE = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(String firstName, String lastName) {
        if (employees.size() == SIZE) {
            throw new EmployeeStorageIsFullException();
        }

        var key = makeKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(key, new Employee(firstName, lastName));
    }

    public Employee findEmployee(String firstName, String lastName) {
        var emp = employees.get(makeKey(firstName, lastName));
        if (emp == null) {
            throw new EmployeeNotFoundException();
        }
        return emp;
    }

    public boolean removeEmployee(String firstName, String lastName) {
        Employee removed = employees.remove(makeKey(firstName, lastName));
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return true;
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    private String makeKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }
}
