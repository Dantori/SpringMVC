package ru.trofimov.springmvcapp.domain;

import java.util.List;

public class Manager {

    private int id;
    private String name;
    private String department;
    private List<Integer> employeesId;

    public Manager(int id, String name, String department, List<Integer> employeesId) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.employeesId = employeesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Integer> getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(List<Integer> employeesId) {
        this.employeesId = employeesId;
    }
}
