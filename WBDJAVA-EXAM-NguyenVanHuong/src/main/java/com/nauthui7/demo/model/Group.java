package com.nauthui7.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(targetEntity = Employee.class)
    @JsonIgnore
    private List<Employee> employees;

    public Group() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getCustomers() {
        return employees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(List<Employee> employees) {
        this.employees = employees;
    }
}
