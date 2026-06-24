package com.nagp.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * Primary endpoint required by the assignment: fetches all records from the
     * database tier and returns them as JSON. Reachable externally through the
     * Ingress at /api/employees.
     */
    @GetMapping("/api/employees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    /**
     * Lightweight root endpoint so the Ingress host shows something friendly and
     * confirms which pod served the request (useful when demonstrating scaling
     * and rolling updates on camera).
     */
    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "service", "k8s-finops-api",
                "hostname", System.getenv().getOrDefault("HOSTNAME", "unknown"),
                "tryThis", "/api/employees");
    }
}
