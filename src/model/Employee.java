package org.example.model;
import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String position;
    private double salary;
    private Date joinDate;

    public Employee(int id, String name, String department, String position, double salary, Date joinDate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }

    // ✅ Add this method to print readable employee details
    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + position + " | ₹" + salary + " | " + joinDate;
    }
}
