package com.nagp.api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Maps to the "employees" table that is seeded by db/init/seed.sql when MySQL
 * first initialises. The application only reads from this table, so the schema
 * is owned by the seed script (Hibernate ddl-auto is set to "none").
 */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "role")
    private String role;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }
}
