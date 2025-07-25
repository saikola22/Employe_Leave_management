package model;

public class Employee {
    private String name;
    private String email;
    private String department;
    private String joinDate;

    public Employee(String name, String email, String department, String joinDate) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.joinDate = joinDate;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getJoinDate() { return joinDate; }
    public void setJoinDate(String joinDate) { this.joinDate = joinDate; }
}
