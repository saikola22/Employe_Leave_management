package dao;

import java.sql.*;
import model.Employee;
import util.DBConnection;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnection.getConnection();
    }

    public void addEmployee(Employee emp) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employee (name, email, department, join_date) VALUES (?, ?, ?, ?)");
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getDepartment());
            ps.setString(4, emp.getJoinDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
