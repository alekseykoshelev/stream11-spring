package com.example.ind11collections.controller;

import com.example.ind11collections.model.Employee;
import com.example.ind11collections.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{deptId}/salary/sum")
    public double sumByDept(@PathVariable int deptId) {
        return service.sum(deptId);
    }

    @GetMapping("/{deptId}/salary/max")
    public double max(@PathVariable int deptId) {
        return service.maxSalary(deptId);
    }

    @GetMapping("/{deptId}/salary/min")
    public double min(@PathVariable int deptId) {
        return service.minSalary(deptId);
    }

    @GetMapping("/{deptId}/employees")
    public Collection<Employee> byDept(@PathVariable int deptId) {
        return service.findAllByDept(deptId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all() {
        return service.groupByDept();
    }
}
