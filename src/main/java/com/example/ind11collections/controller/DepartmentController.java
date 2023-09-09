package com.example.ind11collections.controller;

import com.example.ind11collections.model.Employee;
import com.example.ind11collections.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public double max(@RequestParam int departmentId) {
        return service.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public double min(@RequestParam int departmentId) {
        return service.minSalary(departmentId);
    }

    @GetMapping("/find-by-dept")
    public Collection<Employee> byDept(@RequestParam int departmentId) {
        return service.findAllByDept(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return service.groupByDept();
    }
}
